package com.tarea.infrastructure.messagetype.config;

import com.tarea.application.messagetype.usecase.DeleteMessageTypeUseCase;
import com.tarea.application.messagetype.usecase.GetMessageTypeByIdUseCase;
import com.tarea.application.messagetype.usecase.ListMessageTypeUseCase;
import com.tarea.application.messagetype.usecase.RegisterMessageTypeUseCase;
import com.tarea.application.messagetype.usecase.UpdateMessageTypeUseCase;
import com.tarea.domain.messagetype.port.repository.MessageTypeRepository;
import com.tarea.infrastructure.messagetype.adapters.out.persistence.mappers.MessageTypePersistenceMapper;
import com.tarea.infrastructure.messagetype.adapters.out.persistence.repositories.MessageTypeJpaRepository;
import com.tarea.infrastructure.messagetype.adapters.out.persistence.repositories.MessageTypeRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageTypeBeansConfig {

    @Bean
    public MessageTypePersistenceMapper messageTypePersistenceMapper() {
        return new MessageTypePersistenceMapper();
    }

    @Bean
    public MessageTypeRepository messageTypeRepository(MessageTypeJpaRepository repository, MessageTypePersistenceMapper mapper) {
        return new MessageTypeRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterMessageTypeUseCase registerMessageTypeUseCase(MessageTypeRepository repository) {
        return new RegisterMessageTypeUseCase(repository);
    }

    @Bean
    public GetMessageTypeByIdUseCase getMessageTypeByIdUseCase(MessageTypeRepository repository) {
        return new GetMessageTypeByIdUseCase(repository);
    }

    @Bean
    public ListMessageTypeUseCase listMessageTypeUseCase(MessageTypeRepository repository) {
        return new ListMessageTypeUseCase(repository);
    }

    @Bean
    public UpdateMessageTypeUseCase updateMessageTypeUseCase(MessageTypeRepository repository) {
        return new UpdateMessageTypeUseCase(repository);
    }

    @Bean
    public DeleteMessageTypeUseCase deleteMessageTypeUseCase(MessageTypeRepository repository) {
        return new DeleteMessageTypeUseCase(repository);
    }
}
