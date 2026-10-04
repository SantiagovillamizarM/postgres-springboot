package com.tarea.domain.chatmessage.exception;

public class ChatMessageNotFoundException extends RuntimeException {
    public ChatMessageNotFoundException(String id) {
        super("Mensaje no encontrado con el ID: " + id);
    }
}
