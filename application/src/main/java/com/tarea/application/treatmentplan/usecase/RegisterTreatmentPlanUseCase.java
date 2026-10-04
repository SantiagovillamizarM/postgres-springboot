package com.tarea.application.treatmentplan.usecase;

import com.tarea.application.treatmentplan.command.RegisterTreatmentPlanCommand;
import com.tarea.application.treatmentplan.dto.TreatmentPlanResponse;
import com.tarea.domain.treatmentplan.model.aggregate.TreatmentPlan;
import com.tarea.domain.treatmentplan.port.repository.TreatmentPlanRepository;

public class RegisterTreatmentPlanUseCase {

    private final TreatmentPlanRepository treatmentPlanRepository;

    public RegisterTreatmentPlanUseCase(TreatmentPlanRepository treatmentPlanRepository) {
        this.treatmentPlanRepository = treatmentPlanRepository;
    }

    public TreatmentPlanResponse execute(RegisterTreatmentPlanCommand command) {
        TreatmentPlan treatmentPlan = TreatmentPlan.register(
                command.encounterId(),
                command.professionalId(),
                command.title(),
                command.description(),
                command.startDate(),
                command.endDate(),
                command.treatmentStatusId()
        );

        TreatmentPlan saved = treatmentPlanRepository.save(treatmentPlan);

        return new TreatmentPlanResponse(
            saved.id().value(),
            saved.encounterId().value(),
            saved.professionalId().value(),
            saved.title(),
            saved.description(),
            saved.startDate(),
            saved.endDate(),
            saved.treatmentStatusId().value(),
            saved.createdAt(),
            saved.updatedAt()
        );
    }
}
