package com.tarea.application.professional.usecase;

import com.tarea.application.professional.dto.ProfessionalResponse;
import com.tarea.domain.professional.port.repository.ProfessionalRepository;

import java.util.List;

public class ListProfessionalUseCase {

    private final ProfessionalRepository professionalRepository;

    public ListProfessionalUseCase(ProfessionalRepository professionalRepository) {
        this.professionalRepository = professionalRepository;
    }

    public List<ProfessionalResponse> execute() {
        return professionalRepository.findAll().stream()
                .map(professional -> new ProfessionalResponse(
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
                ))
                .toList();
    }
}
