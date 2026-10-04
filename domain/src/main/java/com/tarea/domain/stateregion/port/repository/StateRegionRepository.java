package com.tarea.domain.stateregion.port.repository;

import com.tarea.domain.stateregion.model.aggregate.StateRegion;
import com.tarea.domain.stateregion.model.valueobject.StateRegionId;

import java.util.List;
import java.util.Optional;

public interface StateRegionRepository {
    StateRegion save(StateRegion stateRegion);
    Optional<StateRegion> findById(StateRegionId id);
    List<StateRegion> findAll();
    void delete(StateRegion stateRegion);
}
