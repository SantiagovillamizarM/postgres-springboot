package com.tarea.infrastructure.conversationstatus.config;

import com.tarea.application.conversationstatus.usecase.DeleteConversationStatusUseCase;
import com.tarea.application.conversationstatus.usecase.GetConversationStatusByIdUseCase;
import com.tarea.application.conversationstatus.usecase.ListConversationStatusUseCase;
import com.tarea.application.conversationstatus.usecase.RegisterConversationStatusUseCase;
import com.tarea.application.conversationstatus.usecase.UpdateConversationStatusUseCase;
import com.tarea.domain.conversationstatus.port.repository.ConversationStatusRepository;
import com.tarea.infrastructure.conversationstatus.adapters.out.persistence.mappers.ConversationStatusPersistenceMapper;
import com.tarea.infrastructure.conversationstatus.adapters.out.persistence.repositories.ConversationStatusJpaRepository;
import com.tarea.infrastructure.conversationstatus.adapters.out.persistence.repositories.ConversationStatusRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConversationStatusBeansConfig {

    @Bean
    public ConversationStatusPersistenceMapper conversationStatusPersistenceMapper() {
        return new ConversationStatusPersistenceMapper();
    }

    @Bean
    public ConversationStatusRepository conversationStatusRepository(ConversationStatusJpaRepository repository, ConversationStatusPersistenceMapper mapper) {
        return new ConversationStatusRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterConversationStatusUseCase registerConversationStatusUseCase(ConversationStatusRepository repository) {
        return new RegisterConversationStatusUseCase(repository);
    }

    @Bean
    public GetConversationStatusByIdUseCase getConversationStatusByIdUseCase(ConversationStatusRepository repository) {
        return new GetConversationStatusByIdUseCase(repository);
    }

    @Bean
    public ListConversationStatusUseCase listConversationStatusUseCase(ConversationStatusRepository repository) {
        return new ListConversationStatusUseCase(repository);
    }

    @Bean
    public UpdateConversationStatusUseCase updateConversationStatusUseCase(ConversationStatusRepository repository) {
        return new UpdateConversationStatusUseCase(repository);
    }

    @Bean
    public DeleteConversationStatusUseCase deleteConversationStatusUseCase(ConversationStatusRepository repository) {
        return new DeleteConversationStatusUseCase(repository);
    }
}
