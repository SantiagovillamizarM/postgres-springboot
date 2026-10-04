package com.tarea.application.risklevel.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record RiskLevelResponse(
        UUID id,
        String code,
        String name,
        boolean active,
        Integer severity,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
