package com.tarea.infrastructure.documenttype.config;

import com.tarea.application.documenttype.usecase.DeleteDocumentTypeUseCase;
import com.tarea.application.documenttype.usecase.GetDocumentTypeByIdUseCase;
import com.tarea.application.documenttype.usecase.ListDocumentTypeUseCase;
import com.tarea.application.documenttype.usecase.RegisterDocumentTypeUseCase;
import com.tarea.application.documenttype.usecase.UpdateDocumentTypeUseCase;
import com.tarea.domain.documenttype.port.repository.DocumentTypeRepository;
import com.tarea.infrastructure.documenttype.adapters.out.persistence.mappers.DocumentTypePersistenceMapper;
import com.tarea.infrastructure.documenttype.adapters.out.persistence.repositories.DocumentTypeJpaRepository;
import com.tarea.infrastructure.documenttype.adapters.out.persistence.repositories.DocumentTypeRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DocumentTypeBeansConfig {

    @Bean
    public DocumentTypePersistenceMapper documentTypePersistenceMapper() {
        return new DocumentTypePersistenceMapper();
    }

    @Bean
    public DocumentTypeRepository documentTypeRepository(DocumentTypeJpaRepository repository, DocumentTypePersistenceMapper mapper) {
        return new DocumentTypeRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterDocumentTypeUseCase registerDocumentTypeUseCase(DocumentTypeRepository repository) {
        return new RegisterDocumentTypeUseCase(repository);
    }

    @Bean
    public GetDocumentTypeByIdUseCase getDocumentTypeByIdUseCase(DocumentTypeRepository repository) {
        return new GetDocumentTypeByIdUseCase(repository);
    }

    @Bean
    public ListDocumentTypeUseCase listDocumentTypeUseCase(DocumentTypeRepository repository) {
        return new ListDocumentTypeUseCase(repository);
    }

    @Bean
    public UpdateDocumentTypeUseCase updateDocumentTypeUseCase(DocumentTypeRepository repository) {
        return new UpdateDocumentTypeUseCase(repository);
    }

    @Bean
    public DeleteDocumentTypeUseCase deleteDocumentTypeUseCase(DocumentTypeRepository repository) {
        return new DeleteDocumentTypeUseCase(repository);
    }
}
