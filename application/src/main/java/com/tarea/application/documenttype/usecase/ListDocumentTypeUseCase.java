package com.tarea.application.documenttype.usecase;

import com.tarea.application.documenttype.dto.DocumentTypeResponse;
import com.tarea.domain.documenttype.port.repository.DocumentTypeRepository;

import java.util.List;

public class ListDocumentTypeUseCase {

    private final DocumentTypeRepository documentTypeRepository;

    public ListDocumentTypeUseCase(DocumentTypeRepository documentTypeRepository) {
        this.documentTypeRepository = documentTypeRepository;
    }

    public List<DocumentTypeResponse> execute() {
        return documentTypeRepository.findAll().stream()
                .map(documentType -> new DocumentTypeResponse(
                    documentType.id().value(),
                    documentType.code(),
                    documentType.name(),
                    documentType.active(),
                    documentType.createdAt(),
                    documentType.updatedAt()
                ))
                .toList();
    }
}
