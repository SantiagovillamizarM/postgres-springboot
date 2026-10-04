package com.tarea.application.treatmentstatus.usecase;

import com.tarea.application.treatmentstatus.command.RegisterTreatmentStatusCommand;
import com.tarea.application.treatmentstatus.dto.TreatmentStatusResponse;
import com.tarea.domain.treatmentstatus.model.aggregate.TreatmentStatus;
import com.tarea.domain.treatmentstatus.port.repository.TreatmentStatusRepository;

public class RegisterTreatmentStatusUseCase {

    private final TreatmentStatusRepository treatmentStatusRepository;

    public RegisterTreatmentStatusUseCase(TreatmentStatusRepository treatmentStatusRepository) {
        this.treatmentStatusRepository = treatmentStatusRepository;
    }

    public TreatmentStatusResponse execute(RegisterTreatmentStatusCommand command) {
        TreatmentStatus treatmentStatus = TreatmentStatus.register(
                command.code(),
                command.name(),
                command.active()
        );

        TreatmentStatus saved = treatmentStatusRepository.save(treatmentStatus);

        return new TreatmentStatusResponse(
            saved.id().value(),
            saved.code(),
            saved.name(),
            saved.active(),
            saved.createdAt(),
            saved.updatedAt()
        );
    }
}
