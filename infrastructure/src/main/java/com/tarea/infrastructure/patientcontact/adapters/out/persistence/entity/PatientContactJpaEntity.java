package com.tarea.infrastructure.patientcontact.adapters.out.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "patient_contacts")
public class PatientContactJpaEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "contact_id", nullable = false)
    private UUID contactId;

    @Column(name = "patient_id", nullable = false)
    private UUID patientId;

    @Column(name = "is_primary_contact")
    private Boolean primaryContact;

    @Column(name = "is_emergency_contact")
    private Boolean emergencyContact;

    @Column(name = "relationship_type_id", nullable = false)
    private UUID relationshipTypeId;

    public PatientContactJpaEntity() {
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public UUID getContactId() { return contactId; }
    public void setContactId(UUID contactId) { this.contactId = contactId; }

    public UUID getPatientId() { return patientId; }
    public void setPatientId(UUID patientId) { this.patientId = patientId; }

    public Boolean getPrimaryContact() { return primaryContact; }
    public void setPrimaryContact(Boolean primaryContact) { this.primaryContact = primaryContact; }

    public Boolean getEmergencyContact() { return emergencyContact; }
    public void setEmergencyContact(Boolean emergencyContact) { this.emergencyContact = emergencyContact; }

    public UUID getRelationshipTypeId() { return relationshipTypeId; }
    public void setRelationshipTypeId(UUID relationshipTypeId) { this.relationshipTypeId = relationshipTypeId; }
}
