package com.tarea.domain.professional.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.citymunicipality.model.valueobject.CityMunicipalityId;
import com.tarea.domain.documenttype.model.valueobject.DocumentTypeId;
import com.tarea.domain.professionaltype.model.valueobject.ProfessionalTypeId;
import com.tarea.domain.professional.event.ProfessionalDeletedEvent;
import com.tarea.domain.professional.event.ProfessionalRegisteredEvent;
import com.tarea.domain.professional.event.ProfessionalUpdatedEvent;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;

import java.time.LocalDateTime;
import java.util.Objects;

public class Professional extends AggregateRoot {
    private final ProfessionalId id;
    private DocumentTypeId documentTypeId;
    private String documentNumber;
    private String firstName;
    private String lastName;
    private ProfessionalTypeId professionalTypeId;
    private String licenseNumber;
    private boolean active;
    private CityMunicipalityId cityId;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Professional(ProfessionalId id, DocumentTypeId documentTypeId, String documentNumber,
                         String firstName, String lastName, ProfessionalTypeId professionalTypeId,
                         String licenseNumber, boolean active, CityMunicipalityId cityId,
                         LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "El ID no puede ser nulo");
        this.documentTypeId = Objects.requireNonNull(documentTypeId, "El tipo de documento no puede ser nulo");
        this.documentNumber = Objects.requireNonNull(documentNumber, "El número de documento no puede ser nulo");
        this.firstName = firstName;
        this.lastName = lastName;
        this.professionalTypeId = Objects.requireNonNull(professionalTypeId, "El tipo de profesional no puede ser nulo");
        this.licenseNumber = Objects.requireNonNull(licenseNumber, "El número de licencia no puede ser nulo");
        this.active = active;
        this.cityId = Objects.requireNonNull(cityId, "La ciudad no puede ser nula");
        this.createdAt = Objects.requireNonNull(createdAt, "La fecha de creación no puede ser nula");
        this.updatedAt = updatedAt;
    }

    public static Professional register(DocumentTypeId documentTypeId, String documentNumber,
                                        String firstName, String lastName,
                                        ProfessionalTypeId professionalTypeId, String licenseNumber,
                                        Boolean active, CityMunicipalityId cityId) {
        ProfessionalId id = ProfessionalId.generate();
        LocalDateTime now = LocalDateTime.now();
        boolean activeValue = active != null ? active : true;

        Professional professional = new Professional(id, documentTypeId, documentNumber, firstName, lastName,
                                                     professionalTypeId, licenseNumber, activeValue, cityId,
                                                     now, null);
        professional.recordEvent(new ProfessionalRegisteredEvent(id, now));
        return professional;
    }

    public static Professional restore(ProfessionalId id, DocumentTypeId documentTypeId,
                                       String documentNumber, String firstName, String lastName,
                                       ProfessionalTypeId professionalTypeId, String licenseNumber,
                                       boolean active, CityMunicipalityId cityId, LocalDateTime createdAt,
                                       LocalDateTime updatedAt) {
        return new Professional(id, documentTypeId, documentNumber, firstName, lastName, professionalTypeId,
                                licenseNumber, active, cityId, createdAt, updatedAt);
    }

    public void update(DocumentTypeId documentTypeId, String documentNumber, String firstName,
                       String lastName, ProfessionalTypeId professionalTypeId, String licenseNumber,
                       Boolean active, CityMunicipalityId cityId) {
        this.documentTypeId = Objects.requireNonNull(documentTypeId, "El tipo de documento no puede ser nulo");
        this.documentNumber = Objects.requireNonNull(documentNumber, "El número de documento no puede ser nulo");
        this.firstName = firstName;
        this.lastName = lastName;
        this.professionalTypeId = Objects.requireNonNull(professionalTypeId, "El tipo de profesional no puede ser nulo");
        this.licenseNumber = Objects.requireNonNull(licenseNumber, "El número de licencia no puede ser nulo");
        if (active != null) {
            this.active = active;
        }
        this.cityId = Objects.requireNonNull(cityId, "La ciudad no puede ser nula");
        this.updatedAt = LocalDateTime.now();

        recordEvent(new ProfessionalUpdatedEvent(this.id, this.documentTypeId, this.documentNumber,
                                                 this.professionalTypeId, this.licenseNumber, this.cityId,
                                                 this.updatedAt));
    }

    public void markAsDeleted() {
        recordEvent(new ProfessionalDeletedEvent(this.id, LocalDateTime.now()));
    }

    public ProfessionalId id() { return id; }
    public DocumentTypeId documentTypeId() { return documentTypeId; }
    public String documentNumber() { return documentNumber; }
    public String firstName() { return firstName; }
    public String lastName() { return lastName; }
    public ProfessionalTypeId professionalTypeId() { return professionalTypeId; }
    public String licenseNumber() { return licenseNumber; }
    public boolean active() { return active; }
    public CityMunicipalityId cityId() { return cityId; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
