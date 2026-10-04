package com.tarea.application.documenttype.usecase;

import com.tarea.application.documenttype.dto.DocumentTypeResponse;
import com.tarea.application.documenttype.exception.DocumentTypeNotFoundApplicationException;
import com.tarea.domain.documenttype.model.valueobject.DocumentTypeId;
import com.tarea.domain.documenttype.port.repository.DocumentTypeRepository;

public class GetDocumentTypeByIdUseCase {

    private final DocumentTypeRepository documentTypeRepository;

    public GetDocumentTypeByIdUseCase(DocumentTypeRepository documentTypeRepository) {
        this.documentTypeRepository = documentTypeRepository;
    }

    public DocumentTypeResponse execute(DocumentTypeId id) {
        var documentType = documentTypeRepository.findById(id)
                .orElseThrow(() -> new DocumentTypeNotFoundApplicationException(id.value().toString()));

        return new DocumentTypeResponse(
            documentType.id().value(),
            documentType.code(),
            documentType.name(),
            documentType.active(),
            documentType.createdAt(),
            documentType.updatedAt()
        );
    }
}
