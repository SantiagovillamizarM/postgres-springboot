package com.tarea.infrastructure.chatconversation.config;

import com.tarea.application.chatconversation.usecase.DeleteChatConversationUseCase;
import com.tarea.application.chatconversation.usecase.GetChatConversationByIdUseCase;
import com.tarea.application.chatconversation.usecase.ListChatConversationUseCase;
import com.tarea.application.chatconversation.usecase.RegisterChatConversationUseCase;
import com.tarea.application.chatconversation.usecase.UpdateChatConversationUseCase;
import com.tarea.domain.chatconversation.port.repository.ChatConversationRepository;
import com.tarea.infrastructure.chatconversation.adapters.out.persistence.mappers.ChatConversationPersistenceMapper;
import com.tarea.infrastructure.chatconversation.adapters.out.persistence.repositories.ChatConversationJpaRepository;
import com.tarea.infrastructure.chatconversation.adapters.out.persistence.repositories.ChatConversationRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatConversationBeansConfig {

    @Bean
    public ChatConversationPersistenceMapper chatConversationPersistenceMapper() {
        return new ChatConversationPersistenceMapper();
    }

    @Bean
    public ChatConversationRepository chatConversationRepository(ChatConversationJpaRepository repository, ChatConversationPersistenceMapper mapper) {
        return new ChatConversationRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterChatConversationUseCase registerChatConversationUseCase(ChatConversationRepository repository) {
        return new RegisterChatConversationUseCase(repository);
    }

    @Bean
    public GetChatConversationByIdUseCase getChatConversationByIdUseCase(ChatConversationRepository repository) {
        return new GetChatConversationByIdUseCase(repository);
    }

    @Bean
    public ListChatConversationUseCase listChatConversationUseCase(ChatConversationRepository repository) {
        return new ListChatConversationUseCase(repository);
    }

    @Bean
    public UpdateChatConversationUseCase updateChatConversationUseCase(ChatConversationRepository repository) {
        return new UpdateChatConversationUseCase(repository);
    }

    @Bean
    public DeleteChatConversationUseCase deleteChatConversationUseCase(ChatConversationRepository repository) {
        return new DeleteChatConversationUseCase(repository);
    }
}
