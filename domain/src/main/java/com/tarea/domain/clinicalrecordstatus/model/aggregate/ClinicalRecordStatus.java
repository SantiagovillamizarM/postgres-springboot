package com.tarea.domain.clinicalrecordstatus.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.clinicalrecordstatus.event.ClinicalRecordStatusDeletedEvent;
import com.tarea.domain.clinicalrecordstatus.event.ClinicalRecordStatusRegisteredEvent;
import com.tarea.domain.clinicalrecordstatus.event.ClinicalRecordStatusUpdatedEvent;
import com.tarea.domain.clinicalrecordstatus.model.valueobject.ClinicalRecordStatusId;

import java.time.LocalDateTime;
import java.util.Objects;

public class ClinicalRecordStatus extends AggregateRoot {
    private final ClinicalRecordStatusId id;
    private String code;
    private String name;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private ClinicalRecordStatus(ClinicalRecordStatusId id, String code, String name, LocalDateTime createdAt,
                                 LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "El ID no puede ser nulo");
        this.code = Objects.requireNonNull(code, "El código no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.createdAt = Objects.requireNonNull(createdAt, "La fecha de creación no puede ser nula");
        this.updatedAt = updatedAt;
    }

    public static ClinicalRecordStatus register(String code, String name) {
        ClinicalRecordStatusId id = ClinicalRecordStatusId.generate();
        LocalDateTime now = LocalDateTime.now();

        ClinicalRecordStatus clinicalRecordStatus = new ClinicalRecordStatus(id, code, name, now, null);
        clinicalRecordStatus.recordEvent(new ClinicalRecordStatusRegisteredEvent(id, now));
        return clinicalRecordStatus;
    }

    public static ClinicalRecordStatus restore(ClinicalRecordStatusId id, String code, String name,
                                               LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new ClinicalRecordStatus(id, code, name, createdAt, updatedAt);
    }

    public void update(String code, String name) {
        this.code = Objects.requireNonNull(code, "El código no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.updatedAt = LocalDateTime.now();

        recordEvent(new ClinicalRecordStatusUpdatedEvent(this.id, this.code, this.name, this.updatedAt));
    }

    public void markAsDeleted() {
        recordEvent(new ClinicalRecordStatusDeletedEvent(this.id, LocalDateTime.now()));
    }

    public ClinicalRecordStatusId id() { return id; }
    public String code() { return code; }
    public String name() { return name; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
