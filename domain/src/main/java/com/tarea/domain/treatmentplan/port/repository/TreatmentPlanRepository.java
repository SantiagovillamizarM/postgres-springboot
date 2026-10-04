package com.tarea.domain.treatmentplan.port.repository;

import com.tarea.domain.treatmentplan.model.aggregate.TreatmentPlan;
import com.tarea.domain.treatmentplan.model.valueobject.TreatmentPlanId;

import java.util.List;
import java.util.Optional;

public interface TreatmentPlanRepository {
    TreatmentPlan save(TreatmentPlan treatmentPlan);
    Optional<TreatmentPlan> findById(TreatmentPlanId id);
    List<TreatmentPlan> findAll();
    void delete(TreatmentPlan treatmentPlan);
}
