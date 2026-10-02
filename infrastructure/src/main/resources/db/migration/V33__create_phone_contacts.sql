CREATE TABLE phone_contacts (
    id         UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    contact_id UUID NOT NULL,
    phone      VARCHAR(30),
    notes      TEXT,
    CONSTRAINT fk_phone_contacts_contact_id FOREIGN KEY (contact_id) REFERENCES contacts (id)
);
