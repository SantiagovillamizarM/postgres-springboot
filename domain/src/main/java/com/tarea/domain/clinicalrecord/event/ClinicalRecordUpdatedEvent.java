package com.tarea.domain.clinicalrecord.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.clinicalrecordstatus.model.valueobject.ClinicalRecordStatusId;
import com.tarea.domain.patient.model.valueobject.PatientId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.domain.clinicalrecord.model.valueobject.ClinicalRecordId;

import java.time.LocalDateTime;
import java.util.Objects;

public record ClinicalRecordUpdatedEvent(
        ClinicalRecordId id,
        PatientId patientId,
        ClinicalRecordStatusId statusId,
        ProfessionalId createdBy,
        LocalDateTime occurredOn
) implements DomainEvent {
    public ClinicalRecordUpdatedEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(patientId, "El paciente no puede ser nulo");
        Objects.requireNonNull(statusId, "El estado no puede ser nulo");
        Objects.requireNonNull(createdBy, "El profesional que crea no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
