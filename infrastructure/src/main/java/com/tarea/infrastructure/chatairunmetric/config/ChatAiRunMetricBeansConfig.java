package com.tarea.infrastructure.chatairunmetric.config;

import com.tarea.application.chatairunmetric.usecase.DeleteChatAiRunMetricUseCase;
import com.tarea.application.chatairunmetric.usecase.GetChatAiRunMetricByIdUseCase;
import com.tarea.application.chatairunmetric.usecase.ListChatAiRunMetricUseCase;
import com.tarea.application.chatairunmetric.usecase.RegisterChatAiRunMetricUseCase;
import com.tarea.application.chatairunmetric.usecase.UpdateChatAiRunMetricUseCase;
import com.tarea.domain.chatairunmetric.port.repository.ChatAiRunMetricRepository;
import com.tarea.infrastructure.chatairunmetric.adapters.out.persistence.mappers.ChatAiRunMetricPersistenceMapper;
import com.tarea.infrastructure.chatairunmetric.adapters.out.persistence.repositories.ChatAiRunMetricJpaRepository;
import com.tarea.infrastructure.chatairunmetric.adapters.out.persistence.repositories.ChatAiRunMetricRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatAiRunMetricBeansConfig {

    @Bean
    public ChatAiRunMetricPersistenceMapper chatAiRunMetricPersistenceMapper() {
        return new ChatAiRunMetricPersistenceMapper();
    }

    @Bean
    public ChatAiRunMetricRepository chatAiRunMetricRepository(ChatAiRunMetricJpaRepository repository, ChatAiRunMetricPersistenceMapper mapper) {
        return new ChatAiRunMetricRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterChatAiRunMetricUseCase registerChatAiRunMetricUseCase(ChatAiRunMetricRepository repository) {
        return new RegisterChatAiRunMetricUseCase(repository);
    }

    @Bean
    public GetChatAiRunMetricByIdUseCase getChatAiRunMetricByIdUseCase(ChatAiRunMetricRepository repository) {
        return new GetChatAiRunMetricByIdUseCase(repository);
    }

    @Bean
    public ListChatAiRunMetricUseCase listChatAiRunMetricUseCase(ChatAiRunMetricRepository repository) {
        return new ListChatAiRunMetricUseCase(repository);
    }

    @Bean
    public UpdateChatAiRunMetricUseCase updateChatAiRunMetricUseCase(ChatAiRunMetricRepository repository) {
        return new UpdateChatAiRunMetricUseCase(repository);
    }

    @Bean
    public DeleteChatAiRunMetricUseCase deleteChatAiRunMetricUseCase(ChatAiRunMetricRepository repository) {
        return new DeleteChatAiRunMetricUseCase(repository);
    }
}
