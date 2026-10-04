package com.tarea.application.documenttype.usecase;

import com.tarea.application.documenttype.command.UpdateDocumentTypeCommand;
import com.tarea.application.documenttype.dto.DocumentTypeResponse;
import com.tarea.application.documenttype.exception.DocumentTypeNotFoundApplicationException;
import com.tarea.domain.documenttype.port.repository.DocumentTypeRepository;

public class UpdateDocumentTypeUseCase {

    private final DocumentTypeRepository documentTypeRepository;

    public UpdateDocumentTypeUseCase(DocumentTypeRepository documentTypeRepository) {
        this.documentTypeRepository = documentTypeRepository;
    }

    public DocumentTypeResponse execute(UpdateDocumentTypeCommand command) {
        var documentType = documentTypeRepository.findById(command.id())
                .orElseThrow(() -> new DocumentTypeNotFoundApplicationException(command.id().value().toString()));

        documentType.update(
                command.code(),
                command.name(),
                command.active()
        );

        var updated = documentTypeRepository.save(documentType);

        return new DocumentTypeResponse(
            updated.id().value(),
            updated.code(),
            updated.name(),
            updated.active(),
            updated.createdAt(),
            updated.updatedAt()
        );
    }
}
