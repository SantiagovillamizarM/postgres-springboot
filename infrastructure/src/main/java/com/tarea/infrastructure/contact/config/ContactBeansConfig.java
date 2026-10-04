package com.tarea.infrastructure.contact.config;

import com.tarea.application.contact.usecase.DeleteContactUseCase;
import com.tarea.application.contact.usecase.GetContactByIdUseCase;
import com.tarea.application.contact.usecase.ListContactUseCase;
import com.tarea.application.contact.usecase.RegisterContactUseCase;
import com.tarea.application.contact.usecase.UpdateContactUseCase;
import com.tarea.domain.contact.port.repository.ContactRepository;
import com.tarea.infrastructure.contact.adapters.out.persistence.mappers.ContactPersistenceMapper;
import com.tarea.infrastructure.contact.adapters.out.persistence.repositories.ContactJpaRepository;
import com.tarea.infrastructure.contact.adapters.out.persistence.repositories.ContactRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContactBeansConfig {

    @Bean
    public ContactPersistenceMapper contactPersistenceMapper() {
        return new ContactPersistenceMapper();
    }

    @Bean
    public ContactRepository contactRepository(ContactJpaRepository repository, ContactPersistenceMapper mapper) {
        return new ContactRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterContactUseCase registerContactUseCase(ContactRepository repository) {
        return new RegisterContactUseCase(repository);
    }

    @Bean
    public GetContactByIdUseCase getContactByIdUseCase(ContactRepository repository) {
        return new GetContactByIdUseCase(repository);
    }

    @Bean
    public ListContactUseCase listContactUseCase(ContactRepository repository) {
        return new ListContactUseCase(repository);
    }

    @Bean
    public UpdateContactUseCase updateContactUseCase(ContactRepository repository) {
        return new UpdateContactUseCase(repository);
    }

    @Bean
    public DeleteContactUseCase deleteContactUseCase(ContactRepository repository) {
        return new DeleteContactUseCase(repository);
    }
}
