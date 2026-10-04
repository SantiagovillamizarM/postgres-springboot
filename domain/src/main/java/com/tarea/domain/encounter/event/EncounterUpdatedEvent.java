package com.tarea.domain.encounter.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.clinicalrecord.model.valueobject.ClinicalRecordId;
import com.tarea.domain.encountermodality.model.valueobject.EncounterModalityId;
import com.tarea.domain.encounterstatus.model.valueobject.EncounterStatusId;
import com.tarea.domain.encountertype.model.valueobject.EncounterTypeId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.domain.encounter.model.valueobject.EncounterId;

import java.time.LocalDateTime;
import java.util.Objects;

public record EncounterUpdatedEvent(
        EncounterId id,
        ClinicalRecordId clinicalRecordId,
        ProfessionalId professionalId,
        EncounterTypeId encounterTypeId,
        EncounterModalityId modalityId,
        EncounterStatusId statusId,
        LocalDateTime occurredOn
) implements DomainEvent {
    public EncounterUpdatedEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(clinicalRecordId, "La historia clínica no puede ser nula");
        Objects.requireNonNull(professionalId, "El profesional no puede ser nulo");
        Objects.requireNonNull(encounterTypeId, "El tipo de encuentro no puede ser nulo");
        Objects.requireNonNull(modalityId, "La modalidad no puede ser nula");
        Objects.requireNonNull(statusId, "El estado no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
