package com.tarea.infrastructure.chatconversationaisetting.adapters.out.persistence.repositories;

import com.tarea.domain.chatconversationaisetting.model.aggregate.ChatConversationAiSetting;
import com.tarea.domain.chatconversationaisetting.model.valueobject.ChatConversationAiSettingId;
import com.tarea.domain.chatconversationaisetting.port.repository.ChatConversationAiSettingRepository;
import com.tarea.infrastructure.chatconversationaisetting.adapters.out.persistence.entity.ChatConversationAiSettingJpaEntity;
import com.tarea.infrastructure.chatconversationaisetting.adapters.out.persistence.mappers.ChatConversationAiSettingPersistenceMapper;

import java.util.List;
import java.util.Optional;

public class ChatConversationAiSettingRepositoryAdapter implements ChatConversationAiSettingRepository {

    private final ChatConversationAiSettingJpaRepository chatConversationAiSettingJpaRepository;
    private final ChatConversationAiSettingPersistenceMapper mapper;

    public ChatConversationAiSettingRepositoryAdapter(ChatConversationAiSettingJpaRepository chatConversationAiSettingJpaRepository, ChatConversationAiSettingPersistenceMapper mapper) {
        this.chatConversationAiSettingJpaRepository = chatConversationAiSettingJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public ChatConversationAiSetting save(ChatConversationAiSetting chatConversationAiSetting) {
        ChatConversationAiSettingJpaEntity entity = mapper.toJpa(chatConversationAiSetting);
        ChatConversationAiSettingJpaEntity saved = chatConversationAiSettingJpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<ChatConversationAiSetting> findById(ChatConversationAiSettingId id) {
        return chatConversationAiSettingJpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public List<ChatConversationAiSetting> findAll() {
        return chatConversationAiSettingJpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void delete(ChatConversationAiSetting chatConversationAiSetting) {
        chatConversationAiSettingJpaRepository.deleteById(chatConversationAiSetting.id().value());
    }
}
