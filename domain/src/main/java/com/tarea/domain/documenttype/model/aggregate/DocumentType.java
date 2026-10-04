package com.tarea.domain.documenttype.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.documenttype.event.DocumentTypeDeletedEvent;
import com.tarea.domain.documenttype.event.DocumentTypeRegisteredEvent;
import com.tarea.domain.documenttype.event.DocumentTypeUpdatedEvent;
import com.tarea.domain.documenttype.model.valueobject.DocumentTypeId;

import java.time.LocalDateTime;
import java.util.Objects;

public class DocumentType extends AggregateRoot {
    private final DocumentTypeId id;
    private String code;
    private String name;
    private boolean active;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private DocumentType(DocumentTypeId id, String code, String name, boolean active, LocalDateTime createdAt,
                         LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "El ID no puede ser nulo");
        this.code = Objects.requireNonNull(code, "El código no puede ser nulo");
        this.name = name;
        this.active = active;
        this.createdAt = Objects.requireNonNull(createdAt, "La fecha de creación no puede ser nula");
        this.updatedAt = updatedAt;
    }

    public static DocumentType register(String code, String name, Boolean active) {
        DocumentTypeId id = DocumentTypeId.generate();
        LocalDateTime now = LocalDateTime.now();
        boolean activeValue = active != null ? active : true;

        DocumentType documentType = new DocumentType(id, code, name, activeValue, now, null);
        documentType.recordEvent(new DocumentTypeRegisteredEvent(id, now));
        return documentType;
    }

    public static DocumentType restore(DocumentTypeId id, String code, String name, boolean active,
                                       LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new DocumentType(id, code, name, active, createdAt, updatedAt);
    }

    public void update(String code, String name, Boolean active) {
        this.code = Objects.requireNonNull(code, "El código no puede ser nulo");
        this.name = name;
        if (active != null) {
            this.active = active;
        }
        this.updatedAt = LocalDateTime.now();

        recordEvent(new DocumentTypeUpdatedEvent(this.id, this.code, this.updatedAt));
    }

    public void markAsDeleted() {
        recordEvent(new DocumentTypeDeletedEvent(this.id, LocalDateTime.now()));
    }

    public DocumentTypeId id() { return id; }
    public String code() { return code; }
    public String name() { return name; }
    public boolean active() { return active; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
