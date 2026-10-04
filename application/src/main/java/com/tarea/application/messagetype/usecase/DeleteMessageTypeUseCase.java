package com.tarea.application.messagetype.usecase;

import com.tarea.application.messagetype.exception.MessageTypeNotFoundApplicationException;
import com.tarea.domain.messagetype.model.valueobject.MessageTypeId;
import com.tarea.domain.messagetype.port.repository.MessageTypeRepository;

public class DeleteMessageTypeUseCase {

    private final MessageTypeRepository messageTypeRepository;

    public DeleteMessageTypeUseCase(MessageTypeRepository messageTypeRepository) {
        this.messageTypeRepository = messageTypeRepository;
    }

    public void execute(MessageTypeId id) {
        var messageType = messageTypeRepository.findById(id)
                .orElseThrow(() -> new MessageTypeNotFoundApplicationException(id.value().toString()));

        messageType.markAsDeleted();
        messageTypeRepository.delete(messageType);
    }
}
