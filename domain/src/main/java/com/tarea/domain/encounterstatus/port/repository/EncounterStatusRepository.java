package com.tarea.domain.encounterstatus.port.repository;

import com.tarea.domain.encounterstatus.model.aggregate.EncounterStatus;
import com.tarea.domain.encounterstatus.model.valueobject.EncounterStatusId;

import java.util.List;
import java.util.Optional;

public interface EncounterStatusRepository {
    EncounterStatus save(EncounterStatus encounterStatus);
    Optional<EncounterStatus> findById(EncounterStatusId id);
    List<EncounterStatus> findAll();
    boolean existsByCode(String code);
    void delete(EncounterStatus encounterStatus);
}
