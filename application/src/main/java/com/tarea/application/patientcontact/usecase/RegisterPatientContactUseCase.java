package com.tarea.application.patientcontact.usecase;

import com.tarea.application.patientcontact.command.RegisterPatientContactCommand;
import com.tarea.application.patientcontact.dto.PatientContactResponse;
import com.tarea.domain.patientcontact.model.aggregate.PatientContact;
import com.tarea.domain.patientcontact.port.repository.PatientContactRepository;

public class RegisterPatientContactUseCase {

    private final PatientContactRepository patientContactRepository;

    public RegisterPatientContactUseCase(PatientContactRepository patientContactRepository) {
        this.patientContactRepository = patientContactRepository;
    }

    public PatientContactResponse execute(RegisterPatientContactCommand command) {
        PatientContact patientContact = PatientContact.register(
                command.contactId(),
                command.patientId(),
                command.primaryContact(),
                command.emergencyContact(),
                command.relationshipTypeId()
        );

        PatientContact saved = patientContactRepository.save(patientContact);

        return new PatientContactResponse(
            saved.id().value(),
            saved.contactId().value(),
            saved.patientId().value(),
            saved.primaryContact(),
            saved.emergencyContact(),
            saved.relationshipTypeId().value()
        );
    }
}
