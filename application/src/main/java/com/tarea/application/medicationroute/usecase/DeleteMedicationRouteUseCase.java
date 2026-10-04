package com.tarea.application.medicationroute.usecase;

import com.tarea.application.medicationroute.exception.MedicationRouteNotFoundApplicationException;
import com.tarea.domain.medicationroute.model.valueobject.MedicationRouteId;
import com.tarea.domain.medicationroute.port.repository.MedicationRouteRepository;

public class DeleteMedicationRouteUseCase {

    private final MedicationRouteRepository medicationRouteRepository;

    public DeleteMedicationRouteUseCase(MedicationRouteRepository medicationRouteRepository) {
        this.medicationRouteRepository = medicationRouteRepository;
    }

    public void execute(MedicationRouteId id) {
        var medicationRoute = medicationRouteRepository.findById(id)
                .orElseThrow(() -> new MedicationRouteNotFoundApplicationException(id.value().toString()));

        medicationRoute.markAsDeleted();
        medicationRouteRepository.delete(medicationRoute);
    }
}
