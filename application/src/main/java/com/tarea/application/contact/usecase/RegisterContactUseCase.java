package com.tarea.application.contact.usecase;

import com.tarea.application.contact.command.RegisterContactCommand;
import com.tarea.application.contact.dto.ContactResponse;
import com.tarea.domain.contact.model.aggregate.Contact;
import com.tarea.domain.contact.port.repository.ContactRepository;

public class RegisterContactUseCase {

    private final ContactRepository contactRepository;

    public RegisterContactUseCase(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public ContactResponse execute(RegisterContactCommand command) {
        Contact contact = Contact.register(
                command.fullName(),
                command.email(),
                command.notes(),
                command.cityId(),
                command.createdBy(),
                command.updatedBy()
        );

        Contact saved = contactRepository.save(contact);

        return new ContactResponse(
            saved.id().value(),
            saved.fullName(),
            saved.email(),
            saved.notes(),
            saved.cityId().value(),
            saved.createdBy().value(),
            saved.updatedBy() != null ? saved.updatedBy().value() : null,
            saved.createdAt(),
            saved.updatedAt()
        );
    }
}
