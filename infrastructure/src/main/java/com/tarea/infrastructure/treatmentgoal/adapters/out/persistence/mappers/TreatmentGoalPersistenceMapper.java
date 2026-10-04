package com.tarea.infrastructure.treatmentgoal.adapters.out.persistence.mappers;

import com.tarea.domain.treatmentgoalstatus.model.valueobject.TreatmentGoalStatusId;
import com.tarea.domain.treatmentplan.model.valueobject.TreatmentPlanId;
import com.tarea.domain.treatmentgoal.model.aggregate.TreatmentGoal;
import com.tarea.domain.treatmentgoal.model.valueobject.TreatmentGoalId;
import com.tarea.infrastructure.treatmentgoal.adapters.out.persistence.entity.TreatmentGoalJpaEntity;

public class TreatmentGoalPersistenceMapper {

    public TreatmentGoalJpaEntity toJpa(TreatmentGoal domain) {
        if (domain == null) {
            return null;
        }

        TreatmentGoalJpaEntity jpa = new TreatmentGoalJpaEntity();
        jpa.setId(domain.id().value());
        jpa.setTreatmentPlanId(domain.treatmentPlanId().value());
        jpa.setDescription(domain.description());
        jpa.setTargetDate(domain.targetDate());
        jpa.setCompletedAt(domain.completedAt());
        jpa.setNotes(domain.notes());
        jpa.setGoalStatusId(domain.goalStatusId().value());
        jpa.setCreatedAt(domain.createdAt());
        jpa.setUpdatedAt(domain.updatedAt());
        return jpa;
    }

    public TreatmentGoal toDomain(TreatmentGoalJpaEntity jpa) {
        if (jpa == null) {
            return null;
        }

        return TreatmentGoal.restore(
                new TreatmentGoalId(jpa.getId()),
                new TreatmentPlanId(jpa.getTreatmentPlanId()),
                jpa.getDescription(),
                jpa.getTargetDate(),
                jpa.getCompletedAt(),
                jpa.getNotes(),
                new TreatmentGoalStatusId(jpa.getGoalStatusId()),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
