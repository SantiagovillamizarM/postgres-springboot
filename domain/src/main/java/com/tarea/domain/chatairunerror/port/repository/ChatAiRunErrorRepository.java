package com.tarea.domain.chatairunerror.port.repository;

import com.tarea.domain.chatairunerror.model.aggregate.ChatAiRunError;
import com.tarea.domain.chatairunerror.model.valueobject.ChatAiRunErrorId;

import java.util.List;
import java.util.Optional;

public interface ChatAiRunErrorRepository {
    ChatAiRunError save(ChatAiRunError chatAiRunError);
    Optional<ChatAiRunError> findById(ChatAiRunErrorId id);
    List<ChatAiRunError> findAll();
    void delete(ChatAiRunError chatAiRunError);
}
