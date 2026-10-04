package com.tarea.application.assessmenttype.usecase;

import com.tarea.application.assessmenttype.command.RegisterAssessmentTypeCommand;
import com.tarea.application.assessmenttype.dto.AssessmentTypeResponse;
import com.tarea.domain.assessmenttype.model.aggregate.AssessmentType;
import com.tarea.domain.assessmenttype.port.repository.AssessmentTypeRepository;

public class RegisterAssessmentTypeUseCase {

    private final AssessmentTypeRepository assessmentTypeRepository;

    public RegisterAssessmentTypeUseCase(AssessmentTypeRepository assessmentTypeRepository) {
        this.assessmentTypeRepository = assessmentTypeRepository;
    }

    public AssessmentTypeResponse execute(RegisterAssessmentTypeCommand command) {
        AssessmentType assessmentType = AssessmentType.register(
                command.code(),
                command.name(),
                command.active(),
                command.description()
        );

        AssessmentType saved = assessmentTypeRepository.save(assessmentType);

        return new AssessmentTypeResponse(
            saved.id().value(),
            saved.code(),
            saved.name(),
            saved.active(),
            saved.description(),
            saved.createdAt(),
            saved.updatedAt()
        );
    }
}
