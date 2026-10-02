CREATE TABLE email_contacts (
    id         UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    contact_id UUID NOT NULL,
    email      VARCHAR(150) NOT NULL UNIQUE,
    notes      TEXT,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP,
    CONSTRAINT fk_email_contacts_contact_id FOREIGN KEY (contact_id) REFERENCES contacts (id)
);
