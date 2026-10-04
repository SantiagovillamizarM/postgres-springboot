package com.tarea.infrastructure.providermodelai.adapters.out.persistence.repositories;

import com.tarea.infrastructure.providermodelai.adapters.out.persistence.entity.ProviderModelAiJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProviderModelAiJpaRepository extends JpaRepository<ProviderModelAiJpaEntity, UUID> {}
