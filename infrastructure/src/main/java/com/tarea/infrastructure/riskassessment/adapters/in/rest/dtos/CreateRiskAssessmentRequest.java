package com.tarea.infrastructure.riskassessment.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record CreateRiskAssessmentRequest(
        @NotNull(message = "El encuentro es obligatorio")
        UUID encounterId,

        @NotNull(message = "El nivel de riesgo es obligatorio")
        UUID riskLevelId,

        Boolean suicidalIdeation,

        Boolean suicidePlan,

        Boolean suicideIntent,

        Boolean selfHarm,

        Boolean harmToOthers,

        String riskFactors,

        String protectiveFactors,

        String clinicalActions,

        String observations,

        LocalDateTime assessedAt,

        @NotNull(message = "El profesional que evalúa es obligatorio")
        UUID assessedBy
) {
}
