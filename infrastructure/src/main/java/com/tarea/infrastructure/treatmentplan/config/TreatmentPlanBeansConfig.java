package com.tarea.infrastructure.treatmentplan.config;

import com.tarea.application.treatmentplan.usecase.DeleteTreatmentPlanUseCase;
import com.tarea.application.treatmentplan.usecase.GetTreatmentPlanByIdUseCase;
import com.tarea.application.treatmentplan.usecase.ListTreatmentPlanUseCase;
import com.tarea.application.treatmentplan.usecase.RegisterTreatmentPlanUseCase;
import com.tarea.application.treatmentplan.usecase.UpdateTreatmentPlanUseCase;
import com.tarea.domain.treatmentplan.port.repository.TreatmentPlanRepository;
import com.tarea.infrastructure.treatmentplan.adapters.out.persistence.mappers.TreatmentPlanPersistenceMapper;
import com.tarea.infrastructure.treatmentplan.adapters.out.persistence.repositories.TreatmentPlanJpaRepository;
import com.tarea.infrastructure.treatmentplan.adapters.out.persistence.repositories.TreatmentPlanRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TreatmentPlanBeansConfig {

    @Bean
    public TreatmentPlanPersistenceMapper treatmentPlanPersistenceMapper() {
        return new TreatmentPlanPersistenceMapper();
    }

    @Bean
    public TreatmentPlanRepository treatmentPlanRepository(TreatmentPlanJpaRepository repository, TreatmentPlanPersistenceMapper mapper) {
        return new TreatmentPlanRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterTreatmentPlanUseCase registerTreatmentPlanUseCase(TreatmentPlanRepository repository) {
        return new RegisterTreatmentPlanUseCase(repository);
    }

    @Bean
    public GetTreatmentPlanByIdUseCase getTreatmentPlanByIdUseCase(TreatmentPlanRepository repository) {
        return new GetTreatmentPlanByIdUseCase(repository);
    }

    @Bean
    public ListTreatmentPlanUseCase listTreatmentPlanUseCase(TreatmentPlanRepository repository) {
        return new ListTreatmentPlanUseCase(repository);
    }

    @Bean
    public UpdateTreatmentPlanUseCase updateTreatmentPlanUseCase(TreatmentPlanRepository repository) {
        return new UpdateTreatmentPlanUseCase(repository);
    }

    @Bean
    public DeleteTreatmentPlanUseCase deleteTreatmentPlanUseCase(TreatmentPlanRepository repository) {
        return new DeleteTreatmentPlanUseCase(repository);
    }
}
