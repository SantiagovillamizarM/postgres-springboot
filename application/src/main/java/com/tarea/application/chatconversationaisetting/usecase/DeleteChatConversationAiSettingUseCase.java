package com.tarea.application.chatconversationaisetting.usecase;

import com.tarea.application.chatconversationaisetting.exception.ChatConversationAiSettingNotFoundApplicationException;
import com.tarea.domain.chatconversationaisetting.model.valueobject.ChatConversationAiSettingId;
import com.tarea.domain.chatconversationaisetting.port.repository.ChatConversationAiSettingRepository;

public class DeleteChatConversationAiSettingUseCase {

    private final ChatConversationAiSettingRepository chatConversationAiSettingRepository;

    public DeleteChatConversationAiSettingUseCase(ChatConversationAiSettingRepository chatConversationAiSettingRepository) {
        this.chatConversationAiSettingRepository = chatConversationAiSettingRepository;
    }

    public void execute(ChatConversationAiSettingId id) {
        var chatConversationAiSetting = chatConversationAiSettingRepository.findById(id)
                .orElseThrow(() -> new ChatConversationAiSettingNotFoundApplicationException(id.value().toString()));

        chatConversationAiSetting.markAsDeleted();
        chatConversationAiSettingRepository.delete(chatConversationAiSetting);
    }
}
