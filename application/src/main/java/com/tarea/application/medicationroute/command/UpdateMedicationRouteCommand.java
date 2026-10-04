package com.tarea.application.medicationroute.command;

import com.tarea.domain.medicationroute.model.valueobject.MedicationRouteId;

public record UpdateMedicationRouteCommand(
        MedicationRouteId id,
        String code,
        String name,
        Boolean active
) {
}
