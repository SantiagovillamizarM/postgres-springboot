package com.tarea.application.messagetype.usecase;

import com.tarea.application.messagetype.dto.MessageTypeResponse;
import com.tarea.domain.messagetype.port.repository.MessageTypeRepository;

import java.util.List;

public class ListMessageTypeUseCase {

    private final MessageTypeRepository messageTypeRepository;

    public ListMessageTypeUseCase(MessageTypeRepository messageTypeRepository) {
        this.messageTypeRepository = messageTypeRepository;
    }

    public List<MessageTypeResponse> execute() {
        return messageTypeRepository.findAll().stream()
                .map(messageType -> new MessageTypeResponse(
                    messageType.id().value(),
                    messageType.nameType(),
                    messageType.createdAt(),
                    messageType.updatedAt()
                ))
                .toList();
    }
}
