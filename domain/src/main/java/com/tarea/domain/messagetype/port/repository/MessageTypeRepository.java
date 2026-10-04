package com.tarea.domain.messagetype.port.repository;

import com.tarea.domain.messagetype.model.aggregate.MessageType;
import com.tarea.domain.messagetype.model.valueobject.MessageTypeId;

import java.util.List;
import java.util.Optional;

public interface MessageTypeRepository {
    MessageType save(MessageType messageType);
    Optional<MessageType> findById(MessageTypeId id);
    List<MessageType> findAll();
    void delete(MessageType messageType);
}
