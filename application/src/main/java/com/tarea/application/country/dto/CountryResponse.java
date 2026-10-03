package com.tarea.application.country.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record CountryResponse(
        UUID id,
        String nameCountry,
        String codeCountry,
        String description,
        boolean isActive,
        String telephonePrefix,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}