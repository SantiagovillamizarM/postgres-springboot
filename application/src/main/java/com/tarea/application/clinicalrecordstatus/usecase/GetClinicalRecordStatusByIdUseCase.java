package com.tarea.application.clinicalrecordstatus.usecase;

import com.tarea.application.clinicalrecordstatus.dto.ClinicalRecordStatusResponse;
import com.tarea.application.clinicalrecordstatus.exception.ClinicalRecordStatusNotFoundApplicationException;
import com.tarea.domain.clinicalrecordstatus.model.valueobject.ClinicalRecordStatusId;
import com.tarea.domain.clinicalrecordstatus.port.repository.ClinicalRecordStatusRepository;

public class GetClinicalRecordStatusByIdUseCase {

    private final ClinicalRecordStatusRepository clinicalRecordStatusRepository;

    public GetClinicalRecordStatusByIdUseCase(ClinicalRecordStatusRepository clinicalRecordStatusRepository) {
        this.clinicalRecordStatusRepository = clinicalRecordStatusRepository;
    }

    public ClinicalRecordStatusResponse execute(ClinicalRecordStatusId id) {
        var clinicalRecordStatus = clinicalRecordStatusRepository.findById(id)
                .orElseThrow(() -> new ClinicalRecordStatusNotFoundApplicationException(id.value().toString()));

        return new ClinicalRecordStatusResponse(
            clinicalRecordStatus.id().value(),
            clinicalRecordStatus.code(),
            clinicalRecordStatus.name(),
            clinicalRecordStatus.createdAt(),
            clinicalRecordStatus.updatedAt()
        );
    }
}
