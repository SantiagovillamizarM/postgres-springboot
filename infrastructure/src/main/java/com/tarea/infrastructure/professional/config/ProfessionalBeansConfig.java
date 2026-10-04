package com.tarea.infrastructure.professional.config;

import com.tarea.application.professional.usecase.DeleteProfessionalUseCase;
import com.tarea.application.professional.usecase.GetProfessionalByIdUseCase;
import com.tarea.application.professional.usecase.ListProfessionalUseCase;
import com.tarea.application.professional.usecase.RegisterProfessionalUseCase;
import com.tarea.application.professional.usecase.UpdateProfessionalUseCase;
import com.tarea.domain.professional.port.repository.ProfessionalRepository;
import com.tarea.infrastructure.professional.adapters.out.persistence.mappers.ProfessionalPersistenceMapper;
import com.tarea.infrastructure.professional.adapters.out.persistence.repositories.ProfessionalJpaRepository;
import com.tarea.infrastructure.professional.adapters.out.persistence.repositories.ProfessionalRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProfessionalBeansConfig {

    @Bean
    public ProfessionalPersistenceMapper professionalPersistenceMapper() {
        return new ProfessionalPersistenceMapper();
    }

    @Bean
    public ProfessionalRepository professionalRepository(ProfessionalJpaRepository repository, ProfessionalPersistenceMapper mapper) {
        return new ProfessionalRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterProfessionalUseCase registerProfessionalUseCase(ProfessionalRepository repository) {
        return new RegisterProfessionalUseCase(repository);
    }

    @Bean
    public GetProfessionalByIdUseCase getProfessionalByIdUseCase(ProfessionalRepository repository) {
        return new GetProfessionalByIdUseCase(repository);
    }

    @Bean
    public ListProfessionalUseCase listProfessionalUseCase(ProfessionalRepository repository) {
        return new ListProfessionalUseCase(repository);
    }

    @Bean
    public UpdateProfessionalUseCase updateProfessionalUseCase(ProfessionalRepository repository) {
        return new UpdateProfessionalUseCase(repository);
    }

    @Bean
    public DeleteProfessionalUseCase deleteProfessionalUseCase(ProfessionalRepository repository) {
        return new DeleteProfessionalUseCase(repository);
    }
}
