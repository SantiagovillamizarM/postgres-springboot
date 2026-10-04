package com.tarea.application.consenttype.usecase;

import com.tarea.application.consenttype.command.RegisterConsentTypeCommand;
import com.tarea.application.consenttype.dto.ConsentTypeResponse;
import com.tarea.domain.consenttype.model.aggregate.ConsentType;
import com.tarea.domain.consenttype.port.repository.ConsentTypeRepository;

public class RegisterConsentTypeUseCase {

    private final ConsentTypeRepository consentTypeRepository;

    public RegisterConsentTypeUseCase(ConsentTypeRepository consentTypeRepository) {
        this.consentTypeRepository = consentTypeRepository;
    }

    public ConsentTypeResponse execute(RegisterConsentTypeCommand command) {
        ConsentType consentType = ConsentType.register(
                command.code(),
                command.name(),
                command.active(),
                command.description()
        );

        ConsentType saved = consentTypeRepository.save(consentType);

        return new ConsentTypeResponse(
            saved.id().value(),
            saved.code(),
            saved.name(),
            saved.active(),
            saved.description(),
            saved.createdAt(),
            saved.updatedAt()
        );
    }
}
