package com.tarea.application.professional.usecase;

import com.tarea.application.professional.dto.ProfessionalResponse;
import com.tarea.application.professional.exception.ProfessionalNotFoundApplicationException;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.domain.professional.port.repository.ProfessionalRepository;

public class GetProfessionalByIdUseCase {

    private final ProfessionalRepository professionalRepository;

    public GetProfessionalByIdUseCase(ProfessionalRepository professionalRepository) {
        this.professionalRepository = professionalRepository;
    }

    public ProfessionalResponse execute(ProfessionalId id) {
        var professional = professionalRepository.findById(id)
                .orElseThrow(() -> new ProfessionalNotFoundApplicationException(id.value().toString()));

        return new ProfessionalResponse(
            professional.id().value(),
            professional.documentTypeId().value(),
            professional.documentNumber(),
            professional.firstName(),
            professional.lastName(),
            professional.professionalTypeId().value(),
            professional.licenseNumber(),
            professional.active(),
            professional.cityId().value(),
            professional.createdAt(),
            professional.updatedAt()
        );
    }
}
