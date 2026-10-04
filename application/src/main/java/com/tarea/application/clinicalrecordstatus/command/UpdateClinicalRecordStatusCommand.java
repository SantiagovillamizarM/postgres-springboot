package com.tarea.application.clinicalrecordstatus.command;

import com.tarea.domain.clinicalrecordstatus.model.valueobject.ClinicalRecordStatusId;

public record UpdateClinicalRecordStatusCommand(
        ClinicalRecordStatusId id,
        String code,
        String name
) {
}
