package com.tarea.application.contact.usecase;

import com.tarea.application.contact.command.UpdateContactCommand;
import com.tarea.application.contact.dto.ContactResponse;
import com.tarea.application.contact.exception.ContactNotFoundApplicationException;
import com.tarea.domain.contact.port.repository.ContactRepository;

public class UpdateContactUseCase {

    private final ContactRepository contactRepository;

    public UpdateContactUseCase(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public ContactResponse execute(UpdateContactCommand command) {
        var contact = contactRepository.findById(command.id())
                .orElseThrow(() -> new ContactNotFoundApplicationException(command.id().value().toString()));

        contact.update(
                command.fullName(),
                command.email(),
                command.notes(),
                command.cityId(),
                command.updatedBy()
        );

        var updated = contactRepository.save(contact);

        return new ContactResponse(
            updated.id().value(),
            updated.fullName(),
            updated.email(),
            updated.notes(),
            updated.cityId().value(),
            updated.createdBy().value(),
            updated.updatedBy() != null ? updated.updatedBy().value() : null,
            updated.createdAt(),
            updated.updatedAt()
        );
    }
}
