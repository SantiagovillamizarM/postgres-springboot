package com.tarea.application.emailcontact.usecase;

import com.tarea.application.emailcontact.command.UpdateEmailContactCommand;
import com.tarea.application.emailcontact.dto.EmailContactResponse;
import com.tarea.application.emailcontact.exception.EmailContactNotFoundApplicationException;
import com.tarea.domain.emailcontact.port.repository.EmailContactRepository;

public class UpdateEmailContactUseCase {

    private final EmailContactRepository emailContactRepository;

    public UpdateEmailContactUseCase(EmailContactRepository emailContactRepository) {
        this.emailContactRepository = emailContactRepository;
    }

    public EmailContactResponse execute(UpdateEmailContactCommand command) {
        var emailContact = emailContactRepository.findById(command.id())
                .orElseThrow(() -> new EmailContactNotFoundApplicationException(command.id().value().toString()));

        emailContact.update(
                command.contactId(),
                command.email(),
                command.notes()
        );

        var updated = emailContactRepository.save(emailContact);

        return new EmailContactResponse(
            updated.id().value(),
            updated.contactId().value(),
            updated.email(),
            updated.notes(),
            updated.createdAt(),
            updated.updatedAt()
        );
    }
}
