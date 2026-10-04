package com.tarea.application.study.usecase;

import com.tarea.application.study.dto.StudyResponse;
import com.tarea.application.study.exception.StudyNotFoundApplicationException;
import com.tarea.domain.study.model.valueobject.StudyId;
import com.tarea.domain.study.port.repository.StudyRepository;

public class GetStudyByIdUseCase {

    private final StudyRepository studyRepository;

    public GetStudyByIdUseCase(StudyRepository studyRepository) {
        this.studyRepository = studyRepository;
    }

    public StudyResponse execute(StudyId id) {
        var study = studyRepository.findById(id)
                .orElseThrow(() -> new StudyNotFoundApplicationException(id.value().toString()));

        return new StudyResponse(
            study.id().value(),
            study.name(),
            study.createdAt(),
            study.updatedAt()
        );
    }
}
