package com.tarea.application.phonecontact.usecase;

import com.tarea.application.phonecontact.exception.PhoneContactNotFoundApplicationException;
import com.tarea.domain.phonecontact.model.valueobject.PhoneContactId;
import com.tarea.domain.phonecontact.port.repository.PhoneContactRepository;

public class DeletePhoneContactUseCase {

    private final PhoneContactRepository phoneContactRepository;

    public DeletePhoneContactUseCase(PhoneContactRepository phoneContactRepository) {
        this.phoneContactRepository = phoneContactRepository;
    }

    public void execute(PhoneContactId id) {
        var phoneContact = phoneContactRepository.findById(id)
                .orElseThrow(() -> new PhoneContactNotFoundApplicationException(id.value().toString()));

        phoneContact.markAsDeleted();
        phoneContactRepository.delete(phoneContact);
    }
}
