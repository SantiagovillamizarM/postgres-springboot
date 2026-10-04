package com.tarea.application.providermodelai.usecase;

import com.tarea.application.providermodelai.dto.ProviderModelAiResponse;
import com.tarea.application.providermodelai.exception.ProviderModelAiNotFoundApplicationException;
import com.tarea.domain.providermodelai.model.valueobject.ProviderModelAiId;
import com.tarea.domain.providermodelai.port.repository.ProviderModelAiRepository;

public class GetProviderModelAiByIdUseCase {

    private final ProviderModelAiRepository providerModelAiRepository;

    public GetProviderModelAiByIdUseCase(ProviderModelAiRepository providerModelAiRepository) {
        this.providerModelAiRepository = providerModelAiRepository;
    }

    public ProviderModelAiResponse execute(ProviderModelAiId id) {
        var providerModelAi = providerModelAiRepository.findById(id)
                .orElseThrow(() -> new ProviderModelAiNotFoundApplicationException(id.value().toString()));

        return new ProviderModelAiResponse(
            providerModelAi.id().value(),
            providerModelAi.nameProviderAi(),
            providerModelAi.razonSocial(),
            providerModelAi.sitioWeb(),
            providerModelAi.active(),
            providerModelAi.createdAt(),
            providerModelAi.updatedAt()
        );
    }
}
