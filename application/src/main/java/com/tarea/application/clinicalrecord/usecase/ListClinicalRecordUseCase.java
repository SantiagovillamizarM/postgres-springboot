package com.tarea.application.clinicalrecord.usecase;

import com.tarea.application.clinicalrecord.dto.ClinicalRecordResponse;
import com.tarea.domain.clinicalrecord.port.repository.ClinicalRecordRepository;

import java.util.List;

public class ListClinicalRecordUseCase {

    private final ClinicalRecordRepository clinicalRecordRepository;

    public ListClinicalRecordUseCase(ClinicalRecordRepository clinicalRecordRepository) {
        this.clinicalRecordRepository = clinicalRecordRepository;
    }

    public List<ClinicalRecordResponse> execute() {
        return clinicalRecordRepository.findAll().stream()
                .map(clinicalRecord -> new ClinicalRecordResponse(
                    clinicalRecord.id().value(),
                    clinicalRecord.patientId().value(),
                    clinicalRecord.creationDate(),
                    clinicalRecord.recordNumber(),
                    clinicalRecord.openedAt(),
                    clinicalRecord.closedAt(),
                    clinicalRecord.statusId().value(),
                    clinicalRecord.createdBy().value(),
                    clinicalRecord.createdAt()
                ))
                .toList();
    }
}
