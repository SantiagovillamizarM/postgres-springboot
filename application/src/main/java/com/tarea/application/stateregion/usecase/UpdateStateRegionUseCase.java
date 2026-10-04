package com.tarea.application.stateregion.usecase;

import com.tarea.application.stateregion.command.UpdateStateRegionCommand;
import com.tarea.application.stateregion.dto.StateRegionResponse;
import com.tarea.application.stateregion.exception.StateRegionNotFoundApplicationException;
import com.tarea.domain.stateregion.port.repository.StateRegionRepository;

public class UpdateStateRegionUseCase {

    private final StateRegionRepository stateRegionRepository;

    public UpdateStateRegionUseCase(StateRegionRepository stateRegionRepository) {
        this.stateRegionRepository = stateRegionRepository;
    }

    public StateRegionResponse execute(UpdateStateRegionCommand command) {
        var stateRegion = stateRegionRepository.findById(command.id())
                .orElseThrow(() -> new StateRegionNotFoundApplicationException(command.id().value().toString()));

        stateRegion.update(
                command.nameRegion(),
                command.codeRegion(),
                command.description(),
                command.active(),
                command.countryId()
        );

        var updated = stateRegionRepository.save(stateRegion);

        return new StateRegionResponse(
            updated.id().value(),
            updated.nameRegion(),
            updated.codeRegion(),
            updated.description(),
            updated.active(),
            updated.countryId().value(),
            updated.createdAt(),
            updated.updatedAt()
        );
    }
}
