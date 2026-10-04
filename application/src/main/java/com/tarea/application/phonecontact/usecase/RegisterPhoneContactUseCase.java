package com.tarea.application.phonecontact.usecase;

import com.tarea.application.phonecontact.command.RegisterPhoneContactCommand;
import com.tarea.application.phonecontact.dto.PhoneContactResponse;
import com.tarea.domain.phonecontact.model.aggregate.PhoneContact;
import com.tarea.domain.phonecontact.port.repository.PhoneContactRepository;

public class RegisterPhoneContactUseCase {

    private final PhoneContactRepository phoneContactRepository;

    public RegisterPhoneContactUseCase(PhoneContactRepository phoneContactRepository) {
        this.phoneContactRepository = phoneContactRepository;
    }

    public PhoneContactResponse execute(RegisterPhoneContactCommand command) {
        PhoneContact phoneContact = PhoneContact.register(
                command.contactId(),
                command.phone(),
                command.notes()
        );

        PhoneContact saved = phoneContactRepository.save(phoneContact);

        return new PhoneContactResponse(
            saved.id().value(),
            saved.contactId().value(),
            saved.phone(),
            saved.notes()
        );
    }
}
