package com.tarea.application.phonecontact.usecase;

import com.tarea.application.phonecontact.dto.PhoneContactResponse;
import com.tarea.application.phonecontact.exception.PhoneContactNotFoundApplicationException;
import com.tarea.domain.phonecontact.model.valueobject.PhoneContactId;
import com.tarea.domain.phonecontact.port.repository.PhoneContactRepository;

public class GetPhoneContactByIdUseCase {

    private final PhoneContactRepository phoneContactRepository;

    public GetPhoneContactByIdUseCase(PhoneContactRepository phoneContactRepository) {
        this.phoneContactRepository = phoneContactRepository;
    }

    public PhoneContactResponse execute(PhoneContactId id) {
        var phoneContact = phoneContactRepository.findById(id)
                .orElseThrow(() -> new PhoneContactNotFoundApplicationException(id.value().toString()));

        return new PhoneContactResponse(
            phoneContact.id().value(),
            phoneContact.contactId().value(),
            phoneContact.phone(),
            phoneContact.notes()
        );
    }
}
