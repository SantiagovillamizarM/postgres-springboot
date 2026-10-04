package com.tarea.application.patient.usecase;

import com.tarea.application.patient.exception.PatientNotFoundApplicationException;
import com.tarea.domain.patient.model.valueobject.PatientId;
import com.tarea.domain.patient.port.repository.PatientRepository;

public class DeletePatientUseCase {

    private final PatientRepository patientRepository;

    public DeletePatientUseCase(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void execute(PatientId id) {
        var patient = patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundApplicationException(id.value().toString()));

        patient.markAsDeleted();
        patientRepository.delete(patient);
    }
}
