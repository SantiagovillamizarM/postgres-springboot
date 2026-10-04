package com.tarea.application.chatconversationaisetting.usecase;

import com.tarea.application.chatconversationaisetting.command.RegisterChatConversationAiSettingCommand;
import com.tarea.application.chatconversationaisetting.dto.ChatConversationAiSettingResponse;
import com.tarea.domain.chatconversationaisetting.model.aggregate.ChatConversationAiSetting;
import com.tarea.domain.chatconversationaisetting.port.repository.ChatConversationAiSettingRepository;

public class RegisterChatConversationAiSettingUseCase {

    private final ChatConversationAiSettingRepository chatConversationAiSettingRepository;

    public RegisterChatConversationAiSettingUseCase(ChatConversationAiSettingRepository chatConversationAiSettingRepository) {
        this.chatConversationAiSettingRepository = chatConversationAiSettingRepository;
    }

    public ChatConversationAiSettingResponse execute(RegisterChatConversationAiSettingCommand command) {
        ChatConversationAiSetting chatConversationAiSetting = ChatConversationAiSetting.register(
                command.conversationId(),
                command.aiEnabled(),
                command.defaultModelId()
        );

        ChatConversationAiSetting saved = chatConversationAiSettingRepository.save(chatConversationAiSetting);

        return new ChatConversationAiSettingResponse(
            saved.id().value(),
            saved.conversationId().value(),
            saved.aiEnabled(),
            saved.defaultModelId().value(),
            saved.createdAt(),
            saved.updatedAt()
        );
    }
}
