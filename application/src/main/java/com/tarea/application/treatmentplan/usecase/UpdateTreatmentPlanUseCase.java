package com.tarea.application.treatmentplan.usecase;

import com.tarea.application.treatmentplan.command.UpdateTreatmentPlanCommand;
import com.tarea.application.treatmentplan.dto.TreatmentPlanResponse;
import com.tarea.application.treatmentplan.exception.TreatmentPlanNotFoundApplicationException;
import com.tarea.domain.treatmentplan.port.repository.TreatmentPlanRepository;

public class UpdateTreatmentPlanUseCase {

    private final TreatmentPlanRepository treatmentPlanRepository;

    public UpdateTreatmentPlanUseCase(TreatmentPlanRepository treatmentPlanRepository) {
        this.treatmentPlanRepository = treatmentPlanRepository;
    }

    public TreatmentPlanResponse execute(UpdateTreatmentPlanCommand command) {
        var treatmentPlan = treatmentPlanRepository.findById(command.id())
                .orElseThrow(() -> new TreatmentPlanNotFoundApplicationException(command.id().value().toString()));

        treatmentPlan.update(
                command.encounterId(),
                command.professionalId(),
                command.title(),
                command.description(),
                command.startDate(),
                command.endDate(),
                command.treatmentStatusId()
        );

        var updated = treatmentPlanRepository.save(treatmentPlan);

        return new TreatmentPlanResponse(
            updated.id().value(),
            updated.encounterId().value(),
            updated.professionalId().value(),
            updated.title(),
            updated.description(),
            updated.startDate(),
            updated.endDate(),
            updated.treatmentStatusId().value(),
            updated.createdAt(),
            updated.updatedAt()
        );
    }
}
