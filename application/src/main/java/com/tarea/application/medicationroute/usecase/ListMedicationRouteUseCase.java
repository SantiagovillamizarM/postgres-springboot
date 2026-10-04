package com.tarea.application.medicationroute.usecase;

import com.tarea.application.medicationroute.dto.MedicationRouteResponse;
import com.tarea.domain.medicationroute.port.repository.MedicationRouteRepository;

import java.util.List;

public class ListMedicationRouteUseCase {

    private final MedicationRouteRepository medicationRouteRepository;

    public ListMedicationRouteUseCase(MedicationRouteRepository medicationRouteRepository) {
        this.medicationRouteRepository = medicationRouteRepository;
    }

    public List<MedicationRouteResponse> execute() {
        return medicationRouteRepository.findAll().stream()
                .map(medicationRoute -> new MedicationRouteResponse(
                    medicationRoute.id().value(),
                    medicationRoute.code(),
                    medicationRoute.name(),
                    medicationRoute.active(),
                    medicationRoute.createdAt(),
                    medicationRoute.updatedAt()
                ))
                .toList();
    }
}
