package com.tarea.domain.chatescalationstatushistory.port.repository;

import com.tarea.domain.chatescalationstatushistory.model.aggregate.ChatEscalationStatusHistory;
import com.tarea.domain.chatescalationstatushistory.model.valueobject.ChatEscalationStatusHistoryId;

import java.util.List;
import java.util.Optional;

public interface ChatEscalationStatusHistoryRepository {
    ChatEscalationStatusHistory save(ChatEscalationStatusHistory chatEscalationStatusHistory);
    Optional<ChatEscalationStatusHistory> findById(ChatEscalationStatusHistoryId id);
    List<ChatEscalationStatusHistory> findAll();
    void delete(ChatEscalationStatusHistory chatEscalationStatusHistory);
}
