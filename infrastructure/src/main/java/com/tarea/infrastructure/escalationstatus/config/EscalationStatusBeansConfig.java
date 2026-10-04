package com.tarea.infrastructure.escalationstatus.config;

import com.tarea.application.escalationstatus.usecase.DeleteEscalationStatusUseCase;
import com.tarea.application.escalationstatus.usecase.GetEscalationStatusByIdUseCase;
import com.tarea.application.escalationstatus.usecase.ListEscalationStatusUseCase;
import com.tarea.application.escalationstatus.usecase.RegisterEscalationStatusUseCase;
import com.tarea.application.escalationstatus.usecase.UpdateEscalationStatusUseCase;
import com.tarea.domain.escalationstatus.port.repository.EscalationStatusRepository;
import com.tarea.infrastructure.escalationstatus.adapters.out.persistence.mappers.EscalationStatusPersistenceMapper;
import com.tarea.infrastructure.escalationstatus.adapters.out.persistence.repositories.EscalationStatusJpaRepository;
import com.tarea.infrastructure.escalationstatus.adapters.out.persistence.repositories.EscalationStatusRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EscalationStatusBeansConfig {

    @Bean
    public EscalationStatusPersistenceMapper escalationStatusPersistenceMapper() {
        return new EscalationStatusPersistenceMapper();
    }

    @Bean
    public EscalationStatusRepository escalationStatusRepository(EscalationStatusJpaRepository repository, EscalationStatusPersistenceMapper mapper) {
        return new EscalationStatusRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterEscalationStatusUseCase registerEscalationStatusUseCase(EscalationStatusRepository repository) {
        return new RegisterEscalationStatusUseCase(repository);
    }

    @Bean
    public GetEscalationStatusByIdUseCase getEscalationStatusByIdUseCase(EscalationStatusRepository repository) {
        return new GetEscalationStatusByIdUseCase(repository);
    }

    @Bean
    public ListEscalationStatusUseCase listEscalationStatusUseCase(EscalationStatusRepository repository) {
        return new ListEscalationStatusUseCase(repository);
    }

    @Bean
    public UpdateEscalationStatusUseCase updateEscalationStatusUseCase(EscalationStatusRepository repository) {
        return new UpdateEscalationStatusUseCase(repository);
    }

    @Bean
    public DeleteEscalationStatusUseCase deleteEscalationStatusUseCase(EscalationStatusRepository repository) {
        return new DeleteEscalationStatusUseCase(repository);
    }
}
