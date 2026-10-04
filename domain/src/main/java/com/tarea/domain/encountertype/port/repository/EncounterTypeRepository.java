package com.tarea.domain.encountertype.port.repository;

import com.tarea.domain.encountertype.model.aggregate.EncounterType;
import com.tarea.domain.encountertype.model.valueobject.EncounterTypeId;

import java.util.List;
import java.util.Optional;

public interface EncounterTypeRepository {
    EncounterType save(EncounterType encounterType);
    Optional<EncounterType> findById(EncounterTypeId id);
    List<EncounterType> findAll();
    boolean existsByCode(String code);
    void delete(EncounterType encounterType);
}
