package com.brazcubas.apsii.repository;

import com.brazcubas.apsii.model.Forecast;
import com.brazcubas.apsii.model.PredictionModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.core.io.DefaultResourceLoader;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CsvForecastRepositoryTest {

    private ModelRepository modelRepositoryMock;
    private CsvForecastRepository repository;

    @BeforeEach
    void setUp() {
        modelRepositoryMock = Mockito.mock(ModelRepository.class);

        PredictionModel modelA = new PredictionModel(
                "model-a", "Model A", "1.0", "Descrição A", "Vendor A", "type-a", true, Instant.now()
        );
        PredictionModel modelB = new PredictionModel(
                "model-b", "Model B", "1.0", "Descrição B", "Vendor B", "type-b", true, Instant.now()
        );

        // O repositório consulta findAll() para validar os modelos registrados durante o load()
        when(modelRepositoryMock.findAll()).thenReturn(List.of(modelA, modelB));
        when(modelRepositoryMock.findById("model-a")).thenReturn(Optional.of(modelA));
        when(modelRepositoryMock.findById("model-b")).thenReturn(Optional.of(modelB));

        // Inicializa o CsvForecastRepository apontando para o arquivo de teste
        repository = new CsvForecastRepository(
                new DefaultResourceLoader(),
                modelRepositoryMock,
                "classpath:data-test/predictions-11-2.csv"
        );

        repository.load();
    }

    @Test
    @DisplayName("Deve validar a leitura e regras do campo opcional model_confidence via interface pública")
    void testModelConfidenceRules() {
        // 1. Garante que os registros válidos foram carregados e as linhas inválidas foram descartadas
        List<Forecast> allForecasts = repository.findAll();
        assertNotNull(allForecasts, "A lista de previsões não deve ser nula.");
        assertFalse(allForecasts.isEmpty(), "A lista de previsões deve conter os registros válidos.");

        // 2. Garante a consulta pública por modelo e probe
        List<Forecast> forecasts = repository.findByModelAndProbe("model-a", 900001);
        assertFalse(forecasts.isEmpty(), "Deve encontrar previsões válidas para model-a e probe 900001.");

        // 3. Valida se as regras de filtro da confiança foram aplicadas na montagem dos objetos
        for (Forecast forecast : forecasts) {
            Double confidence = forecast.modelConfidence();
            if (confidence != null) {
                assertTrue(confidence >= 0.0 && confidence <= 1.0,
                        "O valor de confiança aceito deve estar entre 0.0 e 1.0, mas foi: " + confidence);
            }
        }
    }
}
