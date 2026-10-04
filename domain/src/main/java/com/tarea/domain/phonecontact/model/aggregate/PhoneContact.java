package com.tarea.domain.phonecontact.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.contact.model.valueobject.ContactId;
import com.tarea.domain.phonecontact.event.PhoneContactDeletedEvent;
import com.tarea.domain.phonecontact.event.PhoneContactRegisteredEvent;
import com.tarea.domain.phonecontact.event.PhoneContactUpdatedEvent;
import com.tarea.domain.phonecontact.model.valueobject.PhoneContactId;

import java.time.LocalDateTime;
import java.util.Objects;

public class PhoneContact extends AggregateRoot {
    private final PhoneContactId id;
    private ContactId contactId;
    private String phone;
    private String notes;

    private PhoneContact(PhoneContactId id, ContactId contactId, String phone, String notes) {
        this.id = Objects.requireNonNull(id, "El ID no puede ser nulo");
        this.contactId = Objects.requireNonNull(contactId, "El contacto no puede ser nulo");
        this.phone = phone;
        this.notes = notes;
    }

    public static PhoneContact register(ContactId contactId, String phone, String notes) {
        PhoneContactId id = PhoneContactId.generate();
        LocalDateTime now = LocalDateTime.now();

        PhoneContact phoneContact = new PhoneContact(id, contactId, phone, notes);
        phoneContact.recordEvent(new PhoneContactRegisteredEvent(id, now));
        return phoneContact;
    }

    public static PhoneContact restore(PhoneContactId id, ContactId contactId, String phone, String notes) {
        return new PhoneContact(id, contactId, phone, notes);
    }

    public void update(ContactId contactId, String phone, String notes) {
        this.contactId = Objects.requireNonNull(contactId, "El contacto no puede ser nulo");
        this.phone = phone;
        this.notes = notes;

        recordEvent(new PhoneContactUpdatedEvent(this.id, this.contactId, LocalDateTime.now()));
    }

    public void markAsDeleted() {
        recordEvent(new PhoneContactDeletedEvent(this.id, LocalDateTime.now()));
    }

    public PhoneContactId id() { return id; }
    public ContactId contactId() { return contactId; }
    public String phone() { return phone; }
    public String notes() { return notes; }
}
