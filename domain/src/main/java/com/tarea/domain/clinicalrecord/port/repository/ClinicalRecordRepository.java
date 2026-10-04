package com.tarea.domain.clinicalrecord.port.repository;

import com.tarea.domain.clinicalrecord.model.aggregate.ClinicalRecord;
import com.tarea.domain.clinicalrecord.model.valueobject.ClinicalRecordId;

import java.util.List;
import java.util.Optional;

public interface ClinicalRecordRepository {
    ClinicalRecord save(ClinicalRecord clinicalRecord);
    Optional<ClinicalRecord> findById(ClinicalRecordId id);
    List<ClinicalRecord> findAll();
    void delete(ClinicalRecord clinicalRecord);
}
