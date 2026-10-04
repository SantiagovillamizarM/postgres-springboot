package com.tarea.application.clinicalrecord.usecase;

import com.tarea.application.clinicalrecord.command.UpdateClinicalRecordCommand;
import com.tarea.application.clinicalrecord.dto.ClinicalRecordResponse;
import com.tarea.application.clinicalrecord.exception.ClinicalRecordNotFoundApplicationException;
import com.tarea.domain.clinicalrecord.port.repository.ClinicalRecordRepository;

public class UpdateClinicalRecordUseCase {

    private final ClinicalRecordRepository clinicalRecordRepository;

    public UpdateClinicalRecordUseCase(ClinicalRecordRepository clinicalRecordRepository) {
        this.clinicalRecordRepository = clinicalRecordRepository;
    }

    public ClinicalRecordResponse execute(UpdateClinicalRecordCommand command) {
        var clinicalRecord = clinicalRecordRepository.findById(command.id())
                .orElseThrow(() -> new ClinicalRecordNotFoundApplicationException(command.id().value().toString()));

        clinicalRecord.update(
                command.patientId(),
                command.creationDate(),
                command.recordNumber(),
                command.openedAt(),
                command.closedAt(),
                command.statusId()
        );

        var updated = clinicalRecordRepository.save(clinicalRecord);

        return new ClinicalRecordResponse(
            updated.id().value(),
            updated.patientId().value(),
            updated.creationDate(),
            updated.recordNumber(),
            updated.openedAt(),
            updated.closedAt(),
            updated.statusId().value(),
            updated.createdBy().value(),
            updated.createdAt()
        );
    }
}
