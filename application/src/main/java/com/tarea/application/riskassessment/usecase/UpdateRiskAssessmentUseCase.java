package com.tarea.application.riskassessment.usecase;

import com.tarea.application.riskassessment.command.UpdateRiskAssessmentCommand;
import com.tarea.application.riskassessment.dto.RiskAssessmentResponse;
import com.tarea.application.riskassessment.exception.RiskAssessmentNotFoundApplicationException;
import com.tarea.domain.riskassessment.port.repository.RiskAssessmentRepository;

public class UpdateRiskAssessmentUseCase {

    private final RiskAssessmentRepository riskAssessmentRepository;

    public UpdateRiskAssessmentUseCase(RiskAssessmentRepository riskAssessmentRepository) {
        this.riskAssessmentRepository = riskAssessmentRepository;
    }

    public RiskAssessmentResponse execute(UpdateRiskAssessmentCommand command) {
        var riskAssessment = riskAssessmentRepository.findById(command.id())
                .orElseThrow(() -> new RiskAssessmentNotFoundApplicationException(command.id().value().toString()));

        riskAssessment.update(
                command.encounterId(),
                command.riskLevelId(),
                command.suicidalIdeation(),
                command.suicidePlan(),
                command.suicideIntent(),
                command.selfHarm(),
                command.harmToOthers(),
                command.riskFactors(),
                command.protectiveFactors(),
                command.clinicalActions(),
                command.observations(),
                command.assessedAt(),
                command.assessedBy()
        );

        var updated = riskAssessmentRepository.save(riskAssessment);

        return new RiskAssessmentResponse(
            updated.id().value(),
            updated.encounterId().value(),
            updated.riskLevelId().value(),
            updated.suicidalIdeation(),
            updated.suicidePlan(),
            updated.suicideIntent(),
            updated.selfHarm(),
            updated.harmToOthers(),
            updated.riskFactors(),
            updated.protectiveFactors(),
            updated.clinicalActions(),
            updated.observations(),
            updated.assessedAt(),
            updated.assessedBy().value()
        );
    }
}
