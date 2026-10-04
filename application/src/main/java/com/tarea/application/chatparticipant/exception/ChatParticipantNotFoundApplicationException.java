package com.tarea.application.chatparticipant.exception;

import com.tarea.application.common.exception.ApplicationException;

public class ChatParticipantNotFoundApplicationException extends ApplicationException {

    public ChatParticipantNotFoundApplicationException(String id) {
        super("Participante no encontrado con el ID: " + id);
    }
}
