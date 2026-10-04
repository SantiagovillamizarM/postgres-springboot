package com.tarea.application.assessmenttype.usecase;

import com.tarea.application.assessmenttype.command.UpdateAssessmentTypeCommand;
import com.tarea.application.assessmenttype.dto.AssessmentTypeResponse;
import com.tarea.application.assessmenttype.exception.AssessmentTypeNotFoundApplicationException;
import com.tarea.domain.assessmenttype.port.repository.AssessmentTypeRepository;

public class UpdateAssessmentTypeUseCase {

    private final AssessmentTypeRepository assessmentTypeRepository;

    public UpdateAssessmentTypeUseCase(AssessmentTypeRepository assessmentTypeRepository) {
        this.assessmentTypeRepository = assessmentTypeRepository;
    }

    public AssessmentTypeResponse execute(UpdateAssessmentTypeCommand command) {
        var assessmentType = assessmentTypeRepository.findById(command.id())
                .orElseThrow(() -> new AssessmentTypeNotFoundApplicationException(command.id().value().toString()));

        assessmentType.update(
                command.code(),
                command.name(),
                command.active(),
                command.description()
        );

        var updated = assessmentTypeRepository.save(assessmentType);

        return new AssessmentTypeResponse(
            updated.id().value(),
            updated.code(),
            updated.name(),
            updated.active(),
            updated.description(),
            updated.createdAt(),
            updated.updatedAt()
        );
    }
}
