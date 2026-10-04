package com.tarea.application.treatmentgoal.usecase;

import com.tarea.application.treatmentgoal.exception.TreatmentGoalNotFoundApplicationException;
import com.tarea.domain.treatmentgoal.model.valueobject.TreatmentGoalId;
import com.tarea.domain.treatmentgoal.port.repository.TreatmentGoalRepository;

public class DeleteTreatmentGoalUseCase {

    private final TreatmentGoalRepository treatmentGoalRepository;

    public DeleteTreatmentGoalUseCase(TreatmentGoalRepository treatmentGoalRepository) {
        this.treatmentGoalRepository = treatmentGoalRepository;
    }

    public void execute(TreatmentGoalId id) {
        var treatmentGoal = treatmentGoalRepository.findById(id)
                .orElseThrow(() -> new TreatmentGoalNotFoundApplicationException(id.value().toString()));

        treatmentGoal.markAsDeleted();
        treatmentGoalRepository.delete(treatmentGoal);
    }
}
