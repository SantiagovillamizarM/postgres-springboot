package com.tarea.infrastructure.encountertype.config;

import com.tarea.application.encountertype.usecase.DeleteEncounterTypeUseCase;
import com.tarea.application.encountertype.usecase.GetEncounterTypeByIdUseCase;
import com.tarea.application.encountertype.usecase.ListEncounterTypeUseCase;
import com.tarea.application.encountertype.usecase.RegisterEncounterTypeUseCase;
import com.tarea.application.encountertype.usecase.UpdateEncounterTypeUseCase;
import com.tarea.domain.encountertype.port.repository.EncounterTypeRepository;
import com.tarea.infrastructure.encountertype.adapters.out.persistence.mappers.EncounterTypePersistenceMapper;
import com.tarea.infrastructure.encountertype.adapters.out.persistence.repositories.EncounterTypeJpaRepository;
import com.tarea.infrastructure.encountertype.adapters.out.persistence.repositories.EncounterTypeRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EncounterTypeBeansConfig {

    @Bean
    public EncounterTypePersistenceMapper encounterTypePersistenceMapper() {
        return new EncounterTypePersistenceMapper();
    }

    @Bean
    public EncounterTypeRepository encounterTypeRepository(EncounterTypeJpaRepository repository, EncounterTypePersistenceMapper mapper) {
        return new EncounterTypeRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterEncounterTypeUseCase registerEncounterTypeUseCase(EncounterTypeRepository repository) {
        return new RegisterEncounterTypeUseCase(repository);
    }

    @Bean
    public GetEncounterTypeByIdUseCase getEncounterTypeByIdUseCase(EncounterTypeRepository repository) {
        return new GetEncounterTypeByIdUseCase(repository);
    }

    @Bean
    public ListEncounterTypeUseCase listEncounterTypeUseCase(EncounterTypeRepository repository) {
        return new ListEncounterTypeUseCase(repository);
    }

    @Bean
    public UpdateEncounterTypeUseCase updateEncounterTypeUseCase(EncounterTypeRepository repository) {
        return new UpdateEncounterTypeUseCase(repository);
    }

    @Bean
    public DeleteEncounterTypeUseCase deleteEncounterTypeUseCase(EncounterTypeRepository repository) {
        return new DeleteEncounterTypeUseCase(repository);
    }
}
