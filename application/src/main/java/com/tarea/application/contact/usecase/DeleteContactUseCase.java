package com.tarea.application.contact.usecase;

import com.tarea.application.contact.exception.ContactNotFoundApplicationException;
import com.tarea.domain.contact.model.valueobject.ContactId;
import com.tarea.domain.contact.port.repository.ContactRepository;

public class DeleteContactUseCase {

    private final ContactRepository contactRepository;

    public DeleteContactUseCase(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public void execute(ContactId id) {
        var contact = contactRepository.findById(id)
                .orElseThrow(() -> new ContactNotFoundApplicationException(id.value().toString()));

        contact.markAsDeleted();
        contactRepository.delete(contact);
    }
}
