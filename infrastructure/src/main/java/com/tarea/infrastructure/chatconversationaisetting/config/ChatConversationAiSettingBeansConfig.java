package com.tarea.infrastructure.chatconversationaisetting.config;

import com.tarea.application.chatconversationaisetting.usecase.DeleteChatConversationAiSettingUseCase;
import com.tarea.application.chatconversationaisetting.usecase.GetChatConversationAiSettingByIdUseCase;
import com.tarea.application.chatconversationaisetting.usecase.ListChatConversationAiSettingUseCase;
import com.tarea.application.chatconversationaisetting.usecase.RegisterChatConversationAiSettingUseCase;
import com.tarea.application.chatconversationaisetting.usecase.UpdateChatConversationAiSettingUseCase;
import com.tarea.domain.chatconversationaisetting.port.repository.ChatConversationAiSettingRepository;
import com.tarea.infrastructure.chatconversationaisetting.adapters.out.persistence.mappers.ChatConversationAiSettingPersistenceMapper;
import com.tarea.infrastructure.chatconversationaisetting.adapters.out.persistence.repositories.ChatConversationAiSettingJpaRepository;
import com.tarea.infrastructure.chatconversationaisetting.adapters.out.persistence.repositories.ChatConversationAiSettingRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatConversationAiSettingBeansConfig {

    @Bean
    public ChatConversationAiSettingPersistenceMapper chatConversationAiSettingPersistenceMapper() {
        return new ChatConversationAiSettingPersistenceMapper();
    }

    @Bean
    public ChatConversationAiSettingRepository chatConversationAiSettingRepository(ChatConversationAiSettingJpaRepository repository, ChatConversationAiSettingPersistenceMapper mapper) {
        return new ChatConversationAiSettingRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterChatConversationAiSettingUseCase registerChatConversationAiSettingUseCase(ChatConversationAiSettingRepository repository) {
        return new RegisterChatConversationAiSettingUseCase(repository);
    }

    @Bean
    public GetChatConversationAiSettingByIdUseCase getChatConversationAiSettingByIdUseCase(ChatConversationAiSettingRepository repository) {
        return new GetChatConversationAiSettingByIdUseCase(repository);
    }

    @Bean
    public ListChatConversationAiSettingUseCase listChatConversationAiSettingUseCase(ChatConversationAiSettingRepository repository) {
        return new ListChatConversationAiSettingUseCase(repository);
    }

    @Bean
    public UpdateChatConversationAiSettingUseCase updateChatConversationAiSettingUseCase(ChatConversationAiSettingRepository repository) {
        return new UpdateChatConversationAiSettingUseCase(repository);
    }

    @Bean
    public DeleteChatConversationAiSettingUseCase deleteChatConversationAiSettingUseCase(ChatConversationAiSettingRepository repository) {
        return new DeleteChatConversationAiSettingUseCase(repository);
    }
}
