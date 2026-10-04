package com.tarea.infrastructure.clinicalrecord.adapters.out.persistence.mappers;

import com.tarea.domain.clinicalrecordstatus.model.valueobject.ClinicalRecordStatusId;
import com.tarea.domain.patient.model.valueobject.PatientId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.domain.clinicalrecord.model.aggregate.ClinicalRecord;
import com.tarea.domain.clinicalrecord.model.valueobject.ClinicalRecordId;
import com.tarea.infrastructure.clinicalrecord.adapters.out.persistence.entity.ClinicalRecordJpaEntity;

public class ClinicalRecordPersistenceMapper {

    public ClinicalRecordJpaEntity toJpa(ClinicalRecord domain) {
        if (domain == null) {
            return null;
        }

        ClinicalRecordJpaEntity jpa = new ClinicalRecordJpaEntity();
        jpa.setId(domain.id().value());
        jpa.setPatientId(domain.patientId().value());
        jpa.setCreationDate(domain.creationDate());
        jpa.setRecordNumber(domain.recordNumber());
        jpa.setOpenedAt(domain.openedAt());
        jpa.setClosedAt(domain.closedAt());
        jpa.setStatusId(domain.statusId().value());
        jpa.setCreatedBy(domain.createdBy().value());
        jpa.setCreatedAt(domain.createdAt());
        return jpa;
    }

    public ClinicalRecord toDomain(ClinicalRecordJpaEntity jpa) {
        if (jpa == null) {
            return null;
        }

        return ClinicalRecord.restore(
                new ClinicalRecordId(jpa.getId()),
                new PatientId(jpa.getPatientId()),
                jpa.getCreationDate(),
                jpa.getRecordNumber(),
                jpa.getOpenedAt(),
                jpa.getClosedAt(),
                new ClinicalRecordStatusId(jpa.getStatusId()),
                new ProfessionalId(jpa.getCreatedBy()),
                jpa.getCreatedAt()
        );
    }
}
