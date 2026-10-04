package com.tarea.domain.clinicalrecord.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.clinicalrecordstatus.model.valueobject.ClinicalRecordStatusId;
import com.tarea.domain.patient.model.valueobject.PatientId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.domain.clinicalrecord.event.ClinicalRecordDeletedEvent;
import com.tarea.domain.clinicalrecord.event.ClinicalRecordRegisteredEvent;
import com.tarea.domain.clinicalrecord.event.ClinicalRecordUpdatedEvent;
import com.tarea.domain.clinicalrecord.model.valueobject.ClinicalRecordId;

import java.time.LocalDateTime;
import java.util.Objects;

public class ClinicalRecord extends AggregateRoot {
    private final ClinicalRecordId id;
    private PatientId patientId;
    private LocalDateTime creationDate;
    private String recordNumber;
    private LocalDateTime openedAt;
    private LocalDateTime closedAt;
    private ClinicalRecordStatusId statusId;
    private final ProfessionalId createdBy;
    private final LocalDateTime createdAt;

    private ClinicalRecord(ClinicalRecordId id, PatientId patientId, LocalDateTime creationDate,
                           String recordNumber, LocalDateTime openedAt, LocalDateTime closedAt,
                           ClinicalRecordStatusId statusId, ProfessionalId createdBy, LocalDateTime createdAt) {
        this.id = Objects.requireNonNull(id, "El ID no puede ser nulo");
        this.patientId = Objects.requireNonNull(patientId, "El paciente no puede ser nulo");
        this.creationDate = creationDate;
        this.recordNumber = recordNumber;
        this.openedAt = openedAt;
        this.closedAt = closedAt;
        this.statusId = Objects.requireNonNull(statusId, "El estado no puede ser nulo");
        this.createdBy = Objects.requireNonNull(createdBy, "El profesional que crea no puede ser nulo");
        this.createdAt = Objects.requireNonNull(createdAt, "La fecha de creación no puede ser nula");
    }

    public static ClinicalRecord register(PatientId patientId, LocalDateTime creationDate,
                                          String recordNumber, LocalDateTime openedAt, LocalDateTime closedAt,
                                          ClinicalRecordStatusId statusId, ProfessionalId createdBy) {
        ClinicalRecordId id = ClinicalRecordId.generate();
        LocalDateTime now = LocalDateTime.now();

        ClinicalRecord clinicalRecord = new ClinicalRecord(id, patientId, creationDate, recordNumber,
                                                           openedAt, closedAt, statusId, createdBy, now);
        clinicalRecord.recordEvent(new ClinicalRecordRegisteredEvent(id, now));
        return clinicalRecord;
    }

    public static ClinicalRecord restore(ClinicalRecordId id, PatientId patientId, LocalDateTime creationDate,
                                         String recordNumber, LocalDateTime openedAt, LocalDateTime closedAt,
                                         ClinicalRecordStatusId statusId, ProfessionalId createdBy,
                                         LocalDateTime createdAt) {
        return new ClinicalRecord(id, patientId, creationDate, recordNumber, openedAt, closedAt, statusId,
                                  createdBy, createdAt);
    }

    public void update(PatientId patientId, LocalDateTime creationDate, String recordNumber,
                       LocalDateTime openedAt, LocalDateTime closedAt, ClinicalRecordStatusId statusId) {
        this.patientId = Objects.requireNonNull(patientId, "El paciente no puede ser nulo");
        this.creationDate = creationDate;
        this.recordNumber = recordNumber;
        this.openedAt = openedAt;
        this.closedAt = closedAt;
        this.statusId = Objects.requireNonNull(statusId, "El estado no puede ser nulo");

        recordEvent(new ClinicalRecordUpdatedEvent(this.id, this.patientId, this.statusId, this.createdBy,
                                                   LocalDateTime.now()));
    }

    public void markAsDeleted() {
        recordEvent(new ClinicalRecordDeletedEvent(this.id, LocalDateTime.now()));
    }

    public ClinicalRecordId id() { return id; }
    public PatientId patientId() { return patientId; }
    public LocalDateTime creationDate() { return creationDate; }
    public String recordNumber() { return recordNumber; }
    public LocalDateTime openedAt() { return openedAt; }
    public LocalDateTime closedAt() { return closedAt; }
    public ClinicalRecordStatusId statusId() { return statusId; }
    public ProfessionalId createdBy() { return createdBy; }
    public LocalDateTime createdAt() { return createdAt; }
}
