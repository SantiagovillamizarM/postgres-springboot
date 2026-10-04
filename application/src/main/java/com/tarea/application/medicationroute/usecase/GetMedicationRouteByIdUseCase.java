package com.tarea.application.medicationroute.usecase;

import com.tarea.application.medicationroute.dto.MedicationRouteResponse;
import com.tarea.application.medicationroute.exception.MedicationRouteNotFoundApplicationException;
import com.tarea.domain.medicationroute.model.valueobject.MedicationRouteId;
import com.tarea.domain.medicationroute.port.repository.MedicationRouteRepository;

public class GetMedicationRouteByIdUseCase {

    private final MedicationRouteRepository medicationRouteRepository;

    public GetMedicationRouteByIdUseCase(MedicationRouteRepository medicationRouteRepository) {
        this.medicationRouteRepository = medicationRouteRepository;
    }

    public MedicationRouteResponse execute(MedicationRouteId id) {
        var medicationRoute = medicationRouteRepository.findById(id)
                .orElseThrow(() -> new MedicationRouteNotFoundApplicationException(id.value().toString()));

        return new MedicationRouteResponse(
            medicationRoute.id().value(),
            medicationRoute.code(),
            medicationRoute.name(),
            medicationRoute.active(),
            medicationRoute.createdAt(),
            medicationRoute.updatedAt()
        );
    }
}
