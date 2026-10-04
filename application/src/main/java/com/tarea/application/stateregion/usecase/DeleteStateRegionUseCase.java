package com.tarea.application.stateregion.usecase;

import com.tarea.application.stateregion.exception.StateRegionNotFoundApplicationException;
import com.tarea.domain.stateregion.model.valueobject.StateRegionId;
import com.tarea.domain.stateregion.port.repository.StateRegionRepository;

public class DeleteStateRegionUseCase {

    private final StateRegionRepository stateRegionRepository;

    public DeleteStateRegionUseCase(StateRegionRepository stateRegionRepository) {
        this.stateRegionRepository = stateRegionRepository;
    }

    public void execute(StateRegionId id) {
        var stateRegion = stateRegionRepository.findById(id)
                .orElseThrow(() -> new StateRegionNotFoundApplicationException(id.value().toString()));

        stateRegion.markAsDeleted();
        stateRegionRepository.delete(stateRegion);
    }
}
