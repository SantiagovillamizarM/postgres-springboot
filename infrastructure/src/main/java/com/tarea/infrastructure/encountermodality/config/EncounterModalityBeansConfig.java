package com.tarea.infrastructure.encountermodality.config;

import com.tarea.application.encountermodality.usecase.DeleteEncounterModalityUseCase;
import com.tarea.application.encountermodality.usecase.GetEncounterModalityByIdUseCase;
import com.tarea.application.encountermodality.usecase.ListEncounterModalityUseCase;
import com.tarea.application.encountermodality.usecase.RegisterEncounterModalityUseCase;
import com.tarea.application.encountermodality.usecase.UpdateEncounterModalityUseCase;
import com.tarea.domain.encountermodality.port.repository.EncounterModalityRepository;
import com.tarea.infrastructure.encountermodality.adapters.out.persistence.mappers.EncounterModalityPersistenceMapper;
import com.tarea.infrastructure.encountermodality.adapters.out.persistence.repositories.EncounterModalityJpaRepository;
import com.tarea.infrastructure.encountermodality.adapters.out.persistence.repositories.EncounterModalityRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EncounterModalityBeansConfig {

    @Bean
    public EncounterModalityPersistenceMapper encounterModalityPersistenceMapper() {
        return new EncounterModalityPersistenceMapper();
    }

    @Bean
    public EncounterModalityRepository encounterModalityRepository(EncounterModalityJpaRepository repository, EncounterModalityPersistenceMapper mapper) {
        return new EncounterModalityRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterEncounterModalityUseCase registerEncounterModalityUseCase(EncounterModalityRepository repository) {
        return new RegisterEncounterModalityUseCase(repository);
    }

    @Bean
    public GetEncounterModalityByIdUseCase getEncounterModalityByIdUseCase(EncounterModalityRepository repository) {
        return new GetEncounterModalityByIdUseCase(repository);
    }

    @Bean
    public ListEncounterModalityUseCase listEncounterModalityUseCase(EncounterModalityRepository repository) {
        return new ListEncounterModalityUseCase(repository);
    }

    @Bean
    public UpdateEncounterModalityUseCase updateEncounterModalityUseCase(EncounterModalityRepository repository) {
        return new UpdateEncounterModalityUseCase(repository);
    }

    @Bean
    public DeleteEncounterModalityUseCase deleteEncounterModalityUseCase(EncounterModalityRepository repository) {
        return new DeleteEncounterModalityUseCase(repository);
    }
}
