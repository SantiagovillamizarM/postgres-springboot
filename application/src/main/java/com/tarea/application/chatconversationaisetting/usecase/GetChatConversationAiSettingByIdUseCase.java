package com.tarea.application.chatconversationaisetting.usecase;

import com.tarea.application.chatconversationaisetting.dto.ChatConversationAiSettingResponse;
import com.tarea.application.chatconversationaisetting.exception.ChatConversationAiSettingNotFoundApplicationException;
import com.tarea.domain.chatconversationaisetting.model.valueobject.ChatConversationAiSettingId;
import com.tarea.domain.chatconversationaisetting.port.repository.ChatConversationAiSettingRepository;

public class GetChatConversationAiSettingByIdUseCase {

    private final ChatConversationAiSettingRepository chatConversationAiSettingRepository;

    public GetChatConversationAiSettingByIdUseCase(ChatConversationAiSettingRepository chatConversationAiSettingRepository) {
        this.chatConversationAiSettingRepository = chatConversationAiSettingRepository;
    }

    public ChatConversationAiSettingResponse execute(ChatConversationAiSettingId id) {
        var chatConversationAiSetting = chatConversationAiSettingRepository.findById(id)
                .orElseThrow(() -> new ChatConversationAiSettingNotFoundApplicationException(id.value().toString()));

        return new ChatConversationAiSettingResponse(
            chatConversationAiSetting.id().value(),
            chatConversationAiSetting.conversationId().value(),
            chatConversationAiSetting.aiEnabled(),
            chatConversationAiSetting.defaultModelId().value(),
            chatConversationAiSetting.createdAt(),
            chatConversationAiSetting.updatedAt()
        );
    }
}
