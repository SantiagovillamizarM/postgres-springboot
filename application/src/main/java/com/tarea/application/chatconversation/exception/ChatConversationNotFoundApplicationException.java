package com.tarea.application.chatconversation.exception;

import com.tarea.application.common.exception.ApplicationException;

public class ChatConversationNotFoundApplicationException extends ApplicationException {

    public ChatConversationNotFoundApplicationException(String id) {
        super("Conversación no encontrada con el ID: " + id);
    }
}
