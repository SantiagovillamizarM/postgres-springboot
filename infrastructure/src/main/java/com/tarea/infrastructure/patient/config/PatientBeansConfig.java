package com.tarea.infrastructure.patient.config;

import com.tarea.application.patient.usecase.DeletePatientUseCase;
import com.tarea.application.patient.usecase.GetPatientByIdUseCase;
import com.tarea.application.patient.usecase.ListPatientUseCase;
import com.tarea.application.patient.usecase.RegisterPatientUseCase;
import com.tarea.application.patient.usecase.UpdatePatientUseCase;
import com.tarea.domain.patient.port.repository.PatientRepository;
import com.tarea.infrastructure.patient.adapters.out.persistence.mappers.PatientPersistenceMapper;
import com.tarea.infrastructure.patient.adapters.out.persistence.repositories.PatientJpaRepository;
import com.tarea.infrastructure.patient.adapters.out.persistence.repositories.PatientRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PatientBeansConfig {

    @Bean
    public PatientPersistenceMapper patientPersistenceMapper() {
        return new PatientPersistenceMapper();
    }

    @Bean
    public PatientRepository patientRepository(PatientJpaRepository repository, PatientPersistenceMapper mapper) {
        return new PatientRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterPatientUseCase registerPatientUseCase(PatientRepository repository) {
        return new RegisterPatientUseCase(repository);
    }

    @Bean
    public GetPatientByIdUseCase getPatientByIdUseCase(PatientRepository repository) {
        return new GetPatientByIdUseCase(repository);
    }

    @Bean
    public ListPatientUseCase listPatientUseCase(PatientRepository repository) {
        return new ListPatientUseCase(repository);
    }

    @Bean
    public UpdatePatientUseCase updatePatientUseCase(PatientRepository repository) {
        return new UpdatePatientUseCase(repository);
    }

    @Bean
    public DeletePatientUseCase deletePatientUseCase(PatientRepository repository) {
        return new DeletePatientUseCase(repository);
    }
}
