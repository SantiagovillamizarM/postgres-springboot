package com.tarea.domain.chatmessage.port.repository;

import com.tarea.domain.chatmessage.model.aggregate.ChatMessage;
import com.tarea.domain.chatmessage.model.valueobject.ChatMessageId;

import java.util.List;
import java.util.Optional;

public interface ChatMessageRepository {
    ChatMessage save(ChatMessage chatMessage);
    Optional<ChatMessage> findById(ChatMessageId id);
    List<ChatMessage> findAll();
    void delete(ChatMessage chatMessage);
}
