package com.tarea.application.treatmentplan.usecase;

import com.tarea.application.treatmentplan.exception.TreatmentPlanNotFoundApplicationException;
import com.tarea.domain.treatmentplan.model.valueobject.TreatmentPlanId;
import com.tarea.domain.treatmentplan.port.repository.TreatmentPlanRepository;

public class DeleteTreatmentPlanUseCase {

    private final TreatmentPlanRepository treatmentPlanRepository;

    public DeleteTreatmentPlanUseCase(TreatmentPlanRepository treatmentPlanRepository) {
        this.treatmentPlanRepository = treatmentPlanRepository;
    }

    public void execute(TreatmentPlanId id) {
        var treatmentPlan = treatmentPlanRepository.findById(id)
                .orElseThrow(() -> new TreatmentPlanNotFoundApplicationException(id.value().toString()));

        treatmentPlan.markAsDeleted();
        treatmentPlanRepository.delete(treatmentPlan);
    }
}
