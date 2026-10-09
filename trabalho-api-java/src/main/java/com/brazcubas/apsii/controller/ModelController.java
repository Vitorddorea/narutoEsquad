package com.brazcubas.apsii.controller;

import com.brazcubas.apsii.model.ApiDtos;
import com.brazcubas.apsii.service.ModelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

/**
 * Endpoints do catálogo de modelos preditivos.
 */
@RestController
@RequestMapping("/api/v1/models")
@Tag(name = "Models")
public class ModelController {
    private final ModelService modelService;

    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @Operation(summary = "List models")
    @GetMapping
    public ApiDtos.ModelsResponse list() {
        return modelService.listActive();
    }

    @Operation(
            summary = "Get model",
            description = "Returns the details of a prediction model identified by its ID.",
            parameters = {
                    @Parameter(
                            name = "model_id",
                            description = "Unique identifier of the prediction model.",
                            required = true
                    )
            }
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Model found",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ApiDtos.ModelDetail.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Model not found",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ApiDtos.ErrorResponse.class)
                    )
            )
    })
    @GetMapping("/{model_id}")
    public ApiDtos.ModelDetail get(@PathVariable("model_id") String modelId) {
        return modelService.get(modelId);
    }
}
