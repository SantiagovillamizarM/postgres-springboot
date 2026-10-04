package com.tarea.application.clinicalrecord.usecase;

import com.tarea.application.clinicalrecord.command.RegisterClinicalRecordCommand;
import com.tarea.application.clinicalrecord.dto.ClinicalRecordResponse;
import com.tarea.domain.clinicalrecord.model.aggregate.ClinicalRecord;
import com.tarea.domain.clinicalrecord.port.repository.ClinicalRecordRepository;

public class RegisterClinicalRecordUseCase {

    private final ClinicalRecordRepository clinicalRecordRepository;

    public RegisterClinicalRecordUseCase(ClinicalRecordRepository clinicalRecordRepository) {
        this.clinicalRecordRepository = clinicalRecordRepository;
    }

    public ClinicalRecordResponse execute(RegisterClinicalRecordCommand command) {
        ClinicalRecord clinicalRecord = ClinicalRecord.register(
                command.patientId(),
                command.creationDate(),
                command.recordNumber(),
                command.openedAt(),
                command.closedAt(),
                command.statusId(),
                command.createdBy()
        );

        ClinicalRecord saved = clinicalRecordRepository.save(clinicalRecord);

        return new ClinicalRecordResponse(
            saved.id().value(),
            saved.patientId().value(),
            saved.creationDate(),
            saved.recordNumber(),
            saved.openedAt(),
            saved.closedAt(),
            saved.statusId().value(),
            saved.createdBy().value(),
            saved.createdAt()
        );
    }
}
