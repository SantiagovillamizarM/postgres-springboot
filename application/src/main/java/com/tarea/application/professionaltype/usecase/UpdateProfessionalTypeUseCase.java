package com.tarea.application.professionaltype.usecase;

import com.tarea.application.professionaltype.command.UpdateProfessionalTypeCommand;
import com.tarea.application.professionaltype.dto.ProfessionalTypeResponse;
import com.tarea.application.professionaltype.exception.ProfessionalTypeNotFoundApplicationException;
import com.tarea.domain.professionaltype.port.repository.ProfessionalTypeRepository;

public class UpdateProfessionalTypeUseCase {

    private final ProfessionalTypeRepository professionalTypeRepository;

    public UpdateProfessionalTypeUseCase(ProfessionalTypeRepository professionalTypeRepository) {
        this.professionalTypeRepository = professionalTypeRepository;
    }

    public ProfessionalTypeResponse execute(UpdateProfessionalTypeCommand command) {
        var professionalType = professionalTypeRepository.findById(command.id())
                .orElseThrow(() -> new ProfessionalTypeNotFoundApplicationException(command.id().value().toString()));

        professionalType.update(
                command.name()
        );

        var updated = professionalTypeRepository.save(professionalType);

        return new ProfessionalTypeResponse(
            updated.id().value(),
            updated.name(),
            updated.createdAt(),
            updated.updatedAt()
        );
    }
}
