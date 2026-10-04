package com.tarea.application.clinicalrecord.usecase;

import com.tarea.application.clinicalrecord.exception.ClinicalRecordNotFoundApplicationException;
import com.tarea.domain.clinicalrecord.model.valueobject.ClinicalRecordId;
import com.tarea.domain.clinicalrecord.port.repository.ClinicalRecordRepository;

public class DeleteClinicalRecordUseCase {

    private final ClinicalRecordRepository clinicalRecordRepository;

    public DeleteClinicalRecordUseCase(ClinicalRecordRepository clinicalRecordRepository) {
        this.clinicalRecordRepository = clinicalRecordRepository;
    }

    public void execute(ClinicalRecordId id) {
        var clinicalRecord = clinicalRecordRepository.findById(id)
                .orElseThrow(() -> new ClinicalRecordNotFoundApplicationException(id.value().toString()));

        clinicalRecord.markAsDeleted();
        clinicalRecordRepository.delete(clinicalRecord);
    }
}
