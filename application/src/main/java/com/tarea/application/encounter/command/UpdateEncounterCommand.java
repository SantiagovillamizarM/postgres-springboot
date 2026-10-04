package com.tarea.application.encounter.command;

import com.tarea.domain.clinicalrecord.model.valueobject.ClinicalRecordId;
import com.tarea.domain.encountermodality.model.valueobject.EncounterModalityId;
import com.tarea.domain.encounterstatus.model.valueobject.EncounterStatusId;
import com.tarea.domain.encountertype.model.valueobject.EncounterTypeId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.domain.encounter.model.valueobject.EncounterId;

import java.time.LocalDateTime;

public record UpdateEncounterCommand(
        EncounterId id,
        ClinicalRecordId clinicalRecordId,
        ProfessionalId professionalId,
        EncounterTypeId encounterTypeId,
        LocalDateTime startedAt,
        LocalDateTime endedAt,
        String reasonForVisit,
        String currentCondition,
        EncounterModalityId modalityId,
        EncounterStatusId statusId,
        ProfessionalId updatedBy
) {
}
