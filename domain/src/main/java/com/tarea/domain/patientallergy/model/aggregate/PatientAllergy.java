package com.tarea.domain.patientallergy.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.patient.model.valueobject.PatientId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.domain.patientallergy.event.PatientAllergyDeletedEvent;
import com.tarea.domain.patientallergy.event.PatientAllergyRegisteredEvent;
import com.tarea.domain.patientallergy.event.PatientAllergyUpdatedEvent;
import com.tarea.domain.patientallergy.model.valueobject.PatientAllergyId;

import java.time.LocalDateTime;
import java.util.Objects;

public class PatientAllergy extends AggregateRoot {
    private final PatientAllergyId id;
    private PatientId patientId;
    private String substance;
    private String reaction;
    private String severity;
    private boolean active;
    private LocalDateTime recordedAt;
    private ProfessionalId recordedBy;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private PatientAllergy(PatientAllergyId id, PatientId patientId, String substance, String reaction,
                           String severity, boolean active, LocalDateTime recordedAt,
                           ProfessionalId recordedBy, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "El ID no puede ser nulo");
        this.patientId = Objects.requireNonNull(patientId, "El paciente no puede ser nulo");
        this.substance = substance;
        this.reaction = reaction;
        this.severity = severity;
        this.active = active;
        this.recordedAt = recordedAt;
        this.recordedBy = recordedBy;
        this.createdAt = Objects.requireNonNull(createdAt, "La fecha de creación no puede ser nula");
        this.updatedAt = updatedAt;
    }

    public static PatientAllergy register(PatientId patientId, String substance, String reaction,
                                          String severity, Boolean active, LocalDateTime recordedAt,
                                          ProfessionalId recordedBy) {
        PatientAllergyId id = PatientAllergyId.generate();
        LocalDateTime now = LocalDateTime.now();
        boolean activeValue = active != null ? active : true;

        PatientAllergy patientAllergy = new PatientAllergy(id, patientId, substance, reaction, severity,
                                                           activeValue, recordedAt, recordedBy, now, null);
        patientAllergy.recordEvent(new PatientAllergyRegisteredEvent(id, now));
        return patientAllergy;
    }

    public static PatientAllergy restore(PatientAllergyId id, PatientId patientId, String substance,
                                         String reaction, String severity, boolean active,
                                         LocalDateTime recordedAt, ProfessionalId recordedBy,
                                         LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new PatientAllergy(id, patientId, substance, reaction, severity, active, recordedAt,
                                  recordedBy, createdAt, updatedAt);
    }

    public void update(PatientId patientId, String substance, String reaction, String severity,
                       Boolean active, LocalDateTime recordedAt, ProfessionalId recordedBy) {
        this.patientId = Objects.requireNonNull(patientId, "El paciente no puede ser nulo");
        this.substance = substance;
        this.reaction = reaction;
        this.severity = severity;
        if (active != null) {
            this.active = active;
        }
        this.recordedAt = recordedAt;
        this.recordedBy = recordedBy;
        this.updatedAt = LocalDateTime.now();

        recordEvent(new PatientAllergyUpdatedEvent(this.id, this.patientId, this.updatedAt));
    }

    public void markAsDeleted() {
        recordEvent(new PatientAllergyDeletedEvent(this.id, LocalDateTime.now()));
    }

    public PatientAllergyId id() { return id; }
    public PatientId patientId() { return patientId; }
    public String substance() { return substance; }
    public String reaction() { return reaction; }
    public String severity() { return severity; }
    public boolean active() { return active; }
    public LocalDateTime recordedAt() { return recordedAt; }
    public ProfessionalId recordedBy() { return recordedBy; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
