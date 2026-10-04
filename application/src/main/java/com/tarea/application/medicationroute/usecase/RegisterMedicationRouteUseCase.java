package com.tarea.application.medicationroute.usecase;

import com.tarea.application.medicationroute.command.RegisterMedicationRouteCommand;
import com.tarea.application.medicationroute.dto.MedicationRouteResponse;
import com.tarea.domain.medicationroute.model.aggregate.MedicationRoute;
import com.tarea.domain.medicationroute.port.repository.MedicationRouteRepository;

public class RegisterMedicationRouteUseCase {

    private final MedicationRouteRepository medicationRouteRepository;

    public RegisterMedicationRouteUseCase(MedicationRouteRepository medicationRouteRepository) {
        this.medicationRouteRepository = medicationRouteRepository;
    }

    public MedicationRouteResponse execute(RegisterMedicationRouteCommand command) {
        MedicationRoute medicationRoute = MedicationRoute.register(
                command.code(),
                command.name(),
                command.active()
        );

        MedicationRoute saved = medicationRouteRepository.save(medicationRoute);

        return new MedicationRouteResponse(
            saved.id().value(),
            saved.code(),
            saved.name(),
            saved.active(),
            saved.createdAt(),
            saved.updatedAt()
        );
    }
}
