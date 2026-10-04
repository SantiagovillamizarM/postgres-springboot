package com.tarea.application.assessmenttype.usecase;

import com.tarea.application.assessmenttype.dto.AssessmentTypeResponse;
import com.tarea.domain.assessmenttype.port.repository.AssessmentTypeRepository;

import java.util.List;

public class ListAssessmentTypeUseCase {

    private final AssessmentTypeRepository assessmentTypeRepository;

    public ListAssessmentTypeUseCase(AssessmentTypeRepository assessmentTypeRepository) {
        this.assessmentTypeRepository = assessmentTypeRepository;
    }

    public List<AssessmentTypeResponse> execute() {
        return assessmentTypeRepository.findAll().stream()
                .map(assessmentType -> new AssessmentTypeResponse(
                    assessmentType.id().value(),
                    assessmentType.code(),
                    assessmentType.name(),
                    assessmentType.active(),
                    assessmentType.description(),
                    assessmentType.createdAt(),
                    assessmentType.updatedAt()
                ))
                .toList();
    }
}
