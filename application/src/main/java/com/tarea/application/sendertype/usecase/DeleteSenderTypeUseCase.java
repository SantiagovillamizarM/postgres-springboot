package com.tarea.application.sendertype.usecase;

import com.tarea.application.sendertype.exception.SenderTypeNotFoundApplicationException;
import com.tarea.domain.sendertype.model.valueobject.SenderTypeId;
import com.tarea.domain.sendertype.port.repository.SenderTypeRepository;

public class DeleteSenderTypeUseCase {

    private final SenderTypeRepository senderTypeRepository;

    public DeleteSenderTypeUseCase(SenderTypeRepository senderTypeRepository) {
        this.senderTypeRepository = senderTypeRepository;
    }

    public void execute(SenderTypeId id) {
        var senderType = senderTypeRepository.findById(id)
                .orElseThrow(() -> new SenderTypeNotFoundApplicationException(id.value().toString()));

        senderType.markAsDeleted();
        senderTypeRepository.delete(senderType);
    }
}
