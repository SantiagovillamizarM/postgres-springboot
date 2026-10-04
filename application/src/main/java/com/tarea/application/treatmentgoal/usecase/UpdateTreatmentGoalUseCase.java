package com.tarea.application.treatmentgoal.usecase;

import com.tarea.application.treatmentgoal.command.UpdateTreatmentGoalCommand;
import com.tarea.application.treatmentgoal.dto.TreatmentGoalResponse;
import com.tarea.application.treatmentgoal.exception.TreatmentGoalNotFoundApplicationException;
import com.tarea.domain.treatmentgoal.port.repository.TreatmentGoalRepository;

public class UpdateTreatmentGoalUseCase {

    private final TreatmentGoalRepository treatmentGoalRepository;

    public UpdateTreatmentGoalUseCase(TreatmentGoalRepository treatmentGoalRepository) {
        this.treatmentGoalRepository = treatmentGoalRepository;
    }

    public TreatmentGoalResponse execute(UpdateTreatmentGoalCommand command) {
        var treatmentGoal = treatmentGoalRepository.findById(command.id())
                .orElseThrow(() -> new TreatmentGoalNotFoundApplicationException(command.id().value().toString()));

        treatmentGoal.update(
                command.treatmentPlanId(),
                command.description(),
                command.targetDate(),
                command.completedAt(),
                command.notes(),
                command.goalStatusId()
        );

        var updated = treatmentGoalRepository.save(treatmentGoal);

        return new TreatmentGoalResponse(
            updated.id().value(),
            updated.treatmentPlanId().value(),
            updated.description(),
            updated.targetDate(),
            updated.completedAt(),
            updated.notes(),
            updated.goalStatusId().value(),
            updated.createdAt(),
            updated.updatedAt()
        );
    }
}
