package com.tarea.domain.treatmentgoalstatus.port.repository;

import com.tarea.domain.treatmentgoalstatus.model.aggregate.TreatmentGoalStatus;
import com.tarea.domain.treatmentgoalstatus.model.valueobject.TreatmentGoalStatusId;

import java.util.List;
import java.util.Optional;

public interface TreatmentGoalStatusRepository {
    TreatmentGoalStatus save(TreatmentGoalStatus treatmentGoalStatus);
    Optional<TreatmentGoalStatus> findById(TreatmentGoalStatusId id);
    List<TreatmentGoalStatus> findAll();
    boolean existsByCode(String code);
    void delete(TreatmentGoalStatus treatmentGoalStatus);
}
