package com.tarea.infrastructure.clinicalnote.adapters.out.persistence.mappers;

import com.tarea.domain.encounter.model.valueobject.EncounterId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.domain.clinicalnote.model.aggregate.ClinicalNote;
import com.tarea.domain.clinicalnote.model.valueobject.ClinicalNoteId;
import com.tarea.infrastructure.clinicalnote.adapters.out.persistence.entity.ClinicalNoteJpaEntity;

public class ClinicalNotePersistenceMapper {

    public ClinicalNoteJpaEntity toJpa(ClinicalNote domain) {
        if (domain == null) {
            return null;
        }

        ClinicalNoteJpaEntity jpa = new ClinicalNoteJpaEntity();
        jpa.setId(domain.id().value());
        jpa.setEncounterId(domain.encounterId().value());
        jpa.setProfessionalId(domain.professionalId().value());
        jpa.setSubjective(domain.subjective());
        jpa.setObjective(domain.objective());
        jpa.setAssessment(domain.assessment());
        jpa.setPlan(domain.plan());
        jpa.setAdditionalNotes(domain.additionalNotes());
        jpa.setSignedAt(domain.signedAt());
        jpa.setCreatedAt(domain.createdAt());
        jpa.setUpdatedAt(domain.updatedAt());
        return jpa;
    }

    public ClinicalNote toDomain(ClinicalNoteJpaEntity jpa) {
        if (jpa == null) {
            return null;
        }

        return ClinicalNote.restore(
                new ClinicalNoteId(jpa.getId()),
                new EncounterId(jpa.getEncounterId()),
                new ProfessionalId(jpa.getProfessionalId()),
                jpa.getSubjective(),
                jpa.getObjective(),
                jpa.getAssessment(),
                jpa.getPlan(),
                jpa.getAdditionalNotes(),
                jpa.getSignedAt(),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
