package com.tarea.application.phonecontact.command;

import com.tarea.domain.contact.model.valueobject.ContactId;
import com.tarea.domain.phonecontact.model.valueobject.PhoneContactId;

public record UpdatePhoneContactCommand(
        PhoneContactId id,
        ContactId contactId,
        String phone,
        String notes
) {
}
