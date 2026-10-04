package com.tarea.domain.chatconversationaisetting.port.repository;

import com.tarea.domain.chatconversationaisetting.model.aggregate.ChatConversationAiSetting;
import com.tarea.domain.chatconversationaisetting.model.valueobject.ChatConversationAiSettingId;

import java.util.List;
import java.util.Optional;

public interface ChatConversationAiSettingRepository {
    ChatConversationAiSetting save(ChatConversationAiSetting chatConversationAiSetting);
    Optional<ChatConversationAiSetting> findById(ChatConversationAiSettingId id);
    List<ChatConversationAiSetting> findAll();
    void delete(ChatConversationAiSetting chatConversationAiSetting);
}
