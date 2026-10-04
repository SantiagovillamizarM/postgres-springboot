package com.tarea.infrastructure.relationshiptype.config;

import com.tarea.application.relationshiptype.usecase.DeleteRelationshipTypeUseCase;
import com.tarea.application.relationshiptype.usecase.GetRelationshipTypeByIdUseCase;
import com.tarea.application.relationshiptype.usecase.ListRelationshipTypeUseCase;
import com.tarea.application.relationshiptype.usecase.RegisterRelationshipTypeUseCase;
import com.tarea.application.relationshiptype.usecase.UpdateRelationshipTypeUseCase;
import com.tarea.domain.relationshiptype.port.repository.RelationshipTypeRepository;
import com.tarea.infrastructure.relationshiptype.adapters.out.persistence.mappers.RelationshipTypePersistenceMapper;
import com.tarea.infrastructure.relationshiptype.adapters.out.persistence.repositories.RelationshipTypeJpaRepository;
import com.tarea.infrastructure.relationshiptype.adapters.out.persistence.repositories.RelationshipTypeRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RelationshipTypeBeansConfig {

    @Bean
    public RelationshipTypePersistenceMapper relationshipTypePersistenceMapper() {
        return new RelationshipTypePersistenceMapper();
    }

    @Bean
    public RelationshipTypeRepository relationshipTypeRepository(RelationshipTypeJpaRepository repository, RelationshipTypePersistenceMapper mapper) {
        return new RelationshipTypeRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterRelationshipTypeUseCase registerRelationshipTypeUseCase(RelationshipTypeRepository repository) {
        return new RegisterRelationshipTypeUseCase(repository);
    }

    @Bean
    public GetRelationshipTypeByIdUseCase getRelationshipTypeByIdUseCase(RelationshipTypeRepository repository) {
        return new GetRelationshipTypeByIdUseCase(repository);
    }

    @Bean
    public ListRelationshipTypeUseCase listRelationshipTypeUseCase(RelationshipTypeRepository repository) {
        return new ListRelationshipTypeUseCase(repository);
    }

    @Bean
    public UpdateRelationshipTypeUseCase updateRelationshipTypeUseCase(RelationshipTypeRepository repository) {
        return new UpdateRelationshipTypeUseCase(repository);
    }

    @Bean
    public DeleteRelationshipTypeUseCase deleteRelationshipTypeUseCase(RelationshipTypeRepository repository) {
        return new DeleteRelationshipTypeUseCase(repository);
    }
}
