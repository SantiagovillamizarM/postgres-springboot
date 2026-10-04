package com.tarea.application.patientcontact.usecase;

import com.tarea.application.patientcontact.dto.PatientContactResponse;
import com.tarea.domain.patientcontact.port.repository.PatientContactRepository;

import java.util.List;

public class ListPatientContactUseCase {

    private final PatientContactRepository patientContactRepository;

    public ListPatientContactUseCase(PatientContactRepository patientContactRepository) {
        this.patientContactRepository = patientContactRepository;
    }

    public List<PatientContactResponse> execute() {
        return patientContactRepository.findAll().stream()
                .map(patientContact -> new PatientContactResponse(
                    patientContact.id().value(),
                    patientContact.contactId().value(),
                    patientContact.patientId().value(),
                    patientContact.primaryContact(),
                    patientContact.emergencyContact(),
                    patientContact.relationshipTypeId().value()
                ))
                .toList();
    }
}
