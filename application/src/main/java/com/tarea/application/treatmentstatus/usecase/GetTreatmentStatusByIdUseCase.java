package com.tarea.application.treatmentstatus.usecase;

import com.tarea.application.treatmentstatus.dto.TreatmentStatusResponse;
import com.tarea.application.treatmentstatus.exception.TreatmentStatusNotFoundApplicationException;
import com.tarea.domain.treatmentstatus.model.valueobject.TreatmentStatusId;
import com.tarea.domain.treatmentstatus.port.repository.TreatmentStatusRepository;

public class GetTreatmentStatusByIdUseCase {

    private final TreatmentStatusRepository treatmentStatusRepository;

    public GetTreatmentStatusByIdUseCase(TreatmentStatusRepository treatmentStatusRepository) {
        this.treatmentStatusRepository = treatmentStatusRepository;
    }

    public TreatmentStatusResponse execute(TreatmentStatusId id) {
        var treatmentStatus = treatmentStatusRepository.findById(id)
                .orElseThrow(() -> new TreatmentStatusNotFoundApplicationException(id.value().toString()));

        return new TreatmentStatusResponse(
            treatmentStatus.id().value(),
            treatmentStatus.code(),
            treatmentStatus.name(),
            treatmentStatus.active(),
            treatmentStatus.createdAt(),
            treatmentStatus.updatedAt()
        );
    }
}
