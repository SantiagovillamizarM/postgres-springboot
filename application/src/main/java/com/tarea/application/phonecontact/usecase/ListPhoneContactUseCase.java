package com.tarea.application.phonecontact.usecase;

import com.tarea.application.phonecontact.dto.PhoneContactResponse;
import com.tarea.domain.phonecontact.port.repository.PhoneContactRepository;

import java.util.List;

public class ListPhoneContactUseCase {

    private final PhoneContactRepository phoneContactRepository;

    public ListPhoneContactUseCase(PhoneContactRepository phoneContactRepository) {
        this.phoneContactRepository = phoneContactRepository;
    }

    public List<PhoneContactResponse> execute() {
        return phoneContactRepository.findAll().stream()
                .map(phoneContact -> new PhoneContactResponse(
                    phoneContact.id().value(),
                    phoneContact.contactId().value(),
                    phoneContact.phone(),
                    phoneContact.notes()
                ))
                .toList();
    }
}
