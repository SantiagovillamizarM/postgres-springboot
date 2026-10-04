package com.tarea.application.professionaltype.usecase;

import com.tarea.application.professionaltype.command.RegisterProfessionalTypeCommand;
import com.tarea.application.professionaltype.dto.ProfessionalTypeResponse;
import com.tarea.domain.professionaltype.model.aggregate.ProfessionalType;
import com.tarea.domain.professionaltype.port.repository.ProfessionalTypeRepository;

public class RegisterProfessionalTypeUseCase {

    private final ProfessionalTypeRepository professionalTypeRepository;

    public RegisterProfessionalTypeUseCase(ProfessionalTypeRepository professionalTypeRepository) {
        this.professionalTypeRepository = professionalTypeRepository;
    }

    public ProfessionalTypeResponse execute(RegisterProfessionalTypeCommand command) {
        ProfessionalType professionalType = ProfessionalType.register(
                command.name()
        );

        ProfessionalType saved = professionalTypeRepository.save(professionalType);

        return new ProfessionalTypeResponse(
            saved.id().value(),
            saved.name(),
            saved.createdAt(),
            saved.updatedAt()
        );
    }
}
