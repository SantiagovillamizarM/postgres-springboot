package com.tarea.infrastructure.riskassessment.adapters.out.persistence.mappers;

import com.tarea.domain.encounter.model.valueobject.EncounterId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.domain.risklevel.model.valueobject.RiskLevelId;
import com.tarea.domain.riskassessment.model.aggregate.RiskAssessment;
import com.tarea.domain.riskassessment.model.valueobject.RiskAssessmentId;
import com.tarea.infrastructure.riskassessment.adapters.out.persistence.entity.RiskAssessmentJpaEntity;

public class RiskAssessmentPersistenceMapper {

    public RiskAssessmentJpaEntity toJpa(RiskAssessment domain) {
        if (domain == null) {
            return null;
        }

        RiskAssessmentJpaEntity jpa = new RiskAssessmentJpaEntity();
        jpa.setId(domain.id().value());
        jpa.setEncounterId(domain.encounterId().value());
        jpa.setRiskLevelId(domain.riskLevelId().value());
        jpa.setSuicidalIdeation(domain.suicidalIdeation());
        jpa.setSuicidePlan(domain.suicidePlan());
        jpa.setSuicideIntent(domain.suicideIntent());
        jpa.setSelfHarm(domain.selfHarm());
        jpa.setHarmToOthers(domain.harmToOthers());
        jpa.setRiskFactors(domain.riskFactors());
        jpa.setProtectiveFactors(domain.protectiveFactors());
        jpa.setClinicalActions(domain.clinicalActions());
        jpa.setObservations(domain.observations());
        jpa.setAssessedAt(domain.assessedAt());
        jpa.setAssessedBy(domain.assessedBy().value());
        return jpa;
    }

    public RiskAssessment toDomain(RiskAssessmentJpaEntity jpa) {
        if (jpa == null) {
            return null;
        }

        return RiskAssessment.restore(
                new RiskAssessmentId(jpa.getId()),
                new EncounterId(jpa.getEncounterId()),
                new RiskLevelId(jpa.getRiskLevelId()),
                jpa.getSuicidalIdeation() != null ? jpa.getSuicidalIdeation() : false,
                jpa.getSuicidePlan() != null ? jpa.getSuicidePlan() : false,
                jpa.getSuicideIntent() != null ? jpa.getSuicideIntent() : false,
                jpa.getSelfHarm() != null ? jpa.getSelfHarm() : false,
                jpa.getHarmToOthers() != null ? jpa.getHarmToOthers() : false,
                jpa.getRiskFactors(),
                jpa.getProtectiveFactors(),
                jpa.getClinicalActions(),
                jpa.getObservations(),
                jpa.getAssessedAt(),
                new ProfessionalId(jpa.getAssessedBy())
        );
    }
}
