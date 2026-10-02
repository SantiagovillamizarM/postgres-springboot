CREATE TABLE patient_contacts (
    id                   UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    contact_id           UUID NOT NULL,
    patient_id           UUID NOT NULL,
    is_primary_contact   BOOLEAN DEFAULT FALSE,
    is_emergency_contact BOOLEAN DEFAULT FALSE,
    relationship_type_id UUID NOT NULL,
    CONSTRAINT fk_patient_contacts_contact_id FOREIGN KEY (contact_id) REFERENCES contacts (id),
    CONSTRAINT fk_patient_contacts_patient_id FOREIGN KEY (patient_id) REFERENCES patients (id),
    CONSTRAINT fk_patient_contacts_relationship_type_id FOREIGN KEY (relationship_type_id) REFERENCES relationship_types (id)
);
