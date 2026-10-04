package com.tarea.application.assessmenttype.usecase;

import com.tarea.application.assessmenttype.dto.AssessmentTypeResponse;
import com.tarea.application.assessmenttype.exception.AssessmentTypeNotFoundApplicationException;
import com.tarea.domain.assessmenttype.model.valueobject.AssessmentTypeId;
import com.tarea.domain.assessmenttype.port.repository.AssessmentTypeRepository;

public class GetAssessmentTypeByIdUseCase {

    private final AssessmentTypeRepository assessmentTypeRepository;

    public GetAssessmentTypeByIdUseCase(AssessmentTypeRepository assessmentTypeRepository) {
        this.assessmentTypeRepository = assessmentTypeRepository;
    }

    public AssessmentTypeResponse execute(AssessmentTypeId id) {
        var assessmentType = assessmentTypeRepository.findById(id)
                .orElseThrow(() -> new AssessmentTypeNotFoundApplicationException(id.value().toString()));

        return new AssessmentTypeResponse(
            assessmentType.id().value(),
            assessmentType.code(),
            assessmentType.name(),
            assessmentType.active(),
            assessmentType.description(),
            assessmentType.createdAt(),
            assessmentType.updatedAt()
        );
    }
}
