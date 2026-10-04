package com.tarea.infrastructure.gender.config;

import com.tarea.application.gender.usecase.DeleteGenderUseCase;
import com.tarea.application.gender.usecase.GetGenderByIdUseCase;
import com.tarea.application.gender.usecase.ListGenderUseCase;
import com.tarea.application.gender.usecase.RegisterGenderUseCase;
import com.tarea.application.gender.usecase.UpdateGenderUseCase;
import com.tarea.domain.gender.port.repository.GenderRepository;
import com.tarea.infrastructure.gender.adapters.out.persistence.mappers.GenderPersistenceMapper;
import com.tarea.infrastructure.gender.adapters.out.persistence.repositories.GenderJpaRepository;
import com.tarea.infrastructure.gender.adapters.out.persistence.repositories.GenderRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GenderBeansConfig {

    @Bean
    public GenderPersistenceMapper genderPersistenceMapper() {
        return new GenderPersistenceMapper();
    }

    @Bean
    public GenderRepository genderRepository(GenderJpaRepository repository, GenderPersistenceMapper mapper) {
        return new GenderRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterGenderUseCase registerGenderUseCase(GenderRepository repository) {
        return new RegisterGenderUseCase(repository);
    }

    @Bean
    public GetGenderByIdUseCase getGenderByIdUseCase(GenderRepository repository) {
        return new GetGenderByIdUseCase(repository);
    }

    @Bean
    public ListGenderUseCase listGenderUseCase(GenderRepository repository) {
        return new ListGenderUseCase(repository);
    }

    @Bean
    public UpdateGenderUseCase updateGenderUseCase(GenderRepository repository) {
        return new UpdateGenderUseCase(repository);
    }

    @Bean
    public DeleteGenderUseCase deleteGenderUseCase(GenderRepository repository) {
        return new DeleteGenderUseCase(repository);
    }
}
