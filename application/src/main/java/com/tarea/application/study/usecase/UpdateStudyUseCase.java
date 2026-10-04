package com.tarea.application.study.usecase;

import com.tarea.application.study.command.UpdateStudyCommand;
import com.tarea.application.study.dto.StudyResponse;
import com.tarea.application.study.exception.StudyNotFoundApplicationException;
import com.tarea.domain.study.port.repository.StudyRepository;

public class UpdateStudyUseCase {

    private final StudyRepository studyRepository;

    public UpdateStudyUseCase(StudyRepository studyRepository) {
        this.studyRepository = studyRepository;
    }

    public StudyResponse execute(UpdateStudyCommand command) {
        var study = studyRepository.findById(command.id())
                .orElseThrow(() -> new StudyNotFoundApplicationException(command.id().value().toString()));

        study.update(
                command.name()
        );

        var updated = studyRepository.save(study);

        return new StudyResponse(
            updated.id().value(),
            updated.name(),
            updated.createdAt(),
            updated.updatedAt()
        );
    }
}
