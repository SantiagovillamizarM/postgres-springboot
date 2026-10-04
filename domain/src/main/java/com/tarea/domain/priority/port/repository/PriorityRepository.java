package com.tarea.domain.priority.port.repository;

import com.tarea.domain.priority.model.aggregate.Priority;
import com.tarea.domain.priority.model.valueobject.PriorityId;

import java.util.List;
import java.util.Optional;

public interface PriorityRepository {
    Priority save(Priority priority);
    Optional<Priority> findById(PriorityId id);
    List<Priority> findAll();
    void delete(Priority priority);
}
