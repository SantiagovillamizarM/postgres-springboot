package com.tarea.domain.contact.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.citymunicipality.model.valueobject.CityMunicipalityId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.domain.contact.event.ContactDeletedEvent;
import com.tarea.domain.contact.event.ContactRegisteredEvent;
import com.tarea.domain.contact.event.ContactUpdatedEvent;
import com.tarea.domain.contact.model.valueobject.ContactId;

import java.time.LocalDateTime;
import java.util.Objects;

public class Contact extends AggregateRoot {
    private final ContactId id;
    private String fullName;
    private String email;
    private String notes;
    private CityMunicipalityId cityId;
    private final ProfessionalId createdBy;
    private ProfessionalId updatedBy;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Contact(ContactId id, String fullName, String email, String notes, CityMunicipalityId cityId,
                    ProfessionalId createdBy, ProfessionalId updatedBy, LocalDateTime createdAt,
                    LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "El ID no puede ser nulo");
        this.fullName = fullName;
        this.email = email;
        this.notes = notes;
        this.cityId = Objects.requireNonNull(cityId, "La ciudad no puede ser nula");
        this.createdBy = Objects.requireNonNull(createdBy, "El profesional que crea no puede ser nulo");
        this.updatedBy = updatedBy;
        this.createdAt = Objects.requireNonNull(createdAt, "La fecha de creación no puede ser nula");
        this.updatedAt = updatedAt;
    }

    public static Contact register(String fullName, String email, String notes, CityMunicipalityId cityId,
                                   ProfessionalId createdBy, ProfessionalId updatedBy) {
        ContactId id = ContactId.generate();
        LocalDateTime now = LocalDateTime.now();

        Contact contact = new Contact(id, fullName, email, notes, cityId, createdBy, updatedBy, now, null);
        contact.recordEvent(new ContactRegisteredEvent(id, now));
        return contact;
    }

    public static Contact restore(ContactId id, String fullName, String email, String notes,
                                  CityMunicipalityId cityId, ProfessionalId createdBy,
                                  ProfessionalId updatedBy, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new Contact(id, fullName, email, notes, cityId, createdBy, updatedBy, createdAt, updatedAt);
    }

    public void update(String fullName, String email, String notes, CityMunicipalityId cityId,
                       ProfessionalId updatedBy) {
        this.fullName = fullName;
        this.email = email;
        this.notes = notes;
        this.cityId = Objects.requireNonNull(cityId, "La ciudad no puede ser nula");
        this.updatedBy = updatedBy;
        this.updatedAt = LocalDateTime.now();

        recordEvent(new ContactUpdatedEvent(this.id, this.cityId, this.createdBy, this.updatedAt));
    }

    public void markAsDeleted() {
        recordEvent(new ContactDeletedEvent(this.id, LocalDateTime.now()));
    }

    public ContactId id() { return id; }
    public String fullName() { return fullName; }
    public String email() { return email; }
    public String notes() { return notes; }
    public CityMunicipalityId cityId() { return cityId; }
    public ProfessionalId createdBy() { return createdBy; }
    public ProfessionalId updatedBy() { return updatedBy; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
