package com.tarea.application.emailcontact.usecase;

import com.tarea.application.emailcontact.dto.EmailContactResponse;
import com.tarea.domain.emailcontact.port.repository.EmailContactRepository;

import java.util.List;

public class ListEmailContactUseCase {

    private final EmailContactRepository emailContactRepository;

    public ListEmailContactUseCase(EmailContactRepository emailContactRepository) {
        this.emailContactRepository = emailContactRepository;
    }

    public List<EmailContactResponse> execute() {
        return emailContactRepository.findAll().stream()
                .map(emailContact -> new EmailContactResponse(
                    emailContact.id().value(),
                    emailContact.contactId().value(),
                    emailContact.email(),
                    emailContact.notes(),
                    emailContact.createdAt(),
                    emailContact.updatedAt()
                ))
                .toList();
    }
}
