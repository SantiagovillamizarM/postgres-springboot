package com.tarea.domain.encountermodality.port.repository;

import com.tarea.domain.encountermodality.model.aggregate.EncounterModality;
import com.tarea.domain.encountermodality.model.valueobject.EncounterModalityId;

import java.util.List;
import java.util.Optional;

public interface EncounterModalityRepository {
    EncounterModality save(EncounterModality encounterModality);
    Optional<EncounterModality> findById(EncounterModalityId id);
    List<EncounterModality> findAll();
    boolean existsByCode(String code);
    void delete(EncounterModality encounterModality);
}
