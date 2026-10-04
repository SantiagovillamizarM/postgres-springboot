package com.tarea.application.professionalstudy.usecase;

import com.tarea.application.professionalstudy.command.UpdateProfessionalStudyCommand;
import com.tarea.application.professionalstudy.dto.ProfessionalStudyResponse;
import com.tarea.application.professionalstudy.exception.ProfessionalStudyNotFoundApplicationException;
import com.tarea.domain.professionalstudy.port.repository.ProfessionalStudyRepository;

public class UpdateProfessionalStudyUseCase {

    private final ProfessionalStudyRepository professionalStudyRepository;

    public UpdateProfessionalStudyUseCase(ProfessionalStudyRepository professionalStudyRepository) {
        this.professionalStudyRepository = professionalStudyRepository;
    }

    public ProfessionalStudyResponse execute(UpdateProfessionalStudyCommand command) {
        var professionalStudy = professionalStudyRepository.findById(command.id())
                .orElseThrow(() -> new ProfessionalStudyNotFoundApplicationException(command.id().value().toString()));

        professionalStudy.update(
                command.studyId(),
                command.professionalId(),
                command.title(),
                command.university(),
                command.valid(),
                command.resolutionNumber(),
                command.countryId()
        );

        var updated = professionalStudyRepository.save(professionalStudy);

        return new ProfessionalStudyResponse(
            updated.id().value(),
            updated.studyId().value(),
            updated.professionalId().value(),
            updated.title(),
            updated.university(),
            updated.valid(),
            updated.resolutionNumber(),
            updated.countryId().value(),
            updated.createdAt(),
            updated.updatedAt()
        );
    }
}
