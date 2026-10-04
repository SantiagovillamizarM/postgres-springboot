package com.tarea.infrastructure.encounterstatus.config;

import com.tarea.application.encounterstatus.usecase.DeleteEncounterStatusUseCase;
import com.tarea.application.encounterstatus.usecase.GetEncounterStatusByIdUseCase;
import com.tarea.application.encounterstatus.usecase.ListEncounterStatusUseCase;
import com.tarea.application.encounterstatus.usecase.RegisterEncounterStatusUseCase;
import com.tarea.application.encounterstatus.usecase.UpdateEncounterStatusUseCase;
import com.tarea.domain.encounterstatus.port.repository.EncounterStatusRepository;
import com.tarea.infrastructure.encounterstatus.adapters.out.persistence.mappers.EncounterStatusPersistenceMapper;
import com.tarea.infrastructure.encounterstatus.adapters.out.persistence.repositories.EncounterStatusJpaRepository;
import com.tarea.infrastructure.encounterstatus.adapters.out.persistence.repositories.EncounterStatusRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EncounterStatusBeansConfig {

    @Bean
    public EncounterStatusPersistenceMapper encounterStatusPersistenceMapper() {
        return new EncounterStatusPersistenceMapper();
    }

    @Bean
    public EncounterStatusRepository encounterStatusRepository(EncounterStatusJpaRepository repository, EncounterStatusPersistenceMapper mapper) {
        return new EncounterStatusRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterEncounterStatusUseCase registerEncounterStatusUseCase(EncounterStatusRepository repository) {
        return new RegisterEncounterStatusUseCase(repository);
    }

    @Bean
    public GetEncounterStatusByIdUseCase getEncounterStatusByIdUseCase(EncounterStatusRepository repository) {
        return new GetEncounterStatusByIdUseCase(repository);
    }

    @Bean
    public ListEncounterStatusUseCase listEncounterStatusUseCase(EncounterStatusRepository repository) {
        return new ListEncounterStatusUseCase(repository);
    }

    @Bean
    public UpdateEncounterStatusUseCase updateEncounterStatusUseCase(EncounterStatusRepository repository) {
        return new UpdateEncounterStatusUseCase(repository);
    }

    @Bean
    public DeleteEncounterStatusUseCase deleteEncounterStatusUseCase(EncounterStatusRepository repository) {
        return new DeleteEncounterStatusUseCase(repository);
    }
}
