package com.tarea.application.treatmentstatus.usecase;

import com.tarea.application.treatmentstatus.exception.TreatmentStatusNotFoundApplicationException;
import com.tarea.domain.treatmentstatus.model.valueobject.TreatmentStatusId;
import com.tarea.domain.treatmentstatus.port.repository.TreatmentStatusRepository;

public class DeleteTreatmentStatusUseCase {

    private final TreatmentStatusRepository treatmentStatusRepository;

    public DeleteTreatmentStatusUseCase(TreatmentStatusRepository treatmentStatusRepository) {
        this.treatmentStatusRepository = treatmentStatusRepository;
    }

    public void execute(TreatmentStatusId id) {
        var treatmentStatus = treatmentStatusRepository.findById(id)
                .orElseThrow(() -> new TreatmentStatusNotFoundApplicationException(id.value().toString()));

        treatmentStatus.markAsDeleted();
        treatmentStatusRepository.delete(treatmentStatus);
    }
}
