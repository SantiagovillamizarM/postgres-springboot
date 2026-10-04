package com.tarea.application.clinicalrecordstatus.usecase;

import com.tarea.application.clinicalrecordstatus.exception.ClinicalRecordStatusNotFoundApplicationException;
import com.tarea.domain.clinicalrecordstatus.model.valueobject.ClinicalRecordStatusId;
import com.tarea.domain.clinicalrecordstatus.port.repository.ClinicalRecordStatusRepository;

public class DeleteClinicalRecordStatusUseCase {

    private final ClinicalRecordStatusRepository clinicalRecordStatusRepository;

    public DeleteClinicalRecordStatusUseCase(ClinicalRecordStatusRepository clinicalRecordStatusRepository) {
        this.clinicalRecordStatusRepository = clinicalRecordStatusRepository;
    }

    public void execute(ClinicalRecordStatusId id) {
        var clinicalRecordStatus = clinicalRecordStatusRepository.findById(id)
                .orElseThrow(() -> new ClinicalRecordStatusNotFoundApplicationException(id.value().toString()));

        clinicalRecordStatus.markAsDeleted();
        clinicalRecordStatusRepository.delete(clinicalRecordStatus);
    }
}
