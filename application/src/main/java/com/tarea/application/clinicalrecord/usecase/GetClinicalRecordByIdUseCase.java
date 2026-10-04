package com.tarea.application.clinicalrecord.usecase;

import com.tarea.application.clinicalrecord.dto.ClinicalRecordResponse;
import com.tarea.application.clinicalrecord.exception.ClinicalRecordNotFoundApplicationException;
import com.tarea.domain.clinicalrecord.model.valueobject.ClinicalRecordId;
import com.tarea.domain.clinicalrecord.port.repository.ClinicalRecordRepository;

public class GetClinicalRecordByIdUseCase {

    private final ClinicalRecordRepository clinicalRecordRepository;

    public GetClinicalRecordByIdUseCase(ClinicalRecordRepository clinicalRecordRepository) {
        this.clinicalRecordRepository = clinicalRecordRepository;
    }

    public ClinicalRecordResponse execute(ClinicalRecordId id) {
        var clinicalRecord = clinicalRecordRepository.findById(id)
                .orElseThrow(() -> new ClinicalRecordNotFoundApplicationException(id.value().toString()));

        return new ClinicalRecordResponse(
            clinicalRecord.id().value(),
            clinicalRecord.patientId().value(),
            clinicalRecord.creationDate(),
            clinicalRecord.recordNumber(),
            clinicalRecord.openedAt(),
            clinicalRecord.closedAt(),
            clinicalRecord.statusId().value(),
            clinicalRecord.createdBy().value(),
            clinicalRecord.createdAt()
        );
    }
}
