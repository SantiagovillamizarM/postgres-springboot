package com.tarea.domain.providermodelai.port.repository;

import com.tarea.domain.providermodelai.model.aggregate.ProviderModelAi;
import com.tarea.domain.providermodelai.model.valueobject.ProviderModelAiId;

import java.util.List;
import java.util.Optional;

public interface ProviderModelAiRepository {
    ProviderModelAi save(ProviderModelAi providerModelAi);
    Optional<ProviderModelAi> findById(ProviderModelAiId id);
    List<ProviderModelAi> findAll();
    void delete(ProviderModelAi providerModelAi);
}
