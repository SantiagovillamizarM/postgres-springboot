package com.tarea.application.messagetype.usecase;

import com.tarea.application.messagetype.dto.MessageTypeResponse;
import com.tarea.application.messagetype.exception.MessageTypeNotFoundApplicationException;
import com.tarea.domain.messagetype.model.valueobject.MessageTypeId;
import com.tarea.domain.messagetype.port.repository.MessageTypeRepository;

public class GetMessageTypeByIdUseCase {

    private final MessageTypeRepository messageTypeRepository;

    public GetMessageTypeByIdUseCase(MessageTypeRepository messageTypeRepository) {
        this.messageTypeRepository = messageTypeRepository;
    }

    public MessageTypeResponse execute(MessageTypeId id) {
        var messageType = messageTypeRepository.findById(id)
                .orElseThrow(() -> new MessageTypeNotFoundApplicationException(id.value().toString()));

        return new MessageTypeResponse(
            messageType.id().value(),
            messageType.nameType(),
            messageType.createdAt(),
            messageType.updatedAt()
        );
    }
}
