package com.tarea.application.sendertype.command;

import com.tarea.domain.sendertype.model.valueobject.SenderTypeId;

public record UpdateSenderTypeCommand(
        SenderTypeId id,
        String nameType
) {
}
