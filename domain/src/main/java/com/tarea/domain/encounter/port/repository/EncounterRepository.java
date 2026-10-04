package com.tarea.domain.encounter.port.repository;

import com.tarea.domain.encounter.model.aggregate.Encounter;
import com.tarea.domain.encounter.model.valueobject.EncounterId;

import java.util.List;
import java.util.Optional;

public interface EncounterRepository {
    Encounter save(Encounter encounter);
    Optional<Encounter> findById(EncounterId id);
    List<Encounter> findAll();
    void delete(Encounter encounter);
}
