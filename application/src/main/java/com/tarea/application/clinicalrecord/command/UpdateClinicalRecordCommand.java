package com.tarea.application.clinicalrecord.command;

import com.tarea.domain.clinicalrecordstatus.model.valueobject.ClinicalRecordStatusId;
import com.tarea.domain.patient.model.valueobject.PatientId;
import com.tarea.domain.clinicalrecord.model.valueobject.ClinicalRecordId;

import java.time.LocalDateTime;

public record UpdateClinicalRecordCommand(
        ClinicalRecordId id,
        PatientId patientId,
        LocalDateTime creationDate,
        String recordNumber,
        LocalDateTime openedAt,
        LocalDateTime closedAt,
        ClinicalRecordStatusId statusId
) {
}
