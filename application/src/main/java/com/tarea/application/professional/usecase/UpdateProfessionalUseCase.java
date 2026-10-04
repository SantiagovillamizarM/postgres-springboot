package com.tarea.application.professional.usecase;

import com.tarea.application.professional.command.UpdateProfessionalCommand;
import com.tarea.application.professional.dto.ProfessionalResponse;
import com.tarea.application.professional.exception.ProfessionalNotFoundApplicationException;
import com.tarea.domain.professional.port.repository.ProfessionalRepository;

public class UpdateProfessionalUseCase {

    private final ProfessionalRepository professionalRepository;

    public UpdateProfessionalUseCase(ProfessionalRepository professionalRepository) {
        this.professionalRepository = professionalRepository;
    }

    public ProfessionalResponse execute(UpdateProfessionalCommand command) {
        var professional = professionalRepository.findById(command.id())
                .orElseThrow(() -> new ProfessionalNotFoundApplicationException(command.id().value().toString()));

        professional.update(
                command.documentTypeId(),
                command.documentNumber(),
                command.firstName(),
                command.lastName(),
                command.professionalTypeId(),
                command.licenseNumber(),
                command.active(),
                command.cityId()
        );

        var updated = professionalRepository.save(professional);

        return new ProfessionalResponse(
            updated.id().value(),
            updated.documentTypeId().value(),
            updated.documentNumber(),
            updated.firstName(),
            updated.lastName(),
            updated.professionalTypeId().value(),
            updated.licenseNumber(),
            updated.active(),
            updated.cityId().value(),
            updated.createdAt(),
            updated.updatedAt()
        );
    }
}
