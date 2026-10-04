package com.tarea.application.treatmentstatus.usecase;

import com.tarea.application.treatmentstatus.command.UpdateTreatmentStatusCommand;
import com.tarea.application.treatmentstatus.dto.TreatmentStatusResponse;
import com.tarea.application.treatmentstatus.exception.TreatmentStatusNotFoundApplicationException;
import com.tarea.domain.treatmentstatus.port.repository.TreatmentStatusRepository;

public class UpdateTreatmentStatusUseCase {

    private final TreatmentStatusRepository treatmentStatusRepository;

    public UpdateTreatmentStatusUseCase(TreatmentStatusRepository treatmentStatusRepository) {
        this.treatmentStatusRepository = treatmentStatusRepository;
    }

    public TreatmentStatusResponse execute(UpdateTreatmentStatusCommand command) {
        var treatmentStatus = treatmentStatusRepository.findById(command.id())
                .orElseThrow(() -> new TreatmentStatusNotFoundApplicationException(command.id().value().toString()));

        treatmentStatus.update(
                command.code(),
                command.name(),
                command.active()
        );

        var updated = treatmentStatusRepository.save(treatmentStatus);

        return new TreatmentStatusResponse(
            updated.id().value(),
            updated.code(),
            updated.name(),
            updated.active(),
            updated.createdAt(),
            updated.updatedAt()
        );
    }
}
