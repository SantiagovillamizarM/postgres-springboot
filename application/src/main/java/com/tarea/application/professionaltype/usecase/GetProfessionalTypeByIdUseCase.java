package com.tarea.application.professionaltype.usecase;

import com.tarea.application.professionaltype.dto.ProfessionalTypeResponse;
import com.tarea.application.professionaltype.exception.ProfessionalTypeNotFoundApplicationException;
import com.tarea.domain.professionaltype.model.valueobject.ProfessionalTypeId;
import com.tarea.domain.professionaltype.port.repository.ProfessionalTypeRepository;

public class GetProfessionalTypeByIdUseCase {

    private final ProfessionalTypeRepository professionalTypeRepository;

    public GetProfessionalTypeByIdUseCase(ProfessionalTypeRepository professionalTypeRepository) {
        this.professionalTypeRepository = professionalTypeRepository;
    }

    public ProfessionalTypeResponse execute(ProfessionalTypeId id) {
        var professionalType = professionalTypeRepository.findById(id)
                .orElseThrow(() -> new ProfessionalTypeNotFoundApplicationException(id.value().toString()));

        return new ProfessionalTypeResponse(
            professionalType.id().value(),
            professionalType.name(),
            professionalType.createdAt(),
            professionalType.updatedAt()
        );
    }
}
