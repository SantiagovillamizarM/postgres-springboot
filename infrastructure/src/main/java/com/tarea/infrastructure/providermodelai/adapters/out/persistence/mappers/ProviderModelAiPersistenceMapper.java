package com.tarea.infrastructure.providermodelai.adapters.out.persistence.mappers;

import com.tarea.domain.providermodelai.model.aggregate.ProviderModelAi;
import com.tarea.domain.providermodelai.model.valueobject.ProviderModelAiId;
import com.tarea.infrastructure.providermodelai.adapters.out.persistence.entity.ProviderModelAiJpaEntity;

public class ProviderModelAiPersistenceMapper {

    public ProviderModelAiJpaEntity toJpa(ProviderModelAi domain) {
        if (domain == null) {
            return null;
        }

        ProviderModelAiJpaEntity jpa = new ProviderModelAiJpaEntity();
        jpa.setId(domain.id().value());
        jpa.setNameProviderAi(domain.nameProviderAi());
        jpa.setRazonSocial(domain.razonSocial());
        jpa.setSitioWeb(domain.sitioWeb());
        jpa.setActive(domain.active());
        jpa.setCreatedAt(domain.createdAt());
        jpa.setUpdatedAt(domain.updatedAt());
        return jpa;
    }

    public ProviderModelAi toDomain(ProviderModelAiJpaEntity jpa) {
        if (jpa == null) {
            return null;
        }

        return ProviderModelAi.restore(
                new ProviderModelAiId(jpa.getId()),
                jpa.getNameProviderAi(),
                jpa.getRazonSocial(),
                jpa.getSitioWeb(),
                jpa.getActive() != null ? jpa.getActive() : true,
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
