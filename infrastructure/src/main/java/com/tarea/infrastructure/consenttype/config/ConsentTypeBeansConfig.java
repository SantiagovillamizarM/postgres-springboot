package com.tarea.infrastructure.consenttype.config;

import com.tarea.application.consenttype.usecase.DeleteConsentTypeUseCase;
import com.tarea.application.consenttype.usecase.GetConsentTypeByIdUseCase;
import com.tarea.application.consenttype.usecase.ListConsentTypeUseCase;
import com.tarea.application.consenttype.usecase.RegisterConsentTypeUseCase;
import com.tarea.application.consenttype.usecase.UpdateConsentTypeUseCase;
import com.tarea.domain.consenttype.port.repository.ConsentTypeRepository;
import com.tarea.infrastructure.consenttype.adapters.out.persistence.mappers.ConsentTypePersistenceMapper;
import com.tarea.infrastructure.consenttype.adapters.out.persistence.repositories.ConsentTypeJpaRepository;
import com.tarea.infrastructure.consenttype.adapters.out.persistence.repositories.ConsentTypeRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsentTypeBeansConfig {

    @Bean
    public ConsentTypePersistenceMapper consentTypePersistenceMapper() {
        return new ConsentTypePersistenceMapper();
    }

    @Bean
    public ConsentTypeRepository consentTypeRepository(ConsentTypeJpaRepository repository, ConsentTypePersistenceMapper mapper) {
        return new ConsentTypeRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterConsentTypeUseCase registerConsentTypeUseCase(ConsentTypeRepository repository) {
        return new RegisterConsentTypeUseCase(repository);
    }

    @Bean
    public GetConsentTypeByIdUseCase getConsentTypeByIdUseCase(ConsentTypeRepository repository) {
        return new GetConsentTypeByIdUseCase(repository);
    }

    @Bean
    public ListConsentTypeUseCase listConsentTypeUseCase(ConsentTypeRepository repository) {
        return new ListConsentTypeUseCase(repository);
    }

    @Bean
    public UpdateConsentTypeUseCase updateConsentTypeUseCase(ConsentTypeRepository repository) {
        return new UpdateConsentTypeUseCase(repository);
    }

    @Bean
    public DeleteConsentTypeUseCase deleteConsentTypeUseCase(ConsentTypeRepository repository) {
        return new DeleteConsentTypeUseCase(repository);
    }
}
