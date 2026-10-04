package com.tarea.application.consenttype.usecase;

import com.tarea.application.consenttype.exception.ConsentTypeNotFoundApplicationException;
import com.tarea.domain.consenttype.model.valueobject.ConsentTypeId;
import com.tarea.domain.consenttype.port.repository.ConsentTypeRepository;

public class DeleteConsentTypeUseCase {

    private final ConsentTypeRepository consentTypeRepository;

    public DeleteConsentTypeUseCase(ConsentTypeRepository consentTypeRepository) {
        this.consentTypeRepository = consentTypeRepository;
    }

    public void execute(ConsentTypeId id) {
        var consentType = consentTypeRepository.findById(id)
                .orElseThrow(() -> new ConsentTypeNotFoundApplicationException(id.value().toString()));

        consentType.markAsDeleted();
        consentTypeRepository.delete(consentType);
    }
}
