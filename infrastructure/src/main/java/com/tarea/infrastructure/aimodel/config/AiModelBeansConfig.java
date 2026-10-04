package com.tarea.infrastructure.aimodel.config;

import com.tarea.application.aimodel.usecase.DeleteAiModelUseCase;
import com.tarea.application.aimodel.usecase.GetAiModelByIdUseCase;
import com.tarea.application.aimodel.usecase.ListAiModelUseCase;
import com.tarea.application.aimodel.usecase.RegisterAiModelUseCase;
import com.tarea.application.aimodel.usecase.UpdateAiModelUseCase;
import com.tarea.domain.aimodel.port.repository.AiModelRepository;
import com.tarea.infrastructure.aimodel.adapters.out.persistence.mappers.AiModelPersistenceMapper;
import com.tarea.infrastructure.aimodel.adapters.out.persistence.repositories.AiModelJpaRepository;
import com.tarea.infrastructure.aimodel.adapters.out.persistence.repositories.AiModelRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiModelBeansConfig {

    @Bean
    public AiModelPersistenceMapper aiModelPersistenceMapper() {
        return new AiModelPersistenceMapper();
    }

    @Bean
    public AiModelRepository aiModelRepository(AiModelJpaRepository repository, AiModelPersistenceMapper mapper) {
        return new AiModelRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterAiModelUseCase registerAiModelUseCase(AiModelRepository repository) {
        return new RegisterAiModelUseCase(repository);
    }

    @Bean
    public GetAiModelByIdUseCase getAiModelByIdUseCase(AiModelRepository repository) {
        return new GetAiModelByIdUseCase(repository);
    }

    @Bean
    public ListAiModelUseCase listAiModelUseCase(AiModelRepository repository) {
        return new ListAiModelUseCase(repository);
    }

    @Bean
    public UpdateAiModelUseCase updateAiModelUseCase(AiModelRepository repository) {
        return new UpdateAiModelUseCase(repository);
    }

    @Bean
    public DeleteAiModelUseCase deleteAiModelUseCase(AiModelRepository repository) {
        return new DeleteAiModelUseCase(repository);
    }
}
