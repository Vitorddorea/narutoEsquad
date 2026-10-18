package com.brazcubas.apsii.config;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.format.DateTimeParseException;
esse é o codgio o que eu teria q fazer para ter a pull request?

import static java.time.Instant.parse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DateTimeUtilsTest {

    @Test
    public void deveInterpretarInstant() {
        // Arrange
        String value = "2026-10-15T23:00:00Z";

        // Act
        Instant result = DateTimeUtils.parseUtc(value);

        // Assert
        assertEquals(parse(value), result);
    }

    @Test
    public void deveInterpretarOffsetDateTime() {
        // Arrange
        String value = "2026-10-15T20:00:00-03:00";

        // Act
        Instant result = DateTimeUtils.parseUtc(value);

        // Assert
        assertEquals(parse("2026-10-15T23:00:00Z"), result);
    }

    @Test
    public void deveInterpretarLocalDateTimeComoUtc() {
        // Arrange
        String value = "2026-10-15T20:00:00";

        // Act
        Instant result = DateTimeUtils.parseUtc(value);

        // Assert
        assertEquals(parse("2026-10-15T20:00:00Z"), result);
    }

    @Test
    public void deveLancarExcecaoQuandoDataForInvalida() {
        // Arrange
        String value = "data-invalida";

        // Act + Assert
        assertThrows(
                DateTimeParseException.class,
                () -> DateTimeUtils.parseUtc(value)
        );
    }
}
