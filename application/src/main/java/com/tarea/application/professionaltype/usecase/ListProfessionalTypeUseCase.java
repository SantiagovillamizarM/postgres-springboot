package com.tarea.application.professionaltype.usecase;

import com.tarea.application.professionaltype.dto.ProfessionalTypeResponse;
import com.tarea.domain.professionaltype.port.repository.ProfessionalTypeRepository;

import java.util.List;

public class ListProfessionalTypeUseCase {

    private final ProfessionalTypeRepository professionalTypeRepository;

    public ListProfessionalTypeUseCase(ProfessionalTypeRepository professionalTypeRepository) {
        this.professionalTypeRepository = professionalTypeRepository;
    }

    public List<ProfessionalTypeResponse> execute() {
        return professionalTypeRepository.findAll().stream()
                .map(professionalType -> new ProfessionalTypeResponse(
                    professionalType.id().value(),
                    professionalType.name(),
                    professionalType.createdAt(),
                    professionalType.updatedAt()
                ))
                .toList();
    }
}
