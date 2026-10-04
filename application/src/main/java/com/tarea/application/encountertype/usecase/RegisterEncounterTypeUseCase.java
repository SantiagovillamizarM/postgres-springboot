package com.tarea.application.encountertype.usecase;

import com.tarea.application.encountertype.command.RegisterEncounterTypeCommand;
import com.tarea.application.encountertype.dto.EncounterTypeResponse;
import com.tarea.domain.encountertype.model.aggregate.EncounterType;
import com.tarea.domain.encountertype.port.repository.EncounterTypeRepository;

public class RegisterEncounterTypeUseCase {

    private final EncounterTypeRepository encounterTypeRepository;

    public RegisterEncounterTypeUseCase(EncounterTypeRepository encounterTypeRepository) {
        this.encounterTypeRepository = encounterTypeRepository;
    }

    public EncounterTypeResponse execute(RegisterEncounterTypeCommand command) {
        EncounterType encounterType = EncounterType.register(
                command.code(),
                command.name(),
                command.active()
        );

        EncounterType saved = encounterTypeRepository.save(encounterType);

        return new EncounterTypeResponse(
            saved.id().value(),
            saved.code(),
            saved.name(),
            saved.active(),
            saved.createdAt(),
            saved.updatedAt()
        );
    }
}
