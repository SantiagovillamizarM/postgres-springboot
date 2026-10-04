package com.tarea.domain.patientcontact.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.contact.model.valueobject.ContactId;
import com.tarea.domain.patient.model.valueobject.PatientId;
import com.tarea.domain.relationshiptype.model.valueobject.RelationshipTypeId;
import com.tarea.domain.patientcontact.event.PatientContactDeletedEvent;
import com.tarea.domain.patientcontact.event.PatientContactRegisteredEvent;
import com.tarea.domain.patientcontact.event.PatientContactUpdatedEvent;
import com.tarea.domain.patientcontact.model.valueobject.PatientContactId;

import java.time.LocalDateTime;
import java.util.Objects;

public class PatientContact extends AggregateRoot {
    private final PatientContactId id;
    private ContactId contactId;
    private PatientId patientId;
    private boolean primaryContact;
    private boolean emergencyContact;
    private RelationshipTypeId relationshipTypeId;

    private PatientContact(PatientContactId id, ContactId contactId, PatientId patientId,
                           boolean primaryContact, boolean emergencyContact,
                           RelationshipTypeId relationshipTypeId) {
        this.id = Objects.requireNonNull(id, "El ID no puede ser nulo");
        this.contactId = Objects.requireNonNull(contactId, "El contacto no puede ser nulo");
        this.patientId = Objects.requireNonNull(patientId, "El paciente no puede ser nulo");
        this.primaryContact = primaryContact;
        this.emergencyContact = emergencyContact;
        this.relationshipTypeId = Objects.requireNonNull(relationshipTypeId, "El tipo de relación no puede ser nulo");
    }

    public static PatientContact register(ContactId contactId, PatientId patientId, Boolean primaryContact,
                                          Boolean emergencyContact, RelationshipTypeId relationshipTypeId) {
        PatientContactId id = PatientContactId.generate();
        LocalDateTime now = LocalDateTime.now();
        boolean primaryContactValue = primaryContact != null ? primaryContact : false;
        boolean emergencyContactValue = emergencyContact != null ? emergencyContact : false;

        PatientContact patientContact = new PatientContact(id, contactId, patientId, primaryContactValue,
                                                           emergencyContactValue, relationshipTypeId);
        patientContact.recordEvent(new PatientContactRegisteredEvent(id, now));
        return patientContact;
    }

    public static PatientContact restore(PatientContactId id, ContactId contactId, PatientId patientId,
                                         boolean primaryContact, boolean emergencyContact,
                                         RelationshipTypeId relationshipTypeId) {
        return new PatientContact(id, contactId, patientId, primaryContact, emergencyContact,
                                  relationshipTypeId);
    }

    public void update(ContactId contactId, PatientId patientId, Boolean primaryContact,
                       Boolean emergencyContact, RelationshipTypeId relationshipTypeId) {
        this.contactId = Objects.requireNonNull(contactId, "El contacto no puede ser nulo");
        this.patientId = Objects.requireNonNull(patientId, "El paciente no puede ser nulo");
        if (primaryContact != null) {
            this.primaryContact = primaryContact;
        }
        if (emergencyContact != null) {
            this.emergencyContact = emergencyContact;
        }
        this.relationshipTypeId = Objects.requireNonNull(relationshipTypeId, "El tipo de relación no puede ser nulo");

        recordEvent(new PatientContactUpdatedEvent(this.id, this.contactId, this.patientId,
                                                   this.relationshipTypeId, LocalDateTime.now()));
    }

    public void markAsDeleted() {
        recordEvent(new PatientContactDeletedEvent(this.id, LocalDateTime.now()));
    }

    public PatientContactId id() { return id; }
    public ContactId contactId() { return contactId; }
    public PatientId patientId() { return patientId; }
    public boolean primaryContact() { return primaryContact; }
    public boolean emergencyContact() { return emergencyContact; }
    public RelationshipTypeId relationshipTypeId() { return relationshipTypeId; }
}
