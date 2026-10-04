package com.tarea.application.professionalstudy.usecase;

import com.tarea.application.professionalstudy.dto.ProfessionalStudyResponse;
import com.tarea.application.professionalstudy.exception.ProfessionalStudyNotFoundApplicationException;
import com.tarea.domain.professionalstudy.model.valueobject.ProfessionalStudyId;
import com.tarea.domain.professionalstudy.port.repository.ProfessionalStudyRepository;

public class GetProfessionalStudyByIdUseCase {

    private final ProfessionalStudyRepository professionalStudyRepository;

    public GetProfessionalStudyByIdUseCase(ProfessionalStudyRepository professionalStudyRepository) {
        this.professionalStudyRepository = professionalStudyRepository;
    }

    public ProfessionalStudyResponse execute(ProfessionalStudyId id) {
        var professionalStudy = professionalStudyRepository.findById(id)
                .orElseThrow(() -> new ProfessionalStudyNotFoundApplicationException(id.value().toString()));

        return new ProfessionalStudyResponse(
            professionalStudy.id().value(),
            professionalStudy.studyId().value(),
            professionalStudy.professionalId().value(),
            professionalStudy.title(),
            professionalStudy.university(),
            professionalStudy.valid(),
            professionalStudy.resolutionNumber(),
            professionalStudy.countryId().value(),
            professionalStudy.createdAt(),
            professionalStudy.updatedAt()
        );
    }
}
