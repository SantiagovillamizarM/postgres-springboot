package com.tarea.application.clinicalrecordstatus.usecase;

import com.tarea.application.clinicalrecordstatus.command.RegisterClinicalRecordStatusCommand;
import com.tarea.application.clinicalrecordstatus.dto.ClinicalRecordStatusResponse;
import com.tarea.domain.clinicalrecordstatus.model.aggregate.ClinicalRecordStatus;
import com.tarea.domain.clinicalrecordstatus.port.repository.ClinicalRecordStatusRepository;

public class RegisterClinicalRecordStatusUseCase {

    private final ClinicalRecordStatusRepository clinicalRecordStatusRepository;

    public RegisterClinicalRecordStatusUseCase(ClinicalRecordStatusRepository clinicalRecordStatusRepository) {
        this.clinicalRecordStatusRepository = clinicalRecordStatusRepository;
    }

    public ClinicalRecordStatusResponse execute(RegisterClinicalRecordStatusCommand command) {
        ClinicalRecordStatus clinicalRecordStatus = ClinicalRecordStatus.register(
                command.code(),
                command.name()
        );

        ClinicalRecordStatus saved = clinicalRecordStatusRepository.save(clinicalRecordStatus);

        return new ClinicalRecordStatusResponse(
            saved.id().value(),
            saved.code(),
            saved.name(),
            saved.createdAt(),
            saved.updatedAt()
        );
    }
}
