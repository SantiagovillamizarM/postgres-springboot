package com.tarea.application.riskassessment.usecase;

import com.tarea.application.riskassessment.dto.RiskAssessmentResponse;
import com.tarea.domain.riskassessment.port.repository.RiskAssessmentRepository;

import java.util.List;

public class ListRiskAssessmentUseCase {

    private final RiskAssessmentRepository riskAssessmentRepository;

    public ListRiskAssessmentUseCase(RiskAssessmentRepository riskAssessmentRepository) {
        this.riskAssessmentRepository = riskAssessmentRepository;
    }

    public List<RiskAssessmentResponse> execute() {
        return riskAssessmentRepository.findAll().stream()
                .map(riskAssessment -> new RiskAssessmentResponse(
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
                ))
                .toList();
    }
}
