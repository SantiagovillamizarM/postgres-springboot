package com.tarea.infrastructure.aimodel.adapters.out.persistence.mappers;

import com.tarea.domain.providermodelai.model.valueobject.ProviderModelAiId;
import com.tarea.domain.aimodel.model.aggregate.AiModel;
import com.tarea.domain.aimodel.model.valueobject.AiModelId;
import com.tarea.infrastructure.aimodel.adapters.out.persistence.entity.AiModelJpaEntity;

public class AiModelPersistenceMapper {

    public AiModelJpaEntity toJpa(AiModel domain) {
        if (domain == null) {
            return null;
        }

        AiModelJpaEntity jpa = new AiModelJpaEntity();
        jpa.setId(domain.id().value());
        jpa.setProviderModelId(domain.providerModelId().value());
        jpa.setNameModel(domain.nameModel());
        jpa.setModelKey(domain.modelKey());
        jpa.setInputTokenPrice(domain.inputTokenPrice());
        jpa.setOutputTokenPrice(domain.outputTokenPrice());
        jpa.setMaxTokens(domain.maxTokens());
        jpa.setContextWindow(domain.contextWindow());
        jpa.setActive(domain.active());
        jpa.setCreatedAt(domain.createdAt());
        jpa.setUpdatedAt(domain.updatedAt());
        return jpa;
    }

    public AiModel toDomain(AiModelJpaEntity jpa) {
        if (jpa == null) {
            return null;
        }

        return AiModel.restore(
                new AiModelId(jpa.getId()),
                new ProviderModelAiId(jpa.getProviderModelId()),
                jpa.getNameModel(),
                jpa.getModelKey(),
                jpa.getInputTokenPrice(),
                jpa.getOutputTokenPrice(),
                jpa.getMaxTokens(),
                jpa.getContextWindow(),
                jpa.getActive() != null ? jpa.getActive() : true,
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
