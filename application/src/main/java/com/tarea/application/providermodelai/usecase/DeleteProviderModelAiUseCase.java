package com.tarea.application.providermodelai.usecase;

import com.tarea.application.providermodelai.exception.ProviderModelAiNotFoundApplicationException;
import com.tarea.domain.providermodelai.model.valueobject.ProviderModelAiId;
import com.tarea.domain.providermodelai.port.repository.ProviderModelAiRepository;

public class DeleteProviderModelAiUseCase {

    private final ProviderModelAiRepository providerModelAiRepository;

    public DeleteProviderModelAiUseCase(ProviderModelAiRepository providerModelAiRepository) {
        this.providerModelAiRepository = providerModelAiRepository;
    }

    public void execute(ProviderModelAiId id) {
        var providerModelAi = providerModelAiRepository.findById(id)
                .orElseThrow(() -> new ProviderModelAiNotFoundApplicationException(id.value().toString()));

        providerModelAi.markAsDeleted();
        providerModelAiRepository.delete(providerModelAi);
    }
}
