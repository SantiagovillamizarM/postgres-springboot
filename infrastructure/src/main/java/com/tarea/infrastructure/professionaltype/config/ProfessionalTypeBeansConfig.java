package com.tarea.infrastructure.professionaltype.config;

import com.tarea.application.professionaltype.usecase.DeleteProfessionalTypeUseCase;
import com.tarea.application.professionaltype.usecase.GetProfessionalTypeByIdUseCase;
import com.tarea.application.professionaltype.usecase.ListProfessionalTypeUseCase;
import com.tarea.application.professionaltype.usecase.RegisterProfessionalTypeUseCase;
import com.tarea.application.professionaltype.usecase.UpdateProfessionalTypeUseCase;
import com.tarea.domain.professionaltype.port.repository.ProfessionalTypeRepository;
import com.tarea.infrastructure.professionaltype.adapters.out.persistence.mappers.ProfessionalTypePersistenceMapper;
import com.tarea.infrastructure.professionaltype.adapters.out.persistence.repositories.ProfessionalTypeJpaRepository;
import com.tarea.infrastructure.professionaltype.adapters.out.persistence.repositories.ProfessionalTypeRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProfessionalTypeBeansConfig {

    @Bean
    public ProfessionalTypePersistenceMapper professionalTypePersistenceMapper() {
        return new ProfessionalTypePersistenceMapper();
    }

    @Bean
    public ProfessionalTypeRepository professionalTypeRepository(ProfessionalTypeJpaRepository repository, ProfessionalTypePersistenceMapper mapper) {
        return new ProfessionalTypeRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterProfessionalTypeUseCase registerProfessionalTypeUseCase(ProfessionalTypeRepository repository) {
        return new RegisterProfessionalTypeUseCase(repository);
    }

    @Bean
    public GetProfessionalTypeByIdUseCase getProfessionalTypeByIdUseCase(ProfessionalTypeRepository repository) {
        return new GetProfessionalTypeByIdUseCase(repository);
    }

    @Bean
    public ListProfessionalTypeUseCase listProfessionalTypeUseCase(ProfessionalTypeRepository repository) {
        return new ListProfessionalTypeUseCase(repository);
    }

    @Bean
    public UpdateProfessionalTypeUseCase updateProfessionalTypeUseCase(ProfessionalTypeRepository repository) {
        return new UpdateProfessionalTypeUseCase(repository);
    }

    @Bean
    public DeleteProfessionalTypeUseCase deleteProfessionalTypeUseCase(ProfessionalTypeRepository repository) {
        return new DeleteProfessionalTypeUseCase(repository);
    }
}
