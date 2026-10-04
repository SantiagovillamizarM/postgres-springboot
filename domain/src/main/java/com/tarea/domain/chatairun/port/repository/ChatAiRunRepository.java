package com.tarea.domain.chatairun.port.repository;

import com.tarea.domain.chatairun.model.aggregate.ChatAiRun;
import com.tarea.domain.chatairun.model.valueobject.ChatAiRunId;

import java.util.List;
import java.util.Optional;

public interface ChatAiRunRepository {
    ChatAiRun save(ChatAiRun chatAiRun);
    Optional<ChatAiRun> findById(ChatAiRunId id);
    List<ChatAiRun> findAll();
    void delete(ChatAiRun chatAiRun);
}
