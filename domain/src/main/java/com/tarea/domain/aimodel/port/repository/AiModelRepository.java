package com.tarea.domain.aimodel.port.repository;

import com.tarea.domain.aimodel.model.aggregate.AiModel;
import com.tarea.domain.aimodel.model.valueobject.AiModelId;

import java.util.List;
import java.util.Optional;

public interface AiModelRepository {
    AiModel save(AiModel aiModel);
    Optional<AiModel> findById(AiModelId id);
    List<AiModel> findAll();
    void delete(AiModel aiModel);
}
