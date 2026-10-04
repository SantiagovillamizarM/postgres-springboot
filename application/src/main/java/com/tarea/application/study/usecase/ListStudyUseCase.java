package com.tarea.application.study.usecase;

import com.tarea.application.study.dto.StudyResponse;
import com.tarea.domain.study.port.repository.StudyRepository;

import java.util.List;

public class ListStudyUseCase {

    private final StudyRepository studyRepository;

    public ListStudyUseCase(StudyRepository studyRepository) {
        this.studyRepository = studyRepository;
    }

    public List<StudyResponse> execute() {
        return studyRepository.findAll().stream()
                .map(study -> new StudyResponse(
                    study.id().value(),
                    study.name(),
                    study.createdAt(),
                    study.updatedAt()
                ))
                .toList();
    }
}
