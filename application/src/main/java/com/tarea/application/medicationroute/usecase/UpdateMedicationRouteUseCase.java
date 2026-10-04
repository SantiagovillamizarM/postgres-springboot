package com.tarea.application.medicationroute.usecase;

import com.tarea.application.medicationroute.command.UpdateMedicationRouteCommand;
import com.tarea.application.medicationroute.dto.MedicationRouteResponse;
import com.tarea.application.medicationroute.exception.MedicationRouteNotFoundApplicationException;
import com.tarea.domain.medicationroute.port.repository.MedicationRouteRepository;

public class UpdateMedicationRouteUseCase {

    private final MedicationRouteRepository medicationRouteRepository;

    public UpdateMedicationRouteUseCase(MedicationRouteRepository medicationRouteRepository) {
        this.medicationRouteRepository = medicationRouteRepository;
    }

    public MedicationRouteResponse execute(UpdateMedicationRouteCommand command) {
        var medicationRoute = medicationRouteRepository.findById(command.id())
                .orElseThrow(() -> new MedicationRouteNotFoundApplicationException(command.id().value().toString()));

        medicationRoute.update(
                command.code(),
                command.name(),
                command.active()
        );

        var updated = medicationRouteRepository.save(medicationRoute);

        return new MedicationRouteResponse(
            updated.id().value(),
            updated.code(),
            updated.name(),
            updated.active(),
            updated.createdAt(),
            updated.updatedAt()
        );
    }
}
