package com.tarea.domain.chatconversationaisetting.exception;

public class ChatConversationAiSettingNotFoundException extends RuntimeException {
    public ChatConversationAiSettingNotFoundException(String id) {
        super("Configuración de IA no encontrada con el ID: " + id);
    }
}
