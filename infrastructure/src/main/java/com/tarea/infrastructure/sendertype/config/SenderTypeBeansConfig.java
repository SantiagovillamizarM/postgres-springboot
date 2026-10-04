package com.tarea.infrastructure.sendertype.config;

import com.tarea.application.sendertype.usecase.DeleteSenderTypeUseCase;
import com.tarea.application.sendertype.usecase.GetSenderTypeByIdUseCase;
import com.tarea.application.sendertype.usecase.ListSenderTypeUseCase;
import com.tarea.application.sendertype.usecase.RegisterSenderTypeUseCase;
import com.tarea.application.sendertype.usecase.UpdateSenderTypeUseCase;
import com.tarea.domain.sendertype.port.repository.SenderTypeRepository;
import com.tarea.infrastructure.sendertype.adapters.out.persistence.mappers.SenderTypePersistenceMapper;
import com.tarea.infrastructure.sendertype.adapters.out.persistence.repositories.SenderTypeJpaRepository;
import com.tarea.infrastructure.sendertype.adapters.out.persistence.repositories.SenderTypeRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SenderTypeBeansConfig {

    @Bean
    public SenderTypePersistenceMapper senderTypePersistenceMapper() {
        return new SenderTypePersistenceMapper();
    }

    @Bean
    public SenderTypeRepository senderTypeRepository(SenderTypeJpaRepository repository, SenderTypePersistenceMapper mapper) {
        return new SenderTypeRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterSenderTypeUseCase registerSenderTypeUseCase(SenderTypeRepository repository) {
        return new RegisterSenderTypeUseCase(repository);
    }

    @Bean
    public GetSenderTypeByIdUseCase getSenderTypeByIdUseCase(SenderTypeRepository repository) {
        return new GetSenderTypeByIdUseCase(repository);
    }

    @Bean
    public ListSenderTypeUseCase listSenderTypeUseCase(SenderTypeRepository repository) {
        return new ListSenderTypeUseCase(repository);
    }

    @Bean
    public UpdateSenderTypeUseCase updateSenderTypeUseCase(SenderTypeRepository repository) {
        return new UpdateSenderTypeUseCase(repository);
    }

    @Bean
    public DeleteSenderTypeUseCase deleteSenderTypeUseCase(SenderTypeRepository repository) {
        return new DeleteSenderTypeUseCase(repository);
    }
}
