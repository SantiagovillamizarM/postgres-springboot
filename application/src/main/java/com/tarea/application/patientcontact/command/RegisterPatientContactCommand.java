package com.tarea.application.patientcontact.command;

import com.tarea.domain.contact.model.valueobject.ContactId;
import com.tarea.domain.patient.model.valueobject.PatientId;
import com.tarea.domain.relationshiptype.model.valueobject.RelationshipTypeId;

public record RegisterPatientContactCommand(
        ContactId contactId,
        PatientId patientId,
        Boolean primaryContact,
        Boolean emergencyContact,
        RelationshipTypeId relationshipTypeId
) {
}
