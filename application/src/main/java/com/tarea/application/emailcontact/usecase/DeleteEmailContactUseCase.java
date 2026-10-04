package com.tarea.application.emailcontact.usecase;

import com.tarea.application.emailcontact.exception.EmailContactNotFoundApplicationException;
import com.tarea.domain.emailcontact.model.valueobject.EmailContactId;
import com.tarea.domain.emailcontact.port.repository.EmailContactRepository;

public class DeleteEmailContactUseCase {

    private final EmailContactRepository emailContactRepository;

    public DeleteEmailContactUseCase(EmailContactRepository emailContactRepository) {
        this.emailContactRepository = emailContactRepository;
    }

    public void execute(EmailContactId id) {
        var emailContact = emailContactRepository.findById(id)
                .orElseThrow(() -> new EmailContactNotFoundApplicationException(id.value().toString()));

        emailContact.markAsDeleted();
        emailContactRepository.delete(emailContact);
    }
}
