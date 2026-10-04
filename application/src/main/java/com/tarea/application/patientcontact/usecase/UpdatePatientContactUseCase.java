package com.tarea.application.patientcontact.usecase;

import com.tarea.application.patientcontact.command.UpdatePatientContactCommand;
import com.tarea.application.patientcontact.dto.PatientContactResponse;
import com.tarea.application.patientcontact.exception.PatientContactNotFoundApplicationException;
import com.tarea.domain.patientcontact.port.repository.PatientContactRepository;

public class UpdatePatientContactUseCase {

    private final PatientContactRepository patientContactRepository;

    public UpdatePatientContactUseCase(PatientContactRepository patientContactRepository) {
        this.patientContactRepository = patientContactRepository;
    }

    public PatientContactResponse execute(UpdatePatientContactCommand command) {
        var patientContact = patientContactRepository.findById(command.id())
                .orElseThrow(() -> new PatientContactNotFoundApplicationException(command.id().value().toString()));

        patientContact.update(
                command.contactId(),
                command.patientId(),
                command.primaryContact(),
                command.emergencyContact(),
                command.relationshipTypeId()
        );

        var updated = patientContactRepository.save(patientContact);

        return new PatientContactResponse(
            updated.id().value(),
            updated.contactId().value(),
            updated.patientId().value(),
            updated.primaryContact(),
            updated.emergencyContact(),
            updated.relationshipTypeId().value()
        );
    }
}
