package com.tarea.domain.medicationroute.port.repository;

import com.tarea.domain.medicationroute.model.aggregate.MedicationRoute;
import com.tarea.domain.medicationroute.model.valueobject.MedicationRouteId;

import java.util.List;
import java.util.Optional;

public interface MedicationRouteRepository {
    MedicationRoute save(MedicationRoute medicationRoute);
    Optional<MedicationRoute> findById(MedicationRouteId id);
    List<MedicationRoute> findAll();
    boolean existsByCode(String code);
    void delete(MedicationRoute medicationRoute);
}
