package com.tarea.infrastructure.encounter.adapters.out.persistence.mappers;

import com.tarea.domain.clinicalrecord.model.valueobject.ClinicalRecordId;
import com.tarea.domain.encountermodality.model.valueobject.EncounterModalityId;
import com.tarea.domain.encounterstatus.model.valueobject.EncounterStatusId;
import com.tarea.domain.encountertype.model.valueobject.EncounterTypeId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.domain.encounter.model.aggregate.Encounter;
import com.tarea.domain.encounter.model.valueobject.EncounterId;
import com.tarea.infrastructure.encounter.adapters.out.persistence.entity.EncounterJpaEntity;

public class EncounterPersistenceMapper {

    public EncounterJpaEntity toJpa(Encounter domain) {
        if (domain == null) {
            return null;
        }

        EncounterJpaEntity jpa = new EncounterJpaEntity();
        jpa.setId(domain.id().value());
        jpa.setClinicalRecordId(domain.clinicalRecordId().value());
        jpa.setProfessionalId(domain.professionalId().value());
        jpa.setEncounterTypeId(domain.encounterTypeId().value());
        jpa.setStartedAt(domain.startedAt());
        jpa.setEndedAt(domain.endedAt());
        jpa.setReasonForVisit(domain.reasonForVisit());
        jpa.setCurrentCondition(domain.currentCondition());
        jpa.setModalityId(domain.modalityId().value());
        jpa.setStatusId(domain.statusId().value());
        jpa.setCreatedBy(domain.createdBy() != null ? domain.createdBy().value() : null);
        jpa.setUpdatedBy(domain.updatedBy() != null ? domain.updatedBy().value() : null);
        jpa.setCreatedAt(domain.createdAt());
        jpa.setUpdatedAt(domain.updatedAt());
        return jpa;
    }

    public Encounter toDomain(EncounterJpaEntity jpa) {
        if (jpa == null) {
            return null;
        }

        return Encounter.restore(
                new EncounterId(jpa.getId()),
                new ClinicalRecordId(jpa.getClinicalRecordId()),
                new ProfessionalId(jpa.getProfessionalId()),
                new EncounterTypeId(jpa.getEncounterTypeId()),
                jpa.getStartedAt(),
                jpa.getEndedAt(),
                jpa.getReasonForVisit(),
                jpa.getCurrentCondition(),
                new EncounterModalityId(jpa.getModalityId()),
                new EncounterStatusId(jpa.getStatusId()),
                jpa.getCreatedBy() != null ? new ProfessionalId(jpa.getCreatedBy()) : null,
                jpa.getUpdatedBy() != null ? new ProfessionalId(jpa.getUpdatedBy()) : null,
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
