package com.tarea.infrastructure.chatairun.config;

import com.tarea.application.chatairun.usecase.DeleteChatAiRunUseCase;
import com.tarea.application.chatairun.usecase.GetChatAiRunByIdUseCase;
import com.tarea.application.chatairun.usecase.ListChatAiRunUseCase;
import com.tarea.application.chatairun.usecase.RegisterChatAiRunUseCase;
import com.tarea.application.chatairun.usecase.UpdateChatAiRunUseCase;
import com.tarea.domain.chatairun.port.repository.ChatAiRunRepository;
import com.tarea.infrastructure.chatairun.adapters.out.persistence.mappers.ChatAiRunPersistenceMapper;
import com.tarea.infrastructure.chatairun.adapters.out.persistence.repositories.ChatAiRunJpaRepository;
import com.tarea.infrastructure.chatairun.adapters.out.persistence.repositories.ChatAiRunRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatAiRunBeansConfig {

    @Bean
    public ChatAiRunPersistenceMapper chatAiRunPersistenceMapper() {
        return new ChatAiRunPersistenceMapper();
    }

    @Bean
    public ChatAiRunRepository chatAiRunRepository(ChatAiRunJpaRepository repository, ChatAiRunPersistenceMapper mapper) {
        return new ChatAiRunRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterChatAiRunUseCase registerChatAiRunUseCase(ChatAiRunRepository repository) {
        return new RegisterChatAiRunUseCase(repository);
    }

    @Bean
    public GetChatAiRunByIdUseCase getChatAiRunByIdUseCase(ChatAiRunRepository repository) {
        return new GetChatAiRunByIdUseCase(repository);
    }

    @Bean
    public ListChatAiRunUseCase listChatAiRunUseCase(ChatAiRunRepository repository) {
        return new ListChatAiRunUseCase(repository);
    }

    @Bean
    public UpdateChatAiRunUseCase updateChatAiRunUseCase(ChatAiRunRepository repository) {
        return new UpdateChatAiRunUseCase(repository);
    }

    @Bean
    public DeleteChatAiRunUseCase deleteChatAiRunUseCase(ChatAiRunRepository repository) {
        return new DeleteChatAiRunUseCase(repository);
    }
}
