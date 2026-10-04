package com.tarea.infrastructure.phonecontact.config;

import com.tarea.application.phonecontact.usecase.DeletePhoneContactUseCase;
import com.tarea.application.phonecontact.usecase.GetPhoneContactByIdUseCase;
import com.tarea.application.phonecontact.usecase.ListPhoneContactUseCase;
import com.tarea.application.phonecontact.usecase.RegisterPhoneContactUseCase;
import com.tarea.application.phonecontact.usecase.UpdatePhoneContactUseCase;
import com.tarea.domain.phonecontact.port.repository.PhoneContactRepository;
import com.tarea.infrastructure.phonecontact.adapters.out.persistence.mappers.PhoneContactPersistenceMapper;
import com.tarea.infrastructure.phonecontact.adapters.out.persistence.repositories.PhoneContactJpaRepository;
import com.tarea.infrastructure.phonecontact.adapters.out.persistence.repositories.PhoneContactRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PhoneContactBeansConfig {

    @Bean
    public PhoneContactPersistenceMapper phoneContactPersistenceMapper() {
        return new PhoneContactPersistenceMapper();
    }

    @Bean
    public PhoneContactRepository phoneContactRepository(PhoneContactJpaRepository repository, PhoneContactPersistenceMapper mapper) {
        return new PhoneContactRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterPhoneContactUseCase registerPhoneContactUseCase(PhoneContactRepository repository) {
        return new RegisterPhoneContactUseCase(repository);
    }

    @Bean
    public GetPhoneContactByIdUseCase getPhoneContactByIdUseCase(PhoneContactRepository repository) {
        return new GetPhoneContactByIdUseCase(repository);
    }

    @Bean
    public ListPhoneContactUseCase listPhoneContactUseCase(PhoneContactRepository repository) {
        return new ListPhoneContactUseCase(repository);
    }

    @Bean
    public UpdatePhoneContactUseCase updatePhoneContactUseCase(PhoneContactRepository repository) {
        return new UpdatePhoneContactUseCase(repository);
    }

    @Bean
    public DeletePhoneContactUseCase deletePhoneContactUseCase(PhoneContactRepository repository) {
        return new DeletePhoneContactUseCase(repository);
    }
}
