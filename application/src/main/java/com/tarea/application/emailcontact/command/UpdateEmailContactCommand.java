package com.tarea.application.emailcontact.command;

import com.tarea.domain.contact.model.valueobject.ContactId;
import com.tarea.domain.emailcontact.model.valueobject.EmailContactId;

public record UpdateEmailContactCommand(
        EmailContactId id,
        ContactId contactId,
        String email,
        String notes
) {
}
