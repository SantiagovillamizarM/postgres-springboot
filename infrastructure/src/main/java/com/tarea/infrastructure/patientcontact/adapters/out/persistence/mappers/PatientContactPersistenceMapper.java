package com.tarea.infrastructure.patientcontact.adapters.out.persistence.mappers;

import com.tarea.domain.contact.model.valueobject.ContactId;
import com.tarea.domain.patient.model.valueobject.PatientId;
import com.tarea.domain.relationshiptype.model.valueobject.RelationshipTypeId;
import com.tarea.domain.patientcontact.model.aggregate.PatientContact;
import com.tarea.domain.patientcontact.model.valueobject.PatientContactId;
import com.tarea.infrastructure.patientcontact.adapters.out.persistence.entity.PatientContactJpaEntity;

public class PatientContactPersistenceMapper {

    public PatientContactJpaEntity toJpa(PatientContact domain) {
        if (domain == null) {
            return null;
        }

        PatientContactJpaEntity jpa = new PatientContactJpaEntity();
        jpa.setId(domain.id().value());
        jpa.setContactId(domain.contactId().value());
        jpa.setPatientId(domain.patientId().value());
        jpa.setPrimaryContact(domain.primaryContact());
        jpa.setEmergencyContact(domain.emergencyContact());
        jpa.setRelationshipTypeId(domain.relationshipTypeId().value());
        return jpa;
    }

    public PatientContact toDomain(PatientContactJpaEntity jpa) {
        if (jpa == null) {
            return null;
        }

        return PatientContact.restore(
                new PatientContactId(jpa.getId()),
                new ContactId(jpa.getContactId()),
                new PatientId(jpa.getPatientId()),
                jpa.getPrimaryContact() != null ? jpa.getPrimaryContact() : false,
                jpa.getEmergencyContact() != null ? jpa.getEmergencyContact() : false,
                new RelationshipTypeId(jpa.getRelationshipTypeId())
        );
    }
}
