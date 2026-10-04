package com.tarea.application.providermodelai.usecase;

import com.tarea.application.providermodelai.command.RegisterProviderModelAiCommand;
import com.tarea.application.providermodelai.dto.ProviderModelAiResponse;
import com.tarea.domain.providermodelai.model.aggregate.ProviderModelAi;
import com.tarea.domain.providermodelai.port.repository.ProviderModelAiRepository;

public class RegisterProviderModelAiUseCase {

    private final ProviderModelAiRepository providerModelAiRepository;

    public RegisterProviderModelAiUseCase(ProviderModelAiRepository providerModelAiRepository) {
        this.providerModelAiRepository = providerModelAiRepository;
    }

    public ProviderModelAiResponse execute(RegisterProviderModelAiCommand command) {
        ProviderModelAi providerModelAi = ProviderModelAi.register(
                command.nameProviderAi(),
                command.razonSocial(),
                command.sitioWeb(),
                command.active()
        );

        ProviderModelAi saved = providerModelAiRepository.save(providerModelAi);

        return new ProviderModelAiResponse(
            saved.id().value(),
            saved.nameProviderAi(),
            saved.razonSocial(),
            saved.sitioWeb(),
            saved.active(),
            saved.createdAt(),
            saved.updatedAt()
        );
    }
}
