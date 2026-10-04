package com.tarea.domain.patient.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.citymunicipality.model.valueobject.CityMunicipalityId;
import com.tarea.domain.documenttype.model.valueobject.DocumentTypeId;
import com.tarea.domain.gender.model.valueobject.GenderId;
import com.tarea.domain.patient.model.valueobject.PatientId;

import java.time.LocalDateTime;
import java.util.Objects;

public record PatientUpdatedEvent(
        PatientId id,
        DocumentTypeId documentTypeId,
        GenderId biologicalSexId,
        GenderId genderIdentityId,
        String email,
        CityMunicipalityId cityId,
        LocalDateTime occurredOn
) implements DomainEvent {
    public PatientUpdatedEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(documentTypeId, "El tipo de documento no puede ser nulo");
        Objects.requireNonNull(biologicalSexId, "El sexo biológico no puede ser nulo");
        Objects.requireNonNull(genderIdentityId, "La identidad de género no puede ser nula");
        Objects.requireNonNull(email, "El correo no puede ser nulo");
        Objects.requireNonNull(cityId, "La ciudad no puede ser nula");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
