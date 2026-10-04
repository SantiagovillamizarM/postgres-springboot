package com.tarea.infrastructure.chatescalation.config;

import com.tarea.application.chatescalation.usecase.DeleteChatEscalationUseCase;
import com.tarea.application.chatescalation.usecase.GetChatEscalationByIdUseCase;
import com.tarea.application.chatescalation.usecase.ListChatEscalationUseCase;
import com.tarea.application.chatescalation.usecase.RegisterChatEscalationUseCase;
import com.tarea.application.chatescalation.usecase.UpdateChatEscalationUseCase;
import com.tarea.domain.chatescalation.port.repository.ChatEscalationRepository;
import com.tarea.infrastructure.chatescalation.adapters.out.persistence.mappers.ChatEscalationPersistenceMapper;
import com.tarea.infrastructure.chatescalation.adapters.out.persistence.repositories.ChatEscalationJpaRepository;
import com.tarea.infrastructure.chatescalation.adapters.out.persistence.repositories.ChatEscalationRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatEscalationBeansConfig {

    @Bean
    public ChatEscalationPersistenceMapper chatEscalationPersistenceMapper() {
        return new ChatEscalationPersistenceMapper();
    }

    @Bean
    public ChatEscalationRepository chatEscalationRepository(ChatEscalationJpaRepository repository, ChatEscalationPersistenceMapper mapper) {
        return new ChatEscalationRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterChatEscalationUseCase registerChatEscalationUseCase(ChatEscalationRepository repository) {
        return new RegisterChatEscalationUseCase(repository);
    }

    @Bean
    public GetChatEscalationByIdUseCase getChatEscalationByIdUseCase(ChatEscalationRepository repository) {
        return new GetChatEscalationByIdUseCase(repository);
    }

    @Bean
    public ListChatEscalationUseCase listChatEscalationUseCase(ChatEscalationRepository repository) {
        return new ListChatEscalationUseCase(repository);
    }

    @Bean
    public UpdateChatEscalationUseCase updateChatEscalationUseCase(ChatEscalationRepository repository) {
        return new UpdateChatEscalationUseCase(repository);
    }

    @Bean
    public DeleteChatEscalationUseCase deleteChatEscalationUseCase(ChatEscalationRepository repository) {
        return new DeleteChatEscalationUseCase(repository);
    }
}
