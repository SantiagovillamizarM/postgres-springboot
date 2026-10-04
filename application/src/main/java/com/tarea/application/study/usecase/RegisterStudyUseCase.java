package com.tarea.application.study.usecase;

import com.tarea.application.study.command.RegisterStudyCommand;
import com.tarea.application.study.dto.StudyResponse;
import com.tarea.domain.study.model.aggregate.Study;
import com.tarea.domain.study.port.repository.StudyRepository;

public class RegisterStudyUseCase {

    private final StudyRepository studyRepository;

    public RegisterStudyUseCase(StudyRepository studyRepository) {
        this.studyRepository = studyRepository;
    }

    public StudyResponse execute(RegisterStudyCommand command) {
        Study study = Study.register(
                command.name()
        );

        Study saved = studyRepository.save(study);

        return new StudyResponse(
            saved.id().value(),
            saved.name(),
            saved.createdAt(),
            saved.updatedAt()
        );
    }
}
