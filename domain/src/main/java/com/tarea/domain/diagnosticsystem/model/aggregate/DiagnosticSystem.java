package com.tarea.domain.diagnosticsystem.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.diagnosticsystem.event.DiagnosticSystemDeletedEvent;
import com.tarea.domain.diagnosticsystem.event.DiagnosticSystemRegisteredEvent;
import com.tarea.domain.diagnosticsystem.event.DiagnosticSystemUpdatedEvent;
import com.tarea.domain.diagnosticsystem.model.valueobject.DiagnosticSystemId;

import java.time.LocalDateTime;
import java.util.Objects;

public class DiagnosticSystem extends AggregateRoot {
    private final DiagnosticSystemId id;
    private String code;
    private String name;
    private boolean active;
    private String version;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private DiagnosticSystem(DiagnosticSystemId id, String code, String name, boolean active, String version,
                             LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "El ID no puede ser nulo");
        this.code = Objects.requireNonNull(code, "El código no puede ser nulo");
        this.name = name;
        this.active = active;
        this.version = version;
        this.createdAt = Objects.requireNonNull(createdAt, "La fecha de creación no puede ser nula");
        this.updatedAt = updatedAt;
    }

    public static DiagnosticSystem register(String code, String name, Boolean active, String version) {
        DiagnosticSystemId id = DiagnosticSystemId.generate();
        LocalDateTime now = LocalDateTime.now();
        boolean activeValue = active != null ? active : true;

        DiagnosticSystem diagnosticSystem = new DiagnosticSystem(id, code, name, activeValue, version, now, null);
        diagnosticSystem.recordEvent(new DiagnosticSystemRegisteredEvent(id, now));
        return diagnosticSystem;
    }

    public static DiagnosticSystem restore(DiagnosticSystemId id, String code, String name, boolean active,
                                           String version, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new DiagnosticSystem(id, code, name, active, version, createdAt, updatedAt);
    }

    public void update(String code, String name, Boolean active, String version) {
        this.code = Objects.requireNonNull(code, "El código no puede ser nulo");
        this.name = name;
        if (active != null) {
            this.active = active;
        }
        this.version = version;
        this.updatedAt = LocalDateTime.now();

        recordEvent(new DiagnosticSystemUpdatedEvent(this.id, this.code, this.updatedAt));
    }

    public void markAsDeleted() {
        recordEvent(new DiagnosticSystemDeletedEvent(this.id, LocalDateTime.now()));
    }

    public DiagnosticSystemId id() { return id; }
    public String code() { return code; }
    public String name() { return name; }
    public boolean active() { return active; }
    public String version() { return version; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
