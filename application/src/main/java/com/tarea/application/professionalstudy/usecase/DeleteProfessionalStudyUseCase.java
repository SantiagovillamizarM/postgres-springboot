package com.tarea.application.professionalstudy.usecase;

import com.tarea.application.professionalstudy.exception.ProfessionalStudyNotFoundApplicationException;
import com.tarea.domain.professionalstudy.model.valueobject.ProfessionalStudyId;
import com.tarea.domain.professionalstudy.port.repository.ProfessionalStudyRepository;

public class DeleteProfessionalStudyUseCase {

    private final ProfessionalStudyRepository professionalStudyRepository;

    public DeleteProfessionalStudyUseCase(ProfessionalStudyRepository professionalStudyRepository) {
        this.professionalStudyRepository = professionalStudyRepository;
    }

    public void execute(ProfessionalStudyId id) {
        var professionalStudy = professionalStudyRepository.findById(id)
                .orElseThrow(() -> new ProfessionalStudyNotFoundApplicationException(id.value().toString()));

        professionalStudy.markAsDeleted();
        professionalStudyRepository.delete(professionalStudy);
    }
}
