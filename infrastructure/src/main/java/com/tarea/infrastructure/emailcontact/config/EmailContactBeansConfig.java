package com.tarea.infrastructure.emailcontact.config;

import com.tarea.application.emailcontact.usecase.DeleteEmailContactUseCase;
import com.tarea.application.emailcontact.usecase.GetEmailContactByIdUseCase;
import com.tarea.application.emailcontact.usecase.ListEmailContactUseCase;
import com.tarea.application.emailcontact.usecase.RegisterEmailContactUseCase;
import com.tarea.application.emailcontact.usecase.UpdateEmailContactUseCase;
import com.tarea.domain.emailcontact.port.repository.EmailContactRepository;
import com.tarea.infrastructure.emailcontact.adapters.out.persistence.mappers.EmailContactPersistenceMapper;
import com.tarea.infrastructure.emailcontact.adapters.out.persistence.repositories.EmailContactJpaRepository;
import com.tarea.infrastructure.emailcontact.adapters.out.persistence.repositories.EmailContactRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmailContactBeansConfig {

    @Bean
    public EmailContactPersistenceMapper emailContactPersistenceMapper() {
        return new EmailContactPersistenceMapper();
    }

    @Bean
    public EmailContactRepository emailContactRepository(EmailContactJpaRepository repository, EmailContactPersistenceMapper mapper) {
        return new EmailContactRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterEmailContactUseCase registerEmailContactUseCase(EmailContactRepository repository) {
        return new RegisterEmailContactUseCase(repository);
    }

    @Bean
    public GetEmailContactByIdUseCase getEmailContactByIdUseCase(EmailContactRepository repository) {
        return new GetEmailContactByIdUseCase(repository);
    }

    @Bean
    public ListEmailContactUseCase listEmailContactUseCase(EmailContactRepository repository) {
        return new ListEmailContactUseCase(repository);
    }

    @Bean
    public UpdateEmailContactUseCase updateEmailContactUseCase(EmailContactRepository repository) {
        return new UpdateEmailContactUseCase(repository);
    }

    @Bean
    public DeleteEmailContactUseCase deleteEmailContactUseCase(EmailContactRepository repository) {
        return new DeleteEmailContactUseCase(repository);
    }
}
