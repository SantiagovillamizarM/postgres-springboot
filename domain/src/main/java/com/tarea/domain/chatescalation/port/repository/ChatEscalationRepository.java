package com.tarea.domain.chatescalation.port.repository;

import com.tarea.domain.chatescalation.model.aggregate.ChatEscalation;
import com.tarea.domain.chatescalation.model.valueobject.ChatEscalationId;

import java.util.List;
import java.util.Optional;

public interface ChatEscalationRepository {
    ChatEscalation save(ChatEscalation chatEscalation);
    Optional<ChatEscalation> findById(ChatEscalationId id);
    List<ChatEscalation> findAll();
    void delete(ChatEscalation chatEscalation);
}
