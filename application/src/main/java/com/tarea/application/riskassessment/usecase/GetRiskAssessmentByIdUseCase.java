package com.tarea.application.riskassessment.usecase;

import com.tarea.application.riskassessment.dto.RiskAssessmentResponse;
import com.tarea.application.riskassessment.exception.RiskAssessmentNotFoundApplicationException;
import com.tarea.domain.riskassessment.model.valueobject.RiskAssessmentId;
import com.tarea.domain.riskassessment.port.repository.RiskAssessmentRepository;

public class GetRiskAssessmentByIdUseCase {

    private final RiskAssessmentRepository riskAssessmentRepository;

    public GetRiskAssessmentByIdUseCase(RiskAssessmentRepository riskAssessmentRepository) {
        this.riskAssessmentRepository = riskAssessmentRepository;
    }

    public RiskAssessmentResponse execute(RiskAssessmentId id) {
        var riskAssessment = riskAssessmentRepository.findById(id)
                .orElseThrow(() -> new RiskAssessmentNotFoundApplicationException(id.value().toString()));

        return new RiskAssessmentResponse(
            riskAssessment.id().value(),
            riskAssessment.encounterId().value(),
            riskAssessment.riskLevelId().value(),
            riskAssessment.suicidalIdeation(),
            riskAssessment.suicidePlan(),
            riskAssessment.suicideIntent(),
            riskAssessment.selfHarm(),
            riskAssessment.harmToOthers(),
            riskAssessment.riskFactors(),
            riskAssessment.protectiveFactors(),
            riskAssessment.clinicalActions(),
            riskAssessment.observations(),
            riskAssessment.assessedAt(),
            riskAssessment.assessedBy().value()
        );
    }
}
