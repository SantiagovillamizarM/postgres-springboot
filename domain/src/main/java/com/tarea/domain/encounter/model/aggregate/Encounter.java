package com.tarea.domain.encounter.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.clinicalrecord.model.valueobject.ClinicalRecordId;
import com.tarea.domain.encountermodality.model.valueobject.EncounterModalityId;
import com.tarea.domain.encounterstatus.model.valueobject.EncounterStatusId;
import com.tarea.domain.encountertype.model.valueobject.EncounterTypeId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.domain.encounter.event.EncounterDeletedEvent;
import com.tarea.domain.encounter.event.EncounterRegisteredEvent;
import com.tarea.domain.encounter.event.EncounterUpdatedEvent;
import com.tarea.domain.encounter.model.valueobject.EncounterId;

import java.time.LocalDateTime;
import java.util.Objects;

public class Encounter extends AggregateRoot {
    private final EncounterId id;
    private ClinicalRecordId clinicalRecordId;
    private ProfessionalId professionalId;
    private EncounterTypeId encounterTypeId;
    private LocalDateTime startedAt;
    private LocalDateTime endedAt;
    private String reasonForVisit;
    private String currentCondition;
    private EncounterModalityId modalityId;
    private EncounterStatusId statusId;
    private final ProfessionalId createdBy;
    private ProfessionalId updatedBy;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Encounter(EncounterId id, ClinicalRecordId clinicalRecordId, ProfessionalId professionalId,
                      EncounterTypeId encounterTypeId, LocalDateTime startedAt, LocalDateTime endedAt,
                      String reasonForVisit, String currentCondition, EncounterModalityId modalityId,
                      EncounterStatusId statusId, ProfessionalId createdBy, ProfessionalId updatedBy,
                      LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "El ID no puede ser nulo");
        this.clinicalRecordId = Objects.requireNonNull(clinicalRecordId, "La historia clínica no puede ser nula");
        this.professionalId = Objects.requireNonNull(professionalId, "El profesional no puede ser nulo");
        this.encounterTypeId = Objects.requireNonNull(encounterTypeId, "El tipo de encuentro no puede ser nulo");
        this.startedAt = startedAt;
        this.endedAt = endedAt;
        this.reasonForVisit = reasonForVisit;
        this.currentCondition = currentCondition;
        this.modalityId = Objects.requireNonNull(modalityId, "La modalidad no puede ser nula");
        this.statusId = Objects.requireNonNull(statusId, "El estado no puede ser nulo");
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.createdAt = Objects.requireNonNull(createdAt, "La fecha de creación no puede ser nula");
        this.updatedAt = updatedAt;
    }

    public static Encounter register(ClinicalRecordId clinicalRecordId, ProfessionalId professionalId,
                                     EncounterTypeId encounterTypeId, LocalDateTime startedAt,
                                     LocalDateTime endedAt, String reasonForVisit, String currentCondition,
                                     EncounterModalityId modalityId, EncounterStatusId statusId,
                                     ProfessionalId createdBy, ProfessionalId updatedBy) {
        EncounterId id = EncounterId.generate();
        LocalDateTime now = LocalDateTime.now();

        Encounter encounter = new Encounter(id, clinicalRecordId, professionalId, encounterTypeId, startedAt,
                                            endedAt, reasonForVisit, currentCondition, modalityId, statusId,
                                            createdBy, updatedBy, now, null);
        encounter.recordEvent(new EncounterRegisteredEvent(id, now));
        return encounter;
    }

    public static Encounter restore(EncounterId id, ClinicalRecordId clinicalRecordId,
                                    ProfessionalId professionalId, EncounterTypeId encounterTypeId,
                                    LocalDateTime startedAt, LocalDateTime endedAt, String reasonForVisit,
                                    String currentCondition, EncounterModalityId modalityId,
                                    EncounterStatusId statusId, ProfessionalId createdBy,
                                    ProfessionalId updatedBy, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new Encounter(id, clinicalRecordId, professionalId, encounterTypeId, startedAt, endedAt,
                             reasonForVisit, currentCondition, modalityId, statusId, createdBy, updatedBy,
                             createdAt, updatedAt);
    }

    public void update(ClinicalRecordId clinicalRecordId, ProfessionalId professionalId,
                       EncounterTypeId encounterTypeId, LocalDateTime startedAt, LocalDateTime endedAt,
                       String reasonForVisit, String currentCondition, EncounterModalityId modalityId,
                       EncounterStatusId statusId, ProfessionalId updatedBy) {
        this.clinicalRecordId = Objects.requireNonNull(clinicalRecordId, "La historia clínica no puede ser nula");
        this.professionalId = Objects.requireNonNull(professionalId, "El profesional no puede ser nulo");
        this.encounterTypeId = Objects.requireNonNull(encounterTypeId, "El tipo de encuentro no puede ser nulo");
        this.startedAt = startedAt;
        this.endedAt = endedAt;
        this.reasonForVisit = reasonForVisit;
        this.currentCondition = currentCondition;
        this.modalityId = Objects.requireNonNull(modalityId, "La modalidad no puede ser nula");
        this.statusId = Objects.requireNonNull(statusId, "El estado no puede ser nulo");
        this.updatedBy = updatedBy;
        this.updatedAt = LocalDateTime.now();

        recordEvent(new EncounterUpdatedEvent(this.id, this.clinicalRecordId, this.professionalId,
                                              this.encounterTypeId, this.modalityId, this.statusId,
                                              this.updatedAt));
    }

    public void markAsDeleted() {
        recordEvent(new EncounterDeletedEvent(this.id, LocalDateTime.now()));
    }

    public EncounterId id() { return id; }
    public ClinicalRecordId clinicalRecordId() { return clinicalRecordId; }
    public ProfessionalId professionalId() { return professionalId; }
    public EncounterTypeId encounterTypeId() { return encounterTypeId; }
    public LocalDateTime startedAt() { return startedAt; }
    public LocalDateTime endedAt() { return endedAt; }
    public String reasonForVisit() { return reasonForVisit; }
    public String currentCondition() { return currentCondition; }
    public EncounterModalityId modalityId() { return modalityId; }
    public EncounterStatusId statusId() { return statusId; }
    public ProfessionalId createdBy() { return createdBy; }
    public ProfessionalId updatedBy() { return updatedBy; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
