package com.tarea.application.study.usecase;

import com.tarea.application.study.exception.StudyNotFoundApplicationException;
import com.tarea.domain.study.model.valueobject.StudyId;
import com.tarea.domain.study.port.repository.StudyRepository;

public class DeleteStudyUseCase {

    private final StudyRepository studyRepository;

    public DeleteStudyUseCase(StudyRepository studyRepository) {
        this.studyRepository = studyRepository;
    }

    public void execute(StudyId id) {
        var study = studyRepository.findById(id)
                .orElseThrow(() -> new StudyNotFoundApplicationException(id.value().toString()));

        study.markAsDeleted();
        studyRepository.delete(study);
    }
}
