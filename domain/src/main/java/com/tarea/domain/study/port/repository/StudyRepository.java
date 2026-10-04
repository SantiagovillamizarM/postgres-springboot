package com.tarea.domain.study.port.repository;

import com.tarea.domain.study.model.aggregate.Study;
import com.tarea.domain.study.model.valueobject.StudyId;

import java.util.List;
import java.util.Optional;

public interface StudyRepository {
    Study save(Study study);
    Optional<Study> findById(StudyId id);
    List<Study> findAll();
    void delete(Study study);
}
