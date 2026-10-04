package com.tarea.application.patientcontact.usecase;

import com.tarea.application.patientcontact.dto.PatientContactResponse;
import com.tarea.application.patientcontact.exception.PatientContactNotFoundApplicationException;
import com.tarea.domain.patientcontact.model.valueobject.PatientContactId;
import com.tarea.domain.patientcontact.port.repository.PatientContactRepository;

public class GetPatientContactByIdUseCase {

    private final PatientContactRepository patientContactRepository;

    public GetPatientContactByIdUseCase(PatientContactRepository patientContactRepository) {
        this.patientContactRepository = patientContactRepository;
    }

    public PatientContactResponse execute(PatientContactId id) {
        var patientContact = patientContactRepository.findById(id)
                .orElseThrow(() -> new PatientContactNotFoundApplicationException(id.value().toString()));

        return new PatientContactResponse(
            patientContact.id().value(),
            patientContact.contactId().value(),
            patientContact.patientId().value(),
            patientContact.primaryContact(),
            patientContact.emergencyContact(),
            patientContact.relationshipTypeId().value()
        );
    }
}
