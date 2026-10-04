package com.tarea.infrastructure.patientallergy.config;

import com.tarea.application.patientallergy.usecase.DeletePatientAllergyUseCase;
import com.tarea.application.patientallergy.usecase.GetPatientAllergyByIdUseCase;
import com.tarea.application.patientallergy.usecase.ListPatientAllergyUseCase;
import com.tarea.application.patientallergy.usecase.RegisterPatientAllergyUseCase;
import com.tarea.application.patientallergy.usecase.UpdatePatientAllergyUseCase;
import com.tarea.domain.patientallergy.port.repository.PatientAllergyRepository;
import com.tarea.infrastructure.patientallergy.adapters.out.persistence.mappers.PatientAllergyPersistenceMapper;
import com.tarea.infrastructure.patientallergy.adapters.out.persistence.repositories.PatientAllergyJpaRepository;
import com.tarea.infrastructure.patientallergy.adapters.out.persistence.repositories.PatientAllergyRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PatientAllergyBeansConfig {

    @Bean
    public PatientAllergyPersistenceMapper patientAllergyPersistenceMapper() {
        return new PatientAllergyPersistenceMapper();
    }

    @Bean
    public PatientAllergyRepository patientAllergyRepository(PatientAllergyJpaRepository repository, PatientAllergyPersistenceMapper mapper) {
        return new PatientAllergyRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterPatientAllergyUseCase registerPatientAllergyUseCase(PatientAllergyRepository repository) {
        return new RegisterPatientAllergyUseCase(repository);
    }

    @Bean
    public GetPatientAllergyByIdUseCase getPatientAllergyByIdUseCase(PatientAllergyRepository repository) {
        return new GetPatientAllergyByIdUseCase(repository);
    }

    @Bean
    public ListPatientAllergyUseCase listPatientAllergyUseCase(PatientAllergyRepository repository) {
        return new ListPatientAllergyUseCase(repository);
    }

    @Bean
    public UpdatePatientAllergyUseCase updatePatientAllergyUseCase(PatientAllergyRepository repository) {
        return new UpdatePatientAllergyUseCase(repository);
    }

    @Bean
    public DeletePatientAllergyUseCase deletePatientAllergyUseCase(PatientAllergyRepository repository) {
        return new DeletePatientAllergyUseCase(repository);
    }
}
