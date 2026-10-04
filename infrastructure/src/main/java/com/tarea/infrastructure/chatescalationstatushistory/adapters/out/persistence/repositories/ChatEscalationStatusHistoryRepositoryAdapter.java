package com.tarea.infrastructure.chatescalationstatushistory.adapters.out.persistence.repositories;

import com.tarea.domain.chatescalationstatushistory.model.aggregate.ChatEscalationStatusHistory;
import com.tarea.domain.chatescalationstatushistory.model.valueobject.ChatEscalationStatusHistoryId;
import com.tarea.domain.chatescalationstatushistory.port.repository.ChatEscalationStatusHistoryRepository;
import com.tarea.infrastructure.chatescalationstatushistory.adapters.out.persistence.entity.ChatEscalationStatusHistoryJpaEntity;
import com.tarea.infrastructure.chatescalationstatushistory.adapters.out.persistence.mappers.ChatEscalationStatusHistoryPersistenceMapper;

import java.util.List;
import java.util.Optional;

public class ChatEscalationStatusHistoryRepositoryAdapter implements ChatEscalationStatusHistoryRepository {

    private final ChatEscalationStatusHistoryJpaRepository chatEscalationStatusHistoryJpaRepository;
    private final ChatEscalationStatusHistoryPersistenceMapper mapper;

    public ChatEscalationStatusHistoryRepositoryAdapter(ChatEscalationStatusHistoryJpaRepository chatEscalationStatusHistoryJpaRepository, ChatEscalationStatusHistoryPersistenceMapper mapper) {
        this.chatEscalationStatusHistoryJpaRepository = chatEscalationStatusHistoryJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public ChatEscalationStatusHistory save(ChatEscalationStatusHistory chatEscalationStatusHistory) {
        ChatEscalationStatusHistoryJpaEntity entity = mapper.toJpa(chatEscalationStatusHistory);
        ChatEscalationStatusHistoryJpaEntity saved = chatEscalationStatusHistoryJpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<ChatEscalationStatusHistory> findById(ChatEscalationStatusHistoryId id) {
        return chatEscalationStatusHistoryJpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public List<ChatEscalationStatusHistory> findAll() {
        return chatEscalationStatusHistoryJpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void delete(ChatEscalationStatusHistory chatEscalationStatusHistory) {
        chatEscalationStatusHistoryJpaRepository.deleteById(chatEscalationStatusHistory.id().value());
    }
}
