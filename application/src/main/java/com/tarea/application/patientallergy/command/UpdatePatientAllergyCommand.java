package com.tarea.application.patientallergy.command;

import com.tarea.domain.patient.model.valueobject.PatientId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.domain.patientallergy.model.valueobject.PatientAllergyId;

import java.time.LocalDateTime;

public record UpdatePatientAllergyCommand(
        PatientAllergyId id,
        PatientId patientId,
        String substance,
        String reaction,
        String severity,
        Boolean active,
        LocalDateTime recordedAt,
        ProfessionalId recordedBy
) {
}
