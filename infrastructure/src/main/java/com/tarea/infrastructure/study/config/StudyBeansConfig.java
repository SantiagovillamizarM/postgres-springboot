package com.tarea.infrastructure.study.config;

import com.tarea.application.study.usecase.DeleteStudyUseCase;
import com.tarea.application.study.usecase.GetStudyByIdUseCase;
import com.tarea.application.study.usecase.ListStudyUseCase;
import com.tarea.application.study.usecase.RegisterStudyUseCase;
import com.tarea.application.study.usecase.UpdateStudyUseCase;
import com.tarea.domain.study.port.repository.StudyRepository;
import com.tarea.infrastructure.study.adapters.out.persistence.mappers.StudyPersistenceMapper;
import com.tarea.infrastructure.study.adapters.out.persistence.repositories.StudyJpaRepository;
import com.tarea.infrastructure.study.adapters.out.persistence.repositories.StudyRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudyBeansConfig {

    @Bean
    public StudyPersistenceMapper studyPersistenceMapper() {
        return new StudyPersistenceMapper();
    }

    @Bean
    public StudyRepository studyRepository(StudyJpaRepository repository, StudyPersistenceMapper mapper) {
        return new StudyRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterStudyUseCase registerStudyUseCase(StudyRepository repository) {
        return new RegisterStudyUseCase(repository);
    }

    @Bean
    public GetStudyByIdUseCase getStudyByIdUseCase(StudyRepository repository) {
        return new GetStudyByIdUseCase(repository);
    }

    @Bean
    public ListStudyUseCase listStudyUseCase(StudyRepository repository) {
        return new ListStudyUseCase(repository);
    }

    @Bean
    public UpdateStudyUseCase updateStudyUseCase(StudyRepository repository) {
        return new UpdateStudyUseCase(repository);
    }

    @Bean
    public DeleteStudyUseCase deleteStudyUseCase(StudyRepository repository) {
        return new DeleteStudyUseCase(repository);
    }
}
