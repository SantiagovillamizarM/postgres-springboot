package com.tarea.application.messagetype.command;

import com.tarea.domain.messagetype.model.valueobject.MessageTypeId;

public record UpdateMessageTypeCommand(
        MessageTypeId id,
        String nameType
) {
}
