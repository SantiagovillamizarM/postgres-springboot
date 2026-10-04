package com.tarea.domain.clinicalrecordstatus.port.repository;

import com.tarea.domain.clinicalrecordstatus.model.aggregate.ClinicalRecordStatus;
import com.tarea.domain.clinicalrecordstatus.model.valueobject.ClinicalRecordStatusId;

import java.util.List;
import java.util.Optional;

public interface ClinicalRecordStatusRepository {
    ClinicalRecordStatus save(ClinicalRecordStatus clinicalRecordStatus);
    Optional<ClinicalRecordStatus> findById(ClinicalRecordStatusId id);
    List<ClinicalRecordStatus> findAll();
    boolean existsByCode(String code);
    void delete(ClinicalRecordStatus clinicalRecordStatus);
}
