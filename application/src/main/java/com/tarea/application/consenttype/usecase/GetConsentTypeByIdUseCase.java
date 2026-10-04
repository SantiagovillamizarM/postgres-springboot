package com.tarea.application.consenttype.usecase;

import com.tarea.application.consenttype.dto.ConsentTypeResponse;
import com.tarea.application.consenttype.exception.ConsentTypeNotFoundApplicationException;
import com.tarea.domain.consenttype.model.valueobject.ConsentTypeId;
import com.tarea.domain.consenttype.port.repository.ConsentTypeRepository;

public class GetConsentTypeByIdUseCase {

    private final ConsentTypeRepository consentTypeRepository;

    public GetConsentTypeByIdUseCase(ConsentTypeRepository consentTypeRepository) {
        this.consentTypeRepository = consentTypeRepository;
    }

    public ConsentTypeResponse execute(ConsentTypeId id) {
        var consentType = consentTypeRepository.findById(id)
                .orElseThrow(() -> new ConsentTypeNotFoundApplicationException(id.value().toString()));

        return new ConsentTypeResponse(
            consentType.id().value(),
            consentType.code(),
            consentType.name(),
            consentType.active(),
            consentType.description(),
            consentType.createdAt(),
            consentType.updatedAt()
        );
    }
}
