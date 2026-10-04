package com.tarea.domain.chatconversation.port.repository;

import com.tarea.domain.chatconversation.model.aggregate.ChatConversation;
import com.tarea.domain.chatconversation.model.valueobject.ChatConversationId;

import java.util.List;
import java.util.Optional;

public interface ChatConversationRepository {
    ChatConversation save(ChatConversation chatConversation);
    Optional<ChatConversation> findById(ChatConversationId id);
    List<ChatConversation> findAll();
    void delete(ChatConversation chatConversation);
}
