package com.tarea.application.treatmentgoal.usecase;

import com.tarea.application.treatmentgoal.dto.TreatmentGoalResponse;
import com.tarea.application.treatmentgoal.exception.TreatmentGoalNotFoundApplicationException;
import com.tarea.domain.treatmentgoal.model.valueobject.TreatmentGoalId;
import com.tarea.domain.treatmentgoal.port.repository.TreatmentGoalRepository;

public class GetTreatmentGoalByIdUseCase {

    private final TreatmentGoalRepository treatmentGoalRepository;

    public GetTreatmentGoalByIdUseCase(TreatmentGoalRepository treatmentGoalRepository) {
        this.treatmentGoalRepository = treatmentGoalRepository;
    }

    public TreatmentGoalResponse execute(TreatmentGoalId id) {
        var treatmentGoal = treatmentGoalRepository.findById(id)
                .orElseThrow(() -> new TreatmentGoalNotFoundApplicationException(id.value().toString()));

        return new TreatmentGoalResponse(
            treatmentGoal.id().value(),
            treatmentGoal.treatmentPlanId().value(),
            treatmentGoal.description(),
            treatmentGoal.targetDate(),
            treatmentGoal.completedAt(),
            treatmentGoal.notes(),
            treatmentGoal.goalStatusId().value(),
            treatmentGoal.createdAt(),
            treatmentGoal.updatedAt()
        );
    }
}
