package com.tarea.domain.treatmentgoal.port.repository;

import com.tarea.domain.treatmentgoal.model.aggregate.TreatmentGoal;
import com.tarea.domain.treatmentgoal.model.valueobject.TreatmentGoalId;

import java.util.List;
import java.util.Optional;

public interface TreatmentGoalRepository {
    TreatmentGoal save(TreatmentGoal treatmentGoal);
    Optional<TreatmentGoal> findById(TreatmentGoalId id);
    List<TreatmentGoal> findAll();
    void delete(TreatmentGoal treatmentGoal);
}
