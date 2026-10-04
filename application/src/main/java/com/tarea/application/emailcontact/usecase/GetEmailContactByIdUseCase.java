package com.tarea.application.emailcontact.usecase;

import com.tarea.application.emailcontact.dto.EmailContactResponse;
import com.tarea.application.emailcontact.exception.EmailContactNotFoundApplicationException;
import com.tarea.domain.emailcontact.model.valueobject.EmailContactId;
import com.tarea.domain.emailcontact.port.repository.EmailContactRepository;

public class GetEmailContactByIdUseCase {

    private final EmailContactRepository emailContactRepository;

    public GetEmailContactByIdUseCase(EmailContactRepository emailContactRepository) {
        this.emailContactRepository = emailContactRepository;
    }

    public EmailContactResponse execute(EmailContactId id) {
        var emailContact = emailContactRepository.findById(id)
                .orElseThrow(() -> new EmailContactNotFoundApplicationException(id.value().toString()));

        return new EmailContactResponse(
            emailContact.id().value(),
            emailContact.contactId().value(),
            emailContact.email(),
            emailContact.notes(),
            emailContact.createdAt(),
            emailContact.updatedAt()
        );
    }
}
