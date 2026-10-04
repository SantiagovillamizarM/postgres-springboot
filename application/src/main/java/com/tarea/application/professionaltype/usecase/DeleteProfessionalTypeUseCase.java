package com.tarea.application.professionaltype.usecase;

import com.tarea.application.professionaltype.exception.ProfessionalTypeNotFoundApplicationException;
import com.tarea.domain.professionaltype.model.valueobject.ProfessionalTypeId;
import com.tarea.domain.professionaltype.port.repository.ProfessionalTypeRepository;

public class DeleteProfessionalTypeUseCase {

    private final ProfessionalTypeRepository professionalTypeRepository;

    public DeleteProfessionalTypeUseCase(ProfessionalTypeRepository professionalTypeRepository) {
        this.professionalTypeRepository = professionalTypeRepository;
    }

    public void execute(ProfessionalTypeId id) {
        var professionalType = professionalTypeRepository.findById(id)
                .orElseThrow(() -> new ProfessionalTypeNotFoundApplicationException(id.value().toString()));

        professionalType.markAsDeleted();
        professionalTypeRepository.delete(professionalType);
    }
}
