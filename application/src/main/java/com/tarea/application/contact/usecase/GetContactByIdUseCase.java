package com.tarea.application.contact.usecase;

import com.tarea.application.contact.dto.ContactResponse;
import com.tarea.application.contact.exception.ContactNotFoundApplicationException;
import com.tarea.domain.contact.model.valueobject.ContactId;
import com.tarea.domain.contact.port.repository.ContactRepository;

public class GetContactByIdUseCase {

    private final ContactRepository contactRepository;

    public GetContactByIdUseCase(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public ContactResponse execute(ContactId id) {
        var contact = contactRepository.findById(id)
                .orElseThrow(() -> new ContactNotFoundApplicationException(id.value().toString()));

        return new ContactResponse(
            contact.id().value(),
            contact.fullName(),
            contact.email(),
            contact.notes(),
            contact.cityId().value(),
            contact.createdBy().value(),
            contact.updatedBy() != null ? contact.updatedBy().value() : null,
            contact.createdAt(),
            contact.updatedAt()
        );
    }
}
