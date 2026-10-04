package com.tarea.infrastructure.priority.config;

import com.tarea.application.priority.usecase.DeletePriorityUseCase;
import com.tarea.application.priority.usecase.GetPriorityByIdUseCase;
import com.tarea.application.priority.usecase.ListPriorityUseCase;
import com.tarea.application.priority.usecase.RegisterPriorityUseCase;
import com.tarea.application.priority.usecase.UpdatePriorityUseCase;
import com.tarea.domain.priority.port.repository.PriorityRepository;
import com.tarea.infrastructure.priority.adapters.out.persistence.mappers.PriorityPersistenceMapper;
import com.tarea.infrastructure.priority.adapters.out.persistence.repositories.PriorityJpaRepository;
import com.tarea.infrastructure.priority.adapters.out.persistence.repositories.PriorityRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PriorityBeansConfig {

    @Bean
    public PriorityPersistenceMapper priorityPersistenceMapper() {
        return new PriorityPersistenceMapper();
    }

    @Bean
    public PriorityRepository priorityRepository(PriorityJpaRepository repository, PriorityPersistenceMapper mapper) {
        return new PriorityRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterPriorityUseCase registerPriorityUseCase(PriorityRepository repository) {
        return new RegisterPriorityUseCase(repository);
    }

    @Bean
    public GetPriorityByIdUseCase getPriorityByIdUseCase(PriorityRepository repository) {
        return new GetPriorityByIdUseCase(repository);
    }

    @Bean
    public ListPriorityUseCase listPriorityUseCase(PriorityRepository repository) {
        return new ListPriorityUseCase(repository);
    }

    @Bean
    public UpdatePriorityUseCase updatePriorityUseCase(PriorityRepository repository) {
        return new UpdatePriorityUseCase(repository);
    }

    @Bean
    public DeletePriorityUseCase deletePriorityUseCase(PriorityRepository repository) {
        return new DeletePriorityUseCase(repository);
    }
}
