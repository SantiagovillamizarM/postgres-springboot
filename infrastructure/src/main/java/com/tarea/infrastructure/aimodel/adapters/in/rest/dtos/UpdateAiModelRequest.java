package com.tarea.infrastructure.aimodel.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.UUID;

public record UpdateAiModelRequest(
        @NotNull(message = "El proveedor es obligatorio")
        UUID providerModelId,

        @Size(max = 100, message = "El nombre del modelo no puede superar los 100 caracteres")
        String nameModel,

        @Size(max = 120, message = "La clave del modelo no puede superar los 120 caracteres")
        String modelKey,

        BigDecimal inputTokenPrice,

        BigDecimal outputTokenPrice,

        Integer maxTokens,

        Integer contextWindow,

        Boolean active
) {
}
