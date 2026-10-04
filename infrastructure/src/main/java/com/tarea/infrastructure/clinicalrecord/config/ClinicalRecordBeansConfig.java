package com.tarea.infrastructure.clinicalrecord.config;

import com.tarea.application.clinicalrecord.usecase.DeleteClinicalRecordUseCase;
import com.tarea.application.clinicalrecord.usecase.GetClinicalRecordByIdUseCase;
import com.tarea.application.clinicalrecord.usecase.ListClinicalRecordUseCase;
import com.tarea.application.clinicalrecord.usecase.RegisterClinicalRecordUseCase;
import com.tarea.application.clinicalrecord.usecase.UpdateClinicalRecordUseCase;
import com.tarea.domain.clinicalrecord.port.repository.ClinicalRecordRepository;
import com.tarea.infrastructure.clinicalrecord.adapters.out.persistence.mappers.ClinicalRecordPersistenceMapper;
import com.tarea.infrastructure.clinicalrecord.adapters.out.persistence.repositories.ClinicalRecordJpaRepository;
import com.tarea.infrastructure.clinicalrecord.adapters.out.persistence.repositories.ClinicalRecordRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClinicalRecordBeansConfig {

    @Bean
    public ClinicalRecordPersistenceMapper clinicalRecordPersistenceMapper() {
        return new ClinicalRecordPersistenceMapper();
    }

    @Bean
    public ClinicalRecordRepository clinicalRecordRepository(ClinicalRecordJpaRepository repository, ClinicalRecordPersistenceMapper mapper) {
        return new ClinicalRecordRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterClinicalRecordUseCase registerClinicalRecordUseCase(ClinicalRecordRepository repository) {
        return new RegisterClinicalRecordUseCase(repository);
    }

    @Bean
    public GetClinicalRecordByIdUseCase getClinicalRecordByIdUseCase(ClinicalRecordRepository repository) {
        return new GetClinicalRecordByIdUseCase(repository);
    }

    @Bean
    public ListClinicalRecordUseCase listClinicalRecordUseCase(ClinicalRecordRepository repository) {
        return new ListClinicalRecordUseCase(repository);
    }

    @Bean
    public UpdateClinicalRecordUseCase updateClinicalRecordUseCase(ClinicalRecordRepository repository) {
        return new UpdateClinicalRecordUseCase(repository);
    }

    @Bean
    public DeleteClinicalRecordUseCase deleteClinicalRecordUseCase(ClinicalRecordRepository repository) {
        return new DeleteClinicalRecordUseCase(repository);
    }
}
