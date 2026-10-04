package com.tarea.domain.treatmentstatus.port.repository;

import com.tarea.domain.treatmentstatus.model.aggregate.TreatmentStatus;
import com.tarea.domain.treatmentstatus.model.valueobject.TreatmentStatusId;

import java.util.List;
import java.util.Optional;

public interface TreatmentStatusRepository {
    TreatmentStatus save(TreatmentStatus treatmentStatus);
    Optional<TreatmentStatus> findById(TreatmentStatusId id);
    List<TreatmentStatus> findAll();
    boolean existsByCode(String code);
    void delete(TreatmentStatus treatmentStatus);
}
