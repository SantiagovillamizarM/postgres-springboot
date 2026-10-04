package com.tarea.application.chatmessage.exception;

import com.tarea.application.common.exception.ApplicationException;

public class ChatMessageNotFoundApplicationException extends ApplicationException {

    public ChatMessageNotFoundApplicationException(String id) {
        super("Mensaje no encontrado con el ID: " + id);
    }
}
