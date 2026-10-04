package com.tarea.domain.treatmentgoal.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.treatmentgoalstatus.model.valueobject.TreatmentGoalStatusId;
import com.tarea.domain.treatmentplan.model.valueobject.TreatmentPlanId;
import com.tarea.domain.treatmentgoal.event.TreatmentGoalDeletedEvent;
import com.tarea.domain.treatmentgoal.event.TreatmentGoalRegisteredEvent;
import com.tarea.domain.treatmentgoal.event.TreatmentGoalUpdatedEvent;
import com.tarea.domain.treatmentgoal.model.valueobject.TreatmentGoalId;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class TreatmentGoal extends AggregateRoot {
    private final TreatmentGoalId id;
    private TreatmentPlanId treatmentPlanId;
    private String description;
    private LocalDate targetDate;
    private LocalDateTime completedAt;
    private String notes;
    private TreatmentGoalStatusId goalStatusId;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private TreatmentGoal(TreatmentGoalId id, TreatmentPlanId treatmentPlanId, String description,
                          LocalDate targetDate, LocalDateTime completedAt, String notes,
                          TreatmentGoalStatusId goalStatusId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "El ID no puede ser nulo");
        this.treatmentPlanId = Objects.requireNonNull(treatmentPlanId, "El plan de tratamiento no puede ser nulo");
        this.description = description;
        this.targetDate = targetDate;
        this.completedAt = completedAt;
        this.notes = notes;
        this.goalStatusId = Objects.requireNonNull(goalStatusId, "El estado de la meta no puede ser nulo");
        this.createdAt = Objects.requireNonNull(createdAt, "La fecha de creación no puede ser nula");
        this.updatedAt = updatedAt;
    }

    public static TreatmentGoal register(TreatmentPlanId treatmentPlanId, String description,
                                         LocalDate targetDate, LocalDateTime completedAt, String notes,
                                         TreatmentGoalStatusId goalStatusId) {
        TreatmentGoalId id = TreatmentGoalId.generate();
        LocalDateTime now = LocalDateTime.now();

        TreatmentGoal treatmentGoal = new TreatmentGoal(id, treatmentPlanId, description, targetDate,
                                                        completedAt, notes, goalStatusId, now, null);
        treatmentGoal.recordEvent(new TreatmentGoalRegisteredEvent(id, now));
        return treatmentGoal;
    }

    public static TreatmentGoal restore(TreatmentGoalId id, TreatmentPlanId treatmentPlanId,
                                        String description, LocalDate targetDate, LocalDateTime completedAt,
                                        String notes, TreatmentGoalStatusId goalStatusId,
                                        LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new TreatmentGoal(id, treatmentPlanId, description, targetDate, completedAt, notes,
                                 goalStatusId, createdAt, updatedAt);
    }

    public void update(TreatmentPlanId treatmentPlanId, String description, LocalDate targetDate,
                       LocalDateTime completedAt, String notes, TreatmentGoalStatusId goalStatusId) {
        this.treatmentPlanId = Objects.requireNonNull(treatmentPlanId, "El plan de tratamiento no puede ser nulo");
        this.description = description;
        this.targetDate = targetDate;
        this.completedAt = completedAt;
        this.notes = notes;
        this.goalStatusId = Objects.requireNonNull(goalStatusId, "El estado de la meta no puede ser nulo");
        this.updatedAt = LocalDateTime.now();

        recordEvent(new TreatmentGoalUpdatedEvent(this.id, this.treatmentPlanId, this.goalStatusId,
                                                  this.updatedAt));
    }

    public void markAsDeleted() {
        recordEvent(new TreatmentGoalDeletedEvent(this.id, LocalDateTime.now()));
    }

    public TreatmentGoalId id() { return id; }
    public TreatmentPlanId treatmentPlanId() { return treatmentPlanId; }
    public String description() { return description; }
    public LocalDate targetDate() { return targetDate; }
    public LocalDateTime completedAt() { return completedAt; }
    public String notes() { return notes; }
    public TreatmentGoalStatusId goalStatusId() { return goalStatusId; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
