package com.tarea.domain.chatparticipant.exception;

public class ChatParticipantNotFoundException extends RuntimeException {
    public ChatParticipantNotFoundException(String id) {
        super("Participante no encontrado con el ID: " + id);
    }
}
