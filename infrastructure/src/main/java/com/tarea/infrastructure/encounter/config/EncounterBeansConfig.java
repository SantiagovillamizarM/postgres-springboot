package com.tarea.infrastructure.encounter.config;

import com.tarea.application.encounter.usecase.DeleteEncounterUseCase;
import com.tarea.application.encounter.usecase.GetEncounterByIdUseCase;
import com.tarea.application.encounter.usecase.ListEncounterUseCase;
import com.tarea.application.encounter.usecase.RegisterEncounterUseCase;
import com.tarea.application.encounter.usecase.UpdateEncounterUseCase;
import com.tarea.domain.encounter.port.repository.EncounterRepository;
import com.tarea.infrastructure.encounter.adapters.out.persistence.mappers.EncounterPersistenceMapper;
import com.tarea.infrastructure.encounter.adapters.out.persistence.repositories.EncounterJpaRepository;
import com.tarea.infrastructure.encounter.adapters.out.persistence.repositories.EncounterRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EncounterBeansConfig {

    @Bean
    public EncounterPersistenceMapper encounterPersistenceMapper() {
        return new EncounterPersistenceMapper();
    }

    @Bean
    public EncounterRepository encounterRepository(EncounterJpaRepository repository, EncounterPersistenceMapper mapper) {
        return new EncounterRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterEncounterUseCase registerEncounterUseCase(EncounterRepository repository) {
        return new RegisterEncounterUseCase(repository);
    }

    @Bean
    public GetEncounterByIdUseCase getEncounterByIdUseCase(EncounterRepository repository) {
        return new GetEncounterByIdUseCase(repository);
    }

    @Bean
    public ListEncounterUseCase listEncounterUseCase(EncounterRepository repository) {
        return new ListEncounterUseCase(repository);
    }

    @Bean
    public UpdateEncounterUseCase updateEncounterUseCase(EncounterRepository repository) {
        return new UpdateEncounterUseCase(repository);
    }

    @Bean
    public DeleteEncounterUseCase deleteEncounterUseCase(EncounterRepository repository) {
        return new DeleteEncounterUseCase(repository);
    }
}
