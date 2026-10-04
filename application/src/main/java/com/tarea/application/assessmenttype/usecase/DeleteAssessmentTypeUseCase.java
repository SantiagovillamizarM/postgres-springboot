package com.tarea.application.assessmenttype.usecase;

import com.tarea.application.assessmenttype.exception.AssessmentTypeNotFoundApplicationException;
import com.tarea.domain.assessmenttype.model.valueobject.AssessmentTypeId;
import com.tarea.domain.assessmenttype.port.repository.AssessmentTypeRepository;

public class DeleteAssessmentTypeUseCase {

    private final AssessmentTypeRepository assessmentTypeRepository;

    public DeleteAssessmentTypeUseCase(AssessmentTypeRepository assessmentTypeRepository) {
        this.assessmentTypeRepository = assessmentTypeRepository;
    }

    public void execute(AssessmentTypeId id) {
        var assessmentType = assessmentTypeRepository.findById(id)
                .orElseThrow(() -> new AssessmentTypeNotFoundApplicationException(id.value().toString()));

        assessmentType.markAsDeleted();
        assessmentTypeRepository.delete(assessmentType);
    }
}
