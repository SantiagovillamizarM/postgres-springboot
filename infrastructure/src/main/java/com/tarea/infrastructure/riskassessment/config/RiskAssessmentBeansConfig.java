package com.tarea.infrastructure.riskassessment.config;

import com.tarea.application.riskassessment.usecase.DeleteRiskAssessmentUseCase;
import com.tarea.application.riskassessment.usecase.GetRiskAssessmentByIdUseCase;
import com.tarea.application.riskassessment.usecase.ListRiskAssessmentUseCase;
import com.tarea.application.riskassessment.usecase.RegisterRiskAssessmentUseCase;
import com.tarea.application.riskassessment.usecase.UpdateRiskAssessmentUseCase;
import com.tarea.domain.riskassessment.port.repository.RiskAssessmentRepository;
import com.tarea.infrastructure.riskassessment.adapters.out.persistence.mappers.RiskAssessmentPersistenceMapper;
import com.tarea.infrastructure.riskassessment.adapters.out.persistence.repositories.RiskAssessmentJpaRepository;
import com.tarea.infrastructure.riskassessment.adapters.out.persistence.repositories.RiskAssessmentRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RiskAssessmentBeansConfig {

    @Bean
    public RiskAssessmentPersistenceMapper riskAssessmentPersistenceMapper() {
        return new RiskAssessmentPersistenceMapper();
    }

    @Bean
    public RiskAssessmentRepository riskAssessmentRepository(RiskAssessmentJpaRepository repository, RiskAssessmentPersistenceMapper mapper) {
        return new RiskAssessmentRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterRiskAssessmentUseCase registerRiskAssessmentUseCase(RiskAssessmentRepository repository) {
        return new RegisterRiskAssessmentUseCase(repository);
    }

    @Bean
    public GetRiskAssessmentByIdUseCase getRiskAssessmentByIdUseCase(RiskAssessmentRepository repository) {
        return new GetRiskAssessmentByIdUseCase(repository);
    }

    @Bean
    public ListRiskAssessmentUseCase listRiskAssessmentUseCase(RiskAssessmentRepository repository) {
        return new ListRiskAssessmentUseCase(repository);
    }

    @Bean
    public UpdateRiskAssessmentUseCase updateRiskAssessmentUseCase(RiskAssessmentRepository repository) {
        return new UpdateRiskAssessmentUseCase(repository);
    }

    @Bean
    public DeleteRiskAssessmentUseCase deleteRiskAssessmentUseCase(RiskAssessmentRepository repository) {
        return new DeleteRiskAssessmentUseCase(repository);
    }
}
