package com.tarea.domain.airunstatus.port.repository;

import com.tarea.domain.airunstatus.model.aggregate.AiRunStatus;
import com.tarea.domain.airunstatus.model.valueobject.AiRunStatusId;

import java.util.List;
import java.util.Optional;

public interface AiRunStatusRepository {
    AiRunStatus save(AiRunStatus aiRunStatus);
    Optional<AiRunStatus> findById(AiRunStatusId id);
    List<AiRunStatus> findAll();
    void delete(AiRunStatus aiRunStatus);
}
