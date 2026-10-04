package com.tarea.application.emailcontact.usecase;

import com.tarea.application.emailcontact.command.RegisterEmailContactCommand;
import com.tarea.application.emailcontact.dto.EmailContactResponse;
import com.tarea.domain.emailcontact.model.aggregate.EmailContact;
import com.tarea.domain.emailcontact.port.repository.EmailContactRepository;

public class RegisterEmailContactUseCase {

    private final EmailContactRepository emailContactRepository;

    public RegisterEmailContactUseCase(EmailContactRepository emailContactRepository) {
        this.emailContactRepository = emailContactRepository;
    }

    public EmailContactResponse execute(RegisterEmailContactCommand command) {
        EmailContact emailContact = EmailContact.register(
                command.contactId(),
                command.email(),
                command.notes()
        );

        EmailContact saved = emailContactRepository.save(emailContact);

        return new EmailContactResponse(
            saved.id().value(),
            saved.contactId().value(),
            saved.email(),
            saved.notes(),
            saved.createdAt(),
            saved.updatedAt()
        );
    }
}
