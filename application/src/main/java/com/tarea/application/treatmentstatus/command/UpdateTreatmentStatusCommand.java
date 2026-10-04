package com.tarea.application.treatmentstatus.command;

import com.tarea.domain.treatmentstatus.model.valueobject.TreatmentStatusId;

public record UpdateTreatmentStatusCommand(
        TreatmentStatusId id,
        String code,
        String name,
        Boolean active
) {
}
