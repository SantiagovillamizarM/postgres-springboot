package com.tarea.infrastructure.airunstatus.config;

import com.tarea.application.airunstatus.usecase.DeleteAiRunStatusUseCase;
import com.tarea.application.airunstatus.usecase.GetAiRunStatusByIdUseCase;
import com.tarea.application.airunstatus.usecase.ListAiRunStatusUseCase;
import com.tarea.application.airunstatus.usecase.RegisterAiRunStatusUseCase;
import com.tarea.application.airunstatus.usecase.UpdateAiRunStatusUseCase;
import com.tarea.domain.airunstatus.port.repository.AiRunStatusRepository;
import com.tarea.infrastructure.airunstatus.adapters.out.persistence.mappers.AiRunStatusPersistenceMapper;
import com.tarea.infrastructure.airunstatus.adapters.out.persistence.repositories.AiRunStatusJpaRepository;
import com.tarea.infrastructure.airunstatus.adapters.out.persistence.repositories.AiRunStatusRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiRunStatusBeansConfig {

    @Bean
    public AiRunStatusPersistenceMapper aiRunStatusPersistenceMapper() {
        return new AiRunStatusPersistenceMapper();
    }

    @Bean
    public AiRunStatusRepository aiRunStatusRepository(AiRunStatusJpaRepository repository, AiRunStatusPersistenceMapper mapper) {
        return new AiRunStatusRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterAiRunStatusUseCase registerAiRunStatusUseCase(AiRunStatusRepository repository) {
        return new RegisterAiRunStatusUseCase(repository);
    }

    @Bean
    public GetAiRunStatusByIdUseCase getAiRunStatusByIdUseCase(AiRunStatusRepository repository) {
        return new GetAiRunStatusByIdUseCase(repository);
    }

    @Bean
    public ListAiRunStatusUseCase listAiRunStatusUseCase(AiRunStatusRepository repository) {
        return new ListAiRunStatusUseCase(repository);
    }

    @Bean
    public UpdateAiRunStatusUseCase updateAiRunStatusUseCase(AiRunStatusRepository repository) {
        return new UpdateAiRunStatusUseCase(repository);
    }

    @Bean
    public DeleteAiRunStatusUseCase deleteAiRunStatusUseCase(AiRunStatusRepository repository) {
        return new DeleteAiRunStatusUseCase(repository);
    }
}
