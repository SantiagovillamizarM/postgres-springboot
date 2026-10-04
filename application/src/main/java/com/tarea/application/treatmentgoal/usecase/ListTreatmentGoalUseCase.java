package com.tarea.application.treatmentgoal.usecase;

import com.tarea.application.treatmentgoal.dto.TreatmentGoalResponse;
import com.tarea.domain.treatmentgoal.port.repository.TreatmentGoalRepository;

import java.util.List;

public class ListTreatmentGoalUseCase {

    private final TreatmentGoalRepository treatmentGoalRepository;

    public ListTreatmentGoalUseCase(TreatmentGoalRepository treatmentGoalRepository) {
        this.treatmentGoalRepository = treatmentGoalRepository;
    }

    public List<TreatmentGoalResponse> execute() {
        return treatmentGoalRepository.findAll().stream()
                .map(treatmentGoal -> new TreatmentGoalResponse(
                    treatmentGoal.id().value(),
                    treatmentGoal.treatmentPlanId().value(),
                    treatmentGoal.description(),
                    treatmentGoal.targetDate(),
                    treatmentGoal.completedAt(),
                    treatmentGoal.notes(),
                    treatmentGoal.goalStatusId().value(),
                    treatmentGoal.createdAt(),
                    treatmentGoal.updatedAt()
                ))
                .toList();
    }
}
