package com.tarea.infrastructure.chatparticipant.config;

import com.tarea.application.chatparticipant.usecase.DeleteChatParticipantUseCase;
import com.tarea.application.chatparticipant.usecase.GetChatParticipantByIdUseCase;
import com.tarea.application.chatparticipant.usecase.ListChatParticipantUseCase;
import com.tarea.application.chatparticipant.usecase.RegisterChatParticipantUseCase;
import com.tarea.application.chatparticipant.usecase.UpdateChatParticipantUseCase;
import com.tarea.domain.chatparticipant.port.repository.ChatParticipantRepository;
import com.tarea.infrastructure.chatparticipant.adapters.out.persistence.mappers.ChatParticipantPersistenceMapper;
import com.tarea.infrastructure.chatparticipant.adapters.out.persistence.repositories.ChatParticipantJpaRepository;
import com.tarea.infrastructure.chatparticipant.adapters.out.persistence.repositories.ChatParticipantRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatParticipantBeansConfig {

    @Bean
    public ChatParticipantPersistenceMapper chatParticipantPersistenceMapper() {
        return new ChatParticipantPersistenceMapper();
    }

    @Bean
    public ChatParticipantRepository chatParticipantRepository(ChatParticipantJpaRepository repository, ChatParticipantPersistenceMapper mapper) {
        return new ChatParticipantRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterChatParticipantUseCase registerChatParticipantUseCase(ChatParticipantRepository repository) {
        return new RegisterChatParticipantUseCase(repository);
    }

    @Bean
    public GetChatParticipantByIdUseCase getChatParticipantByIdUseCase(ChatParticipantRepository repository) {
        return new GetChatParticipantByIdUseCase(repository);
    }

    @Bean
    public ListChatParticipantUseCase listChatParticipantUseCase(ChatParticipantRepository repository) {
        return new ListChatParticipantUseCase(repository);
    }

    @Bean
    public UpdateChatParticipantUseCase updateChatParticipantUseCase(ChatParticipantRepository repository) {
        return new UpdateChatParticipantUseCase(repository);
    }

    @Bean
    public DeleteChatParticipantUseCase deleteChatParticipantUseCase(ChatParticipantRepository repository) {
        return new DeleteChatParticipantUseCase(repository);
    }
}
