package com.tarea.application.patientcontact.usecase;

import com.tarea.application.patientcontact.exception.PatientContactNotFoundApplicationException;
import com.tarea.domain.patientcontact.model.valueobject.PatientContactId;
import com.tarea.domain.patientcontact.port.repository.PatientContactRepository;

public class DeletePatientContactUseCase {

    private final PatientContactRepository patientContactRepository;

    public DeletePatientContactUseCase(PatientContactRepository patientContactRepository) {
        this.patientContactRepository = patientContactRepository;
    }

    public void execute(PatientContactId id) {
        var patientContact = patientContactRepository.findById(id)
                .orElseThrow(() -> new PatientContactNotFoundApplicationException(id.value().toString()));

        patientContact.markAsDeleted();
        patientContactRepository.delete(patientContact);
    }
}
