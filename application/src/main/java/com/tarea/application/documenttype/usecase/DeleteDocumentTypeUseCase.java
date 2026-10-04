package com.tarea.application.documenttype.usecase;

import com.tarea.application.documenttype.exception.DocumentTypeNotFoundApplicationException;
import com.tarea.domain.documenttype.model.valueobject.DocumentTypeId;
import com.tarea.domain.documenttype.port.repository.DocumentTypeRepository;

public class DeleteDocumentTypeUseCase {

    private final DocumentTypeRepository documentTypeRepository;

    public DeleteDocumentTypeUseCase(DocumentTypeRepository documentTypeRepository) {
        this.documentTypeRepository = documentTypeRepository;
    }

    public void execute(DocumentTypeId id) {
        var documentType = documentTypeRepository.findById(id)
                .orElseThrow(() -> new DocumentTypeNotFoundApplicationException(id.value().toString()));

        documentType.markAsDeleted();
        documentTypeRepository.delete(documentType);
    }
}
