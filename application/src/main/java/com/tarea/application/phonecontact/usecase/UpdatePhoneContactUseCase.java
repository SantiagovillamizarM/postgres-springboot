package com.tarea.application.phonecontact.usecase;

import com.tarea.application.phonecontact.command.UpdatePhoneContactCommand;
import com.tarea.application.phonecontact.dto.PhoneContactResponse;
import com.tarea.application.phonecontact.exception.PhoneContactNotFoundApplicationException;
import com.tarea.domain.phonecontact.port.repository.PhoneContactRepository;

public class UpdatePhoneContactUseCase {

    private final PhoneContactRepository phoneContactRepository;

    public UpdatePhoneContactUseCase(PhoneContactRepository phoneContactRepository) {
        this.phoneContactRepository = phoneContactRepository;
    }

    public PhoneContactResponse execute(UpdatePhoneContactCommand command) {
        var phoneContact = phoneContactRepository.findById(command.id())
                .orElseThrow(() -> new PhoneContactNotFoundApplicationException(command.id().value().toString()));

        phoneContact.update(
                command.contactId(),
                command.phone(),
                command.notes()
        );

        var updated = phoneContactRepository.save(phoneContact);

        return new PhoneContactResponse(
            updated.id().value(),
            updated.contactId().value(),
            updated.phone(),
            updated.notes()
        );
    }
}
