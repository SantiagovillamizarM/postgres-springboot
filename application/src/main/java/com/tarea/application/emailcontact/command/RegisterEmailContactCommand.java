package com.tarea.application.emailcontact.command;

import com.tarea.domain.contact.model.valueobject.ContactId;

public record RegisterEmailContactCommand(
        ContactId contactId,
        String email,
        String notes
) {
}
