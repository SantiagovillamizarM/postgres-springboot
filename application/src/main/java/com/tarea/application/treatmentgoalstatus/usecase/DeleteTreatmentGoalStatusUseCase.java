package com.tarea.application.treatmentgoalstatus.usecase;

import com.tarea.application.treatmentgoalstatus.exception.TreatmentGoalStatusNotFoundApplicationException;
import com.tarea.domain.treatmentgoalstatus.model.valueobject.TreatmentGoalStatusId;
import com.tarea.domain.treatmentgoalstatus.port.repository.TreatmentGoalStatusRepository;

public class DeleteTreatmentGoalStatusUseCase {

    private final TreatmentGoalStatusRepository treatmentGoalStatusRepository;

    public DeleteTreatmentGoalStatusUseCase(TreatmentGoalStatusRepository treatmentGoalStatusRepository) {
        this.treatmentGoalStatusRepository = treatmentGoalStatusRepository;
    }

    public void execute(TreatmentGoalStatusId id) {
        var treatmentGoalStatus = treatmentGoalStatusRepository.findById(id)
                .orElseThrow(() -> new TreatmentGoalStatusNotFoundApplicationException(id.value().toString()));

        treatmentGoalStatus.markAsDeleted();
        treatmentGoalStatusRepository.delete(treatmentGoalStatus);
    }
}
