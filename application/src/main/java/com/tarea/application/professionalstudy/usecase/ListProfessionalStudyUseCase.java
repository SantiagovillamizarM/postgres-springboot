package com.tarea.application.professionalstudy.usecase;

import com.tarea.application.professionalstudy.dto.ProfessionalStudyResponse;
import com.tarea.domain.professionalstudy.port.repository.ProfessionalStudyRepository;

import java.util.List;

public class ListProfessionalStudyUseCase {

    private final ProfessionalStudyRepository professionalStudyRepository;

    public ListProfessionalStudyUseCase(ProfessionalStudyRepository professionalStudyRepository) {
        this.professionalStudyRepository = professionalStudyRepository;
    }

    public List<ProfessionalStudyResponse> execute() {
        return professionalStudyRepository.findAll().stream()
                .map(professionalStudy -> new ProfessionalStudyResponse(
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
                ))
                .toList();
    }
}
