package com.tarea.domain.chatparticipant.port.repository;

import com.tarea.domain.chatparticipant.model.aggregate.ChatParticipant;
import com.tarea.domain.chatparticipant.model.valueobject.ChatParticipantId;

import java.util.List;
import java.util.Optional;

public interface ChatParticipantRepository {
    ChatParticipant save(ChatParticipant chatParticipant);
    Optional<ChatParticipant> findById(ChatParticipantId id);
    List<ChatParticipant> findAll();
    void delete(ChatParticipant chatParticipant);
}
