package com.tarea.domain.gender.port.repository;

import com.tarea.domain.gender.model.aggregate.Gender;
import com.tarea.domain.gender.model.valueobject.GenderId;

import java.util.List;
import java.util.Optional;

public interface GenderRepository {
    Gender save(Gender gender);
    Optional<Gender> findById(GenderId id);
    List<Gender> findAll();
    boolean existsByDescription(String description);
    void delete(Gender gender);
}
