package com.tarea.application.phonecontact.command;

import com.tarea.domain.contact.model.valueobject.ContactId;

public record RegisterPhoneContactCommand(
        ContactId contactId,
        String phone,
        String notes
) {
}
