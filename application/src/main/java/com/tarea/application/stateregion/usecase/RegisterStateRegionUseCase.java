package com.tarea.application.stateregion.usecase;

import com.tarea.application.stateregion.command.RegisterStateRegionCommand;
import com.tarea.application.stateregion.dto.StateRegionResponse;
import com.tarea.domain.stateregion.model.aggregate.StateRegion;
import com.tarea.domain.stateregion.port.repository.StateRegionRepository;

public class RegisterStateRegionUseCase {

    private final StateRegionRepository stateRegionRepository;

    public RegisterStateRegionUseCase(StateRegionRepository stateRegionRepository) {
        this.stateRegionRepository = stateRegionRepository;
    }

    public StateRegionResponse execute(RegisterStateRegionCommand command) {
        StateRegion stateRegion = StateRegion.register(
                command.nameRegion(),
                command.codeRegion(),
                command.description(),
                command.active(),
                command.countryId()
        );

        StateRegion saved = stateRegionRepository.save(stateRegion);

        return new StateRegionResponse(
            saved.id().value(),
            saved.nameRegion(),
            saved.codeRegion(),
            saved.description(),
            saved.active(),
            saved.countryId().value(),
            saved.createdAt(),
            saved.updatedAt()
        );
    }
}
