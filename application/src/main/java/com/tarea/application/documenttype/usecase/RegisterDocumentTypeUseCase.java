package com.tarea.application.documenttype.usecase;

import com.tarea.application.documenttype.command.RegisterDocumentTypeCommand;
import com.tarea.application.documenttype.dto.DocumentTypeResponse;
import com.tarea.domain.documenttype.model.aggregate.DocumentType;
import com.tarea.domain.documenttype.port.repository.DocumentTypeRepository;

public class RegisterDocumentTypeUseCase {

    private final DocumentTypeRepository documentTypeRepository;

    public RegisterDocumentTypeUseCase(DocumentTypeRepository documentTypeRepository) {
        this.documentTypeRepository = documentTypeRepository;
    }

    public DocumentTypeResponse execute(RegisterDocumentTypeCommand command) {
        DocumentType documentType = DocumentType.register(
                command.code(),
                command.name(),
                command.active()
        );

        DocumentType saved = documentTypeRepository.save(documentType);

        return new DocumentTypeResponse(
            saved.id().value(),
            saved.code(),
            saved.name(),
            saved.active(),
            saved.createdAt(),
            saved.updatedAt()
        );
    }
}
