package com.tarea.application.riskassessment.command;

import com.tarea.domain.encounter.model.valueobject.EncounterId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.domain.risklevel.model.valueobject.RiskLevelId;
import com.tarea.domain.riskassessment.model.valueobject.RiskAssessmentId;

import java.time.LocalDateTime;

public record UpdateRiskAssessmentCommand(
        RiskAssessmentId id,
        EncounterId encounterId,
        RiskLevelId riskLevelId,
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
        ProfessionalId assessedBy
) {
}
