package com.tarea.domain.chatconversation.exception;

public class ChatConversationNotFoundException extends RuntimeException {
    public ChatConversationNotFoundException(String id) {
        super("Conversación no encontrada con el ID: " + id);
    }
}
