package com.tarea.infrastructure.stateregion.config;

import com.tarea.application.stateregion.usecase.DeleteStateRegionUseCase;
import com.tarea.application.stateregion.usecase.GetStateRegionByIdUseCase;
import com.tarea.application.stateregion.usecase.ListStateRegionUseCase;
import com.tarea.application.stateregion.usecase.RegisterStateRegionUseCase;
import com.tarea.application.stateregion.usecase.UpdateStateRegionUseCase;
import com.tarea.domain.stateregion.port.repository.StateRegionRepository;
import com.tarea.infrastructure.stateregion.adapters.out.persistence.mappers.StateRegionPersistenceMapper;
import com.tarea.infrastructure.stateregion.adapters.out.persistence.repositories.StateRegionJpaRepository;
import com.tarea.infrastructure.stateregion.adapters.out.persistence.repositories.StateRegionRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StateRegionBeansConfig {

    @Bean
    public StateRegionPersistenceMapper stateRegionPersistenceMapper() {
        return new StateRegionPersistenceMapper();
    }

    @Bean
    public StateRegionRepository stateRegionRepository(StateRegionJpaRepository repository, StateRegionPersistenceMapper mapper) {
        return new StateRegionRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterStateRegionUseCase registerStateRegionUseCase(StateRegionRepository repository) {
        return new RegisterStateRegionUseCase(repository);
    }

    @Bean
    public GetStateRegionByIdUseCase getStateRegionByIdUseCase(StateRegionRepository repository) {
        return new GetStateRegionByIdUseCase(repository);
    }

    @Bean
    public ListStateRegionUseCase listStateRegionUseCase(StateRegionRepository repository) {
        return new ListStateRegionUseCase(repository);
    }

    @Bean
    public UpdateStateRegionUseCase updateStateRegionUseCase(StateRegionRepository repository) {
        return new UpdateStateRegionUseCase(repository);
    }

    @Bean
    public DeleteStateRegionUseCase deleteStateRegionUseCase(StateRegionRepository repository) {
        return new DeleteStateRegionUseCase(repository);
    }
}
