package com.tarea.application.professional.usecase;

import com.tarea.application.professional.command.RegisterProfessionalCommand;
import com.tarea.application.professional.dto.ProfessionalResponse;
import com.tarea.domain.professional.model.aggregate.Professional;
import com.tarea.domain.professional.port.repository.ProfessionalRepository;

public class RegisterProfessionalUseCase {

    private final ProfessionalRepository professionalRepository;

    public RegisterProfessionalUseCase(ProfessionalRepository professionalRepository) {
        this.professionalRepository = professionalRepository;
    }

    public ProfessionalResponse execute(RegisterProfessionalCommand command) {
        Professional professional = Professional.register(
                command.documentTypeId(),
                command.documentNumber(),
                command.firstName(),
                command.lastName(),
                command.professionalTypeId(),
                command.licenseNumber(),
                command.active(),
                command.cityId()
        );

        Professional saved = professionalRepository.save(professional);

        return new ProfessionalResponse(
            saved.id().value(),
            saved.documentTypeId().value(),
            saved.documentNumber(),
            saved.firstName(),
            saved.lastName(),
            saved.professionalTypeId().value(),
            saved.licenseNumber(),
            saved.active(),
            saved.cityId().value(),
            saved.createdAt(),
            saved.updatedAt()
        );
    }
}
