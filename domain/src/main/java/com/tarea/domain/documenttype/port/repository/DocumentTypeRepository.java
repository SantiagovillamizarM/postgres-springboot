package com.tarea.domain.documenttype.port.repository;

import com.tarea.domain.documenttype.model.aggregate.DocumentType;
import com.tarea.domain.documenttype.model.valueobject.DocumentTypeId;

import java.util.List;
import java.util.Optional;

public interface DocumentTypeRepository {
    DocumentType save(DocumentType documentType);
    Optional<DocumentType> findById(DocumentTypeId id);
    List<DocumentType> findAll();
    boolean existsByCode(String code);
    void delete(DocumentType documentType);
}
