package com.tarea.infrastructure.patientcontact.config;

import com.tarea.application.patientcontact.usecase.DeletePatientContactUseCase;
import com.tarea.application.patientcontact.usecase.GetPatientContactByIdUseCase;
import com.tarea.application.patientcontact.usecase.ListPatientContactUseCase;
import com.tarea.application.patientcontact.usecase.RegisterPatientContactUseCase;
import com.tarea.application.patientcontact.usecase.UpdatePatientContactUseCase;
import com.tarea.domain.patientcontact.port.repository.PatientContactRepository;
import com.tarea.infrastructure.patientcontact.adapters.out.persistence.mappers.PatientContactPersistenceMapper;
import com.tarea.infrastructure.patientcontact.adapters.out.persistence.repositories.PatientContactJpaRepository;
import com.tarea.infrastructure.patientcontact.adapters.out.persistence.repositories.PatientContactRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PatientContactBeansConfig {

    @Bean
    public PatientContactPersistenceMapper patientContactPersistenceMapper() {
        return new PatientContactPersistenceMapper();
    }

    @Bean
    public PatientContactRepository patientContactRepository(PatientContactJpaRepository repository, PatientContactPersistenceMapper mapper) {
        return new PatientContactRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterPatientContactUseCase registerPatientContactUseCase(PatientContactRepository repository) {
        return new RegisterPatientContactUseCase(repository);
    }

    @Bean
    public GetPatientContactByIdUseCase getPatientContactByIdUseCase(PatientContactRepository repository) {
        return new GetPatientContactByIdUseCase(repository);
    }

    @Bean
    public ListPatientContactUseCase listPatientContactUseCase(PatientContactRepository repository) {
        return new ListPatientContactUseCase(repository);
    }

    @Bean
    public UpdatePatientContactUseCase updatePatientContactUseCase(PatientContactRepository repository) {
        return new UpdatePatientContactUseCase(repository);
    }

    @Bean
    public DeletePatientContactUseCase deletePatientContactUseCase(PatientContactRepository repository) {
        return new DeletePatientContactUseCase(repository);
    }
}
