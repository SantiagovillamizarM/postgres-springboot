package com.tarea.infrastructure.treatmentstatus.config;

import com.tarea.application.treatmentstatus.usecase.DeleteTreatmentStatusUseCase;
import com.tarea.application.treatmentstatus.usecase.GetTreatmentStatusByIdUseCase;
import com.tarea.application.treatmentstatus.usecase.ListTreatmentStatusUseCase;
import com.tarea.application.treatmentstatus.usecase.RegisterTreatmentStatusUseCase;
import com.tarea.application.treatmentstatus.usecase.UpdateTreatmentStatusUseCase;
import com.tarea.domain.treatmentstatus.port.repository.TreatmentStatusRepository;
import com.tarea.infrastructure.treatmentstatus.adapters.out.persistence.mappers.TreatmentStatusPersistenceMapper;
import com.tarea.infrastructure.treatmentstatus.adapters.out.persistence.repositories.TreatmentStatusJpaRepository;
import com.tarea.infrastructure.treatmentstatus.adapters.out.persistence.repositories.TreatmentStatusRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TreatmentStatusBeansConfig {

    @Bean
    public TreatmentStatusPersistenceMapper treatmentStatusPersistenceMapper() {
        return new TreatmentStatusPersistenceMapper();
    }

    @Bean
    public TreatmentStatusRepository treatmentStatusRepository(TreatmentStatusJpaRepository repository, TreatmentStatusPersistenceMapper mapper) {
        return new TreatmentStatusRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterTreatmentStatusUseCase registerTreatmentStatusUseCase(TreatmentStatusRepository repository) {
        return new RegisterTreatmentStatusUseCase(repository);
    }

    @Bean
    public GetTreatmentStatusByIdUseCase getTreatmentStatusByIdUseCase(TreatmentStatusRepository repository) {
        return new GetTreatmentStatusByIdUseCase(repository);
    }

    @Bean
    public ListTreatmentStatusUseCase listTreatmentStatusUseCase(TreatmentStatusRepository repository) {
        return new ListTreatmentStatusUseCase(repository);
    }

    @Bean
    public UpdateTreatmentStatusUseCase updateTreatmentStatusUseCase(TreatmentStatusRepository repository) {
        return new UpdateTreatmentStatusUseCase(repository);
    }

    @Bean
    public DeleteTreatmentStatusUseCase deleteTreatmentStatusUseCase(TreatmentStatusRepository repository) {
        return new DeleteTreatmentStatusUseCase(repository);
    }
}
