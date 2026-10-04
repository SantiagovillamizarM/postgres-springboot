package com.tarea.application.clinicalrecordstatus.usecase;

import com.tarea.application.clinicalrecordstatus.command.UpdateClinicalRecordStatusCommand;
import com.tarea.application.clinicalrecordstatus.dto.ClinicalRecordStatusResponse;
import com.tarea.application.clinicalrecordstatus.exception.ClinicalRecordStatusNotFoundApplicationException;
import com.tarea.domain.clinicalrecordstatus.port.repository.ClinicalRecordStatusRepository;

public class UpdateClinicalRecordStatusUseCase {

    private final ClinicalRecordStatusRepository clinicalRecordStatusRepository;

    public UpdateClinicalRecordStatusUseCase(ClinicalRecordStatusRepository clinicalRecordStatusRepository) {
        this.clinicalRecordStatusRepository = clinicalRecordStatusRepository;
    }

    public ClinicalRecordStatusResponse execute(UpdateClinicalRecordStatusCommand command) {
        var clinicalRecordStatus = clinicalRecordStatusRepository.findById(command.id())
                .orElseThrow(() -> new ClinicalRecordStatusNotFoundApplicationException(command.id().value().toString()));

        clinicalRecordStatus.update(
                command.code(),
                command.name()
        );

        var updated = clinicalRecordStatusRepository.save(clinicalRecordStatus);

        return new ClinicalRecordStatusResponse(
            updated.id().value(),
            updated.code(),
            updated.name(),
            updated.createdAt(),
            updated.updatedAt()
        );
    }
}
