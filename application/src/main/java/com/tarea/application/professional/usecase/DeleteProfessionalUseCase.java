package com.tarea.application.professional.usecase;

import com.tarea.application.professional.exception.ProfessionalNotFoundApplicationException;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.domain.professional.port.repository.ProfessionalRepository;

public class DeleteProfessionalUseCase {

    private final ProfessionalRepository professionalRepository;

    public DeleteProfessionalUseCase(ProfessionalRepository professionalRepository) {
        this.professionalRepository = professionalRepository;
    }

    public void execute(ProfessionalId id) {
        var professional = professionalRepository.findById(id)
                .orElseThrow(() -> new ProfessionalNotFoundApplicationException(id.value().toString()));

        professional.markAsDeleted();
        professionalRepository.delete(professional);
    }
}
