package com.tarea.application.consenttype.usecase;

import com.tarea.application.consenttype.command.UpdateConsentTypeCommand;
import com.tarea.application.consenttype.dto.ConsentTypeResponse;
import com.tarea.application.consenttype.exception.ConsentTypeNotFoundApplicationException;
import com.tarea.domain.consenttype.port.repository.ConsentTypeRepository;

public class UpdateConsentTypeUseCase {

    private final ConsentTypeRepository consentTypeRepository;

    public UpdateConsentTypeUseCase(ConsentTypeRepository consentTypeRepository) {
        this.consentTypeRepository = consentTypeRepository;
    }

    public ConsentTypeResponse execute(UpdateConsentTypeCommand command) {
        var consentType = consentTypeRepository.findById(command.id())
                .orElseThrow(() -> new ConsentTypeNotFoundApplicationException(command.id().value().toString()));

        consentType.update(
                command.code(),
                command.name(),
                command.active(),
                command.description()
        );

        var updated = consentTypeRepository.save(consentType);

        return new ConsentTypeResponse(
            updated.id().value(),
            updated.code(),
            updated.name(),
            updated.active(),
            updated.description(),
            updated.createdAt(),
            updated.updatedAt()
        );
    }
}
