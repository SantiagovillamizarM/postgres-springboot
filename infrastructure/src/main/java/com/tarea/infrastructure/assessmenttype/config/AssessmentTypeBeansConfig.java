package com.tarea.infrastructure.assessmenttype.config;

import com.tarea.application.assessmenttype.usecase.DeleteAssessmentTypeUseCase;
import com.tarea.application.assessmenttype.usecase.GetAssessmentTypeByIdUseCase;
import com.tarea.application.assessmenttype.usecase.ListAssessmentTypeUseCase;
import com.tarea.application.assessmenttype.usecase.RegisterAssessmentTypeUseCase;
import com.tarea.application.assessmenttype.usecase.UpdateAssessmentTypeUseCase;
import com.tarea.domain.assessmenttype.port.repository.AssessmentTypeRepository;
import com.tarea.infrastructure.assessmenttype.adapters.out.persistence.mappers.AssessmentTypePersistenceMapper;
import com.tarea.infrastructure.assessmenttype.adapters.out.persistence.repositories.AssessmentTypeJpaRepository;
import com.tarea.infrastructure.assessmenttype.adapters.out.persistence.repositories.AssessmentTypeRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AssessmentTypeBeansConfig {

    @Bean
    public AssessmentTypePersistenceMapper assessmentTypePersistenceMapper() {
        return new AssessmentTypePersistenceMapper();
    }

    @Bean
    public AssessmentTypeRepository assessmentTypeRepository(AssessmentTypeJpaRepository repository, AssessmentTypePersistenceMapper mapper) {
        return new AssessmentTypeRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterAssessmentTypeUseCase registerAssessmentTypeUseCase(AssessmentTypeRepository repository) {
        return new RegisterAssessmentTypeUseCase(repository);
    }

    @Bean
    public GetAssessmentTypeByIdUseCase getAssessmentTypeByIdUseCase(AssessmentTypeRepository repository) {
        return new GetAssessmentTypeByIdUseCase(repository);
    }

    @Bean
    public ListAssessmentTypeUseCase listAssessmentTypeUseCase(AssessmentTypeRepository repository) {
        return new ListAssessmentTypeUseCase(repository);
    }

    @Bean
    public UpdateAssessmentTypeUseCase updateAssessmentTypeUseCase(AssessmentTypeRepository repository) {
        return new UpdateAssessmentTypeUseCase(repository);
    }

    @Bean
    public DeleteAssessmentTypeUseCase deleteAssessmentTypeUseCase(AssessmentTypeRepository repository) {
        return new DeleteAssessmentTypeUseCase(repository);
    }
}
