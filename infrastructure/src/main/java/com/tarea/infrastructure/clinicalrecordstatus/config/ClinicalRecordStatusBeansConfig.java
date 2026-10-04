package com.tarea.infrastructure.clinicalrecordstatus.config;

import com.tarea.application.clinicalrecordstatus.usecase.DeleteClinicalRecordStatusUseCase;
import com.tarea.application.clinicalrecordstatus.usecase.GetClinicalRecordStatusByIdUseCase;
import com.tarea.application.clinicalrecordstatus.usecase.ListClinicalRecordStatusUseCase;
import com.tarea.application.clinicalrecordstatus.usecase.RegisterClinicalRecordStatusUseCase;
import com.tarea.application.clinicalrecordstatus.usecase.UpdateClinicalRecordStatusUseCase;
import com.tarea.domain.clinicalrecordstatus.port.repository.ClinicalRecordStatusRepository;
import com.tarea.infrastructure.clinicalrecordstatus.adapters.out.persistence.mappers.ClinicalRecordStatusPersistenceMapper;
import com.tarea.infrastructure.clinicalrecordstatus.adapters.out.persistence.repositories.ClinicalRecordStatusJpaRepository;
import com.tarea.infrastructure.clinicalrecordstatus.adapters.out.persistence.repositories.ClinicalRecordStatusRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClinicalRecordStatusBeansConfig {

    @Bean
    public ClinicalRecordStatusPersistenceMapper clinicalRecordStatusPersistenceMapper() {
        return new ClinicalRecordStatusPersistenceMapper();
    }

    @Bean
    public ClinicalRecordStatusRepository clinicalRecordStatusRepository(ClinicalRecordStatusJpaRepository repository, ClinicalRecordStatusPersistenceMapper mapper) {
        return new ClinicalRecordStatusRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterClinicalRecordStatusUseCase registerClinicalRecordStatusUseCase(ClinicalRecordStatusRepository repository) {
        return new RegisterClinicalRecordStatusUseCase(repository);
    }

    @Bean
    public GetClinicalRecordStatusByIdUseCase getClinicalRecordStatusByIdUseCase(ClinicalRecordStatusRepository repository) {
        return new GetClinicalRecordStatusByIdUseCase(repository);
    }

    @Bean
    public ListClinicalRecordStatusUseCase listClinicalRecordStatusUseCase(ClinicalRecordStatusRepository repository) {
        return new ListClinicalRecordStatusUseCase(repository);
    }

    @Bean
    public UpdateClinicalRecordStatusUseCase updateClinicalRecordStatusUseCase(ClinicalRecordStatusRepository repository) {
        return new UpdateClinicalRecordStatusUseCase(repository);
    }

    @Bean
    public DeleteClinicalRecordStatusUseCase deleteClinicalRecordStatusUseCase(ClinicalRecordStatusRepository repository) {
        return new DeleteClinicalRecordStatusUseCase(repository);
    }
}
