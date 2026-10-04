package com.tarea.application.sendertype.usecase;

import com.tarea.application.sendertype.command.UpdateSenderTypeCommand;
import com.tarea.application.sendertype.dto.SenderTypeResponse;
import com.tarea.application.sendertype.exception.SenderTypeNotFoundApplicationException;
import com.tarea.domain.sendertype.port.repository.SenderTypeRepository;

public class UpdateSenderTypeUseCase {

    private final SenderTypeRepository senderTypeRepository;

    public UpdateSenderTypeUseCase(SenderTypeRepository senderTypeRepository) {
        this.senderTypeRepository = senderTypeRepository;
    }

    public SenderTypeResponse execute(UpdateSenderTypeCommand command) {
        var senderType = senderTypeRepository.findById(command.id())
                .orElseThrow(() -> new SenderTypeNotFoundApplicationException(command.id().value().toString()));

        senderType.update(
                command.nameType()
        );

        var updated = senderTypeRepository.save(senderType);

        return new SenderTypeResponse(
            updated.id().value(),
            updated.nameType(),
            updated.createdAt(),
            updated.updatedAt()
        );
    }
}
