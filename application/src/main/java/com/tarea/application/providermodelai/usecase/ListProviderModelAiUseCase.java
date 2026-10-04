package com.tarea.application.providermodelai.usecase;

import com.tarea.application.providermodelai.dto.ProviderModelAiResponse;
import com.tarea.domain.providermodelai.port.repository.ProviderModelAiRepository;

import java.util.List;

public class ListProviderModelAiUseCase {

    private final ProviderModelAiRepository providerModelAiRepository;

    public ListProviderModelAiUseCase(ProviderModelAiRepository providerModelAiRepository) {
        this.providerModelAiRepository = providerModelAiRepository;
    }

    public List<ProviderModelAiResponse> execute() {
        return providerModelAiRepository.findAll().stream()
                .map(providerModelAi -> new ProviderModelAiResponse(
                    providerModelAi.id().value(),
                    providerModelAi.nameProviderAi(),
                    providerModelAi.razonSocial(),
                    providerModelAi.sitioWeb(),
                    providerModelAi.active(),
                    providerModelAi.createdAt(),
                    providerModelAi.updatedAt()
                ))
                .toList();
    }
}
