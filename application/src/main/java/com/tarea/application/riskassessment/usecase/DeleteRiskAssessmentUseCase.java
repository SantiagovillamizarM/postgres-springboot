package com.tarea.application.riskassessment.usecase;

import com.tarea.application.riskassessment.exception.RiskAssessmentNotFoundApplicationException;
import com.tarea.domain.riskassessment.model.valueobject.RiskAssessmentId;
import com.tarea.domain.riskassessment.port.repository.RiskAssessmentRepository;

public class DeleteRiskAssessmentUseCase {

    private final RiskAssessmentRepository riskAssessmentRepository;

    public DeleteRiskAssessmentUseCase(RiskAssessmentRepository riskAssessmentRepository) {
        this.riskAssessmentRepository = riskAssessmentRepository;
    }

    public void execute(RiskAssessmentId id) {
        var riskAssessment = riskAssessmentRepository.findById(id)
                .orElseThrow(() -> new RiskAssessmentNotFoundApplicationException(id.value().toString()));

        riskAssessment.markAsDeleted();
        riskAssessmentRepository.delete(riskAssessment);
    }
}
