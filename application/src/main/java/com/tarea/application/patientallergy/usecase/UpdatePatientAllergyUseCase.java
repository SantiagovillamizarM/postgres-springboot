package com.tarea.application.patientallergy.usecase;

import com.tarea.application.patientallergy.command.UpdatePatientAllergyCommand;
import com.tarea.application.patientallergy.dto.PatientAllergyResponse;
import com.tarea.application.patientallergy.exception.PatientAllergyNotFoundApplicationException;
import com.tarea.domain.patientallergy.port.repository.PatientAllergyRepository;

public class UpdatePatientAllergyUseCase {

    private final PatientAllergyRepository patientAllergyRepository;

    public UpdatePatientAllergyUseCase(PatientAllergyRepository patientAllergyRepository) {
        this.patientAllergyRepository = patientAllergyRepository;
    }

    public PatientAllergyResponse execute(UpdatePatientAllergyCommand command) {
        var patientAllergy = patientAllergyRepository.findById(command.id())
                .orElseThrow(() -> new PatientAllergyNotFoundApplicationException(command.id().value().toString()));

        patientAllergy.update(
                command.patientId(),
                command.substance(),
                command.reaction(),
                command.severity(),
                command.active(),
                command.recordedAt(),
                command.recordedBy()
        );

        var updated = patientAllergyRepository.save(patientAllergy);

        return new PatientAllergyResponse(
            updated.id().value(),
            updated.patientId().value(),
            updated.substance(),
            updated.reaction(),
            updated.severity(),
            updated.active(),
            updated.recordedAt(),
            updated.recordedBy() != null ? updated.recordedBy().value() : null,
            updated.createdAt(),
            updated.updatedAt()
        );
    }
}
