package com.tarea.domain.patient.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.citymunicipality.model.valueobject.CityMunicipalityId;
import com.tarea.domain.documenttype.model.valueobject.DocumentTypeId;
import com.tarea.domain.gender.model.valueobject.GenderId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.domain.patient.event.PatientDeletedEvent;
import com.tarea.domain.patient.event.PatientRegisteredEvent;
import com.tarea.domain.patient.event.PatientUpdatedEvent;
import com.tarea.domain.patient.model.valueobject.PatientId;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Patient extends AggregateRoot {
    private final PatientId id;
    private DocumentTypeId documentTypeId;
    private String documentNumber;
    private String firstName;
    private String middleName;
    private String lastName;
    private String secondLastName;
    private LocalDate birthDate;
    private GenderId biologicalSexId;
    private GenderId genderIdentityId;
    private String email;
    private String phone;
    private String address;
    private boolean active;
    private final ProfessionalId createdBy;
    private ProfessionalId updatedBy;
    private CityMunicipalityId cityId;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Patient(PatientId id, DocumentTypeId documentTypeId, String documentNumber, String firstName,
                    String middleName, String lastName, String secondLastName, LocalDate birthDate,
                    GenderId biologicalSexId, GenderId genderIdentityId, String email, String phone,
                    String address, boolean active, ProfessionalId createdBy, ProfessionalId updatedBy,
                    CityMunicipalityId cityId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "El ID no puede ser nulo");
        this.documentTypeId = Objects.requireNonNull(documentTypeId, "El tipo de documento no puede ser nulo");
        this.documentNumber = documentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.secondLastName = secondLastName;
        this.birthDate = birthDate;
        this.biologicalSexId = Objects.requireNonNull(biologicalSexId, "El sexo biológico no puede ser nulo");
        this.genderIdentityId = Objects.requireNonNull(genderIdentityId, "La identidad de género no puede ser nula");
        this.email = Objects.requireNonNull(email, "El correo no puede ser nulo");
        this.phone = phone;
        this.address = address;
        this.active = active;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.cityId = Objects.requireNonNull(cityId, "La ciudad no puede ser nula");
        this.createdAt = Objects.requireNonNull(createdAt, "La fecha de creación no puede ser nula");
        this.updatedAt = updatedAt;
    }

    public static Patient register(DocumentTypeId documentTypeId, String documentNumber, String firstName,
                                   String middleName, String lastName, String secondLastName,
                                   LocalDate birthDate, GenderId biologicalSexId, GenderId genderIdentityId,
                                   String email, String phone, String address, Boolean active,
                                   ProfessionalId createdBy, ProfessionalId updatedBy,
                                   CityMunicipalityId cityId) {
        PatientId id = PatientId.generate();
        LocalDateTime now = LocalDateTime.now();
        boolean activeValue = active != null ? active : true;

        Patient patient = new Patient(id, documentTypeId, documentNumber, firstName, middleName, lastName,
                                      secondLastName, birthDate, biologicalSexId, genderIdentityId, email,
                                      phone, address, activeValue, createdBy, updatedBy, cityId, now, null);
        patient.recordEvent(new PatientRegisteredEvent(id, now));
        return patient;
    }

    public static Patient restore(PatientId id, DocumentTypeId documentTypeId, String documentNumber,
                                  String firstName, String middleName, String lastName, String secondLastName,
                                  LocalDate birthDate, GenderId biologicalSexId, GenderId genderIdentityId,
                                  String email, String phone, String address, boolean active,
                                  ProfessionalId createdBy, ProfessionalId updatedBy,
                                  CityMunicipalityId cityId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new Patient(id, documentTypeId, documentNumber, firstName, middleName, lastName,
                           secondLastName, birthDate, biologicalSexId, genderIdentityId, email, phone,
                           address, active, createdBy, updatedBy, cityId, createdAt, updatedAt);
    }

    public void update(DocumentTypeId documentTypeId, String documentNumber, String firstName,
                       String middleName, String lastName, String secondLastName, LocalDate birthDate,
                       GenderId biologicalSexId, GenderId genderIdentityId, String email, String phone,
                       String address, Boolean active, ProfessionalId updatedBy, CityMunicipalityId cityId) {
        this.documentTypeId = Objects.requireNonNull(documentTypeId, "El tipo de documento no puede ser nulo");
        this.documentNumber = documentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.secondLastName = secondLastName;
        this.birthDate = birthDate;
        this.biologicalSexId = Objects.requireNonNull(biologicalSexId, "El sexo biológico no puede ser nulo");
        this.genderIdentityId = Objects.requireNonNull(genderIdentityId, "La identidad de género no puede ser nula");
        this.email = Objects.requireNonNull(email, "El correo no puede ser nulo");
        this.phone = phone;
        this.address = address;
        if (active != null) {
            this.active = active;
        }
        this.updatedBy = updatedBy;
        this.cityId = Objects.requireNonNull(cityId, "La ciudad no puede ser nula");
        this.updatedAt = LocalDateTime.now();

        recordEvent(new PatientUpdatedEvent(this.id, this.documentTypeId, this.biologicalSexId,
                                            this.genderIdentityId, this.email, this.cityId, this.updatedAt));
    }

    public void markAsDeleted() {
        recordEvent(new PatientDeletedEvent(this.id, LocalDateTime.now()));
    }

    public PatientId id() { return id; }
    public DocumentTypeId documentTypeId() { return documentTypeId; }
    public String documentNumber() { return documentNumber; }
    public String firstName() { return firstName; }
    public String middleName() { return middleName; }
    public String lastName() { return lastName; }
    public String secondLastName() { return secondLastName; }
    public LocalDate birthDate() { return birthDate; }
    public GenderId biologicalSexId() { return biologicalSexId; }
    public GenderId genderIdentityId() { return genderIdentityId; }
    public String email() { return email; }
    public String phone() { return phone; }
    public String address() { return address; }
    public boolean active() { return active; }
    public ProfessionalId createdBy() { return createdBy; }
    public ProfessionalId updatedBy() { return updatedBy; }
    public CityMunicipalityId cityId() { return cityId; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
