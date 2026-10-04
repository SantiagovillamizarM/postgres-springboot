package com.tarea.infrastructure.chatmessage.config;

import com.tarea.application.chatmessage.usecase.DeleteChatMessageUseCase;
import com.tarea.application.chatmessage.usecase.GetChatMessageByIdUseCase;
import com.tarea.application.chatmessage.usecase.ListChatMessageUseCase;
import com.tarea.application.chatmessage.usecase.RegisterChatMessageUseCase;
import com.tarea.application.chatmessage.usecase.UpdateChatMessageUseCase;
import com.tarea.domain.chatmessage.port.repository.ChatMessageRepository;
import com.tarea.infrastructure.chatmessage.adapters.out.persistence.mappers.ChatMessagePersistenceMapper;
import com.tarea.infrastructure.chatmessage.adapters.out.persistence.repositories.ChatMessageJpaRepository;
import com.tarea.infrastructure.chatmessage.adapters.out.persistence.repositories.ChatMessageRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatMessageBeansConfig {

    @Bean
    public ChatMessagePersistenceMapper chatMessagePersistenceMapper() {
        return new ChatMessagePersistenceMapper();
    }

    @Bean
    public ChatMessageRepository chatMessageRepository(ChatMessageJpaRepository repository, ChatMessagePersistenceMapper mapper) {
        return new ChatMessageRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterChatMessageUseCase registerChatMessageUseCase(ChatMessageRepository repository) {
        return new RegisterChatMessageUseCase(repository);
    }

    @Bean
    public GetChatMessageByIdUseCase getChatMessageByIdUseCase(ChatMessageRepository repository) {
        return new GetChatMessageByIdUseCase(repository);
    }

    @Bean
    public ListChatMessageUseCase listChatMessageUseCase(ChatMessageRepository repository) {
        return new ListChatMessageUseCase(repository);
    }

    @Bean
    public UpdateChatMessageUseCase updateChatMessageUseCase(ChatMessageRepository repository) {
        return new UpdateChatMessageUseCase(repository);
    }

    @Bean
    public DeleteChatMessageUseCase deleteChatMessageUseCase(ChatMessageRepository repository) {
        return new DeleteChatMessageUseCase(repository);
    }
}
