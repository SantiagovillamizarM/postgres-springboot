package com.tarea.application.chatconversationaisetting.usecase;

import com.tarea.application.chatconversationaisetting.command.UpdateChatConversationAiSettingCommand;
import com.tarea.application.chatconversationaisetting.dto.ChatConversationAiSettingResponse;
import com.tarea.application.chatconversationaisetting.exception.ChatConversationAiSettingNotFoundApplicationException;
import com.tarea.domain.chatconversationaisetting.port.repository.ChatConversationAiSettingRepository;

public class UpdateChatConversationAiSettingUseCase {

    private final ChatConversationAiSettingRepository chatConversationAiSettingRepository;

    public UpdateChatConversationAiSettingUseCase(ChatConversationAiSettingRepository chatConversationAiSettingRepository) {
        this.chatConversationAiSettingRepository = chatConversationAiSettingRepository;
    }

    public ChatConversationAiSettingResponse execute(UpdateChatConversationAiSettingCommand command) {
        var chatConversationAiSetting = chatConversationAiSettingRepository.findById(command.id())
                .orElseThrow(() -> new ChatConversationAiSettingNotFoundApplicationException(command.id().value().toString()));

        chatConversationAiSetting.update(
                command.conversationId(),
                command.aiEnabled(),
                command.defaultModelId()
        );

        var updated = chatConversationAiSettingRepository.save(chatConversationAiSetting);

        return new ChatConversationAiSettingResponse(
            updated.id().value(),
            updated.conversationId().value(),
            updated.aiEnabled(),
            updated.defaultModelId().value(),
            updated.createdAt(),
            updated.updatedAt()
        );
    }
}
