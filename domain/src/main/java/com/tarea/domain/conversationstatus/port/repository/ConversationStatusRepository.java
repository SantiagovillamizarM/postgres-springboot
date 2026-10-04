package com.tarea.domain.conversationstatus.port.repository;

import com.tarea.domain.conversationstatus.model.aggregate.ConversationStatus;
import com.tarea.domain.conversationstatus.model.valueobject.ConversationStatusId;

import java.util.List;
import java.util.Optional;

public interface ConversationStatusRepository {
    ConversationStatus save(ConversationStatus conversationStatus);
    Optional<ConversationStatus> findById(ConversationStatusId id);
    List<ConversationStatus> findAll();
    void delete(ConversationStatus conversationStatus);
}
