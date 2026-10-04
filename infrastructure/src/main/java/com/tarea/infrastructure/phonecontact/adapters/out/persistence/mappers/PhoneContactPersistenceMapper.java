package com.tarea.infrastructure.phonecontact.adapters.out.persistence.mappers;

import com.tarea.domain.contact.model.valueobject.ContactId;
import com.tarea.domain.phonecontact.model.aggregate.PhoneContact;
import com.tarea.domain.phonecontact.model.valueobject.PhoneContactId;
import com.tarea.infrastructure.phonecontact.adapters.out.persistence.entity.PhoneContactJpaEntity;

public class PhoneContactPersistenceMapper {

    public PhoneContactJpaEntity toJpa(PhoneContact domain) {
        if (domain == null) {
            return null;
        }

        PhoneContactJpaEntity jpa = new PhoneContactJpaEntity();
        jpa.setId(domain.id().value());
        jpa.setContactId(domain.contactId().value());
        jpa.setPhone(domain.phone());
        jpa.setNotes(domain.notes());
        return jpa;
    }

    public PhoneContact toDomain(PhoneContactJpaEntity jpa) {
        if (jpa == null) {
            return null;
        }

        return PhoneContact.restore(
                new PhoneContactId(jpa.getId()),
                new ContactId(jpa.getContactId()),
                jpa.getPhone(),
                jpa.getNotes()
        );
    }
}
