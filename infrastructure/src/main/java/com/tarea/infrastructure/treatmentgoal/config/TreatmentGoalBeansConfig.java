package com.tarea.infrastructure.treatmentgoal.config;

import com.tarea.application.treatmentgoal.usecase.DeleteTreatmentGoalUseCase;
import com.tarea.application.treatmentgoal.usecase.GetTreatmentGoalByIdUseCase;
import com.tarea.application.treatmentgoal.usecase.ListTreatmentGoalUseCase;
import com.tarea.application.treatmentgoal.usecase.RegisterTreatmentGoalUseCase;
import com.tarea.application.treatmentgoal.usecase.UpdateTreatmentGoalUseCase;
import com.tarea.domain.treatmentgoal.port.repository.TreatmentGoalRepository;
import com.tarea.infrastructure.treatmentgoal.adapters.out.persistence.mappers.TreatmentGoalPersistenceMapper;
import com.tarea.infrastructure.treatmentgoal.adapters.out.persistence.repositories.TreatmentGoalJpaRepository;
import com.tarea.infrastructure.treatmentgoal.adapters.out.persistence.repositories.TreatmentGoalRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TreatmentGoalBeansConfig {

    @Bean
    public TreatmentGoalPersistenceMapper treatmentGoalPersistenceMapper() {
        return new TreatmentGoalPersistenceMapper();
    }

    @Bean
    public TreatmentGoalRepository treatmentGoalRepository(TreatmentGoalJpaRepository repository, TreatmentGoalPersistenceMapper mapper) {
        return new TreatmentGoalRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterTreatmentGoalUseCase registerTreatmentGoalUseCase(TreatmentGoalRepository repository) {
        return new RegisterTreatmentGoalUseCase(repository);
    }

    @Bean
    public GetTreatmentGoalByIdUseCase getTreatmentGoalByIdUseCase(TreatmentGoalRepository repository) {
        return new GetTreatmentGoalByIdUseCase(repository);
    }

    @Bean
    public ListTreatmentGoalUseCase listTreatmentGoalUseCase(TreatmentGoalRepository repository) {
        return new ListTreatmentGoalUseCase(repository);
    }

    @Bean
    public UpdateTreatmentGoalUseCase updateTreatmentGoalUseCase(TreatmentGoalRepository repository) {
        return new UpdateTreatmentGoalUseCase(repository);
    }

    @Bean
    public DeleteTreatmentGoalUseCase deleteTreatmentGoalUseCase(TreatmentGoalRepository repository) {
        return new DeleteTreatmentGoalUseCase(repository);
    }
}
