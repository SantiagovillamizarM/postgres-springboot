package com.tarea.infrastructure.clinicalnote.config;

import com.tarea.application.clinicalnote.usecase.DeleteClinicalNoteUseCase;
import com.tarea.application.clinicalnote.usecase.GetClinicalNoteByIdUseCase;
import com.tarea.application.clinicalnote.usecase.ListClinicalNoteUseCase;
import com.tarea.application.clinicalnote.usecase.RegisterClinicalNoteUseCase;
import com.tarea.application.clinicalnote.usecase.UpdateClinicalNoteUseCase;
import com.tarea.domain.clinicalnote.port.repository.ClinicalNoteRepository;
import com.tarea.infrastructure.clinicalnote.adapters.out.persistence.mappers.ClinicalNotePersistenceMapper;
import com.tarea.infrastructure.clinicalnote.adapters.out.persistence.repositories.ClinicalNoteJpaRepository;
import com.tarea.infrastructure.clinicalnote.adapters.out.persistence.repositories.ClinicalNoteRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClinicalNoteBeansConfig {

    @Bean
    public ClinicalNotePersistenceMapper clinicalNotePersistenceMapper() {
        return new ClinicalNotePersistenceMapper();
    }

    @Bean
    public ClinicalNoteRepository clinicalNoteRepository(ClinicalNoteJpaRepository repository, ClinicalNotePersistenceMapper mapper) {
        return new ClinicalNoteRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterClinicalNoteUseCase registerClinicalNoteUseCase(ClinicalNoteRepository repository) {
        return new RegisterClinicalNoteUseCase(repository);
    }

    @Bean
    public GetClinicalNoteByIdUseCase getClinicalNoteByIdUseCase(ClinicalNoteRepository repository) {
        return new GetClinicalNoteByIdUseCase(repository);
    }

    @Bean
    public ListClinicalNoteUseCase listClinicalNoteUseCase(ClinicalNoteRepository repository) {
        return new ListClinicalNoteUseCase(repository);
    }

    @Bean
    public UpdateClinicalNoteUseCase updateClinicalNoteUseCase(ClinicalNoteRepository repository) {
        return new UpdateClinicalNoteUseCase(repository);
    }

    @Bean
    public DeleteClinicalNoteUseCase deleteClinicalNoteUseCase(ClinicalNoteRepository repository) {
        return new DeleteClinicalNoteUseCase(repository);
    }
}
