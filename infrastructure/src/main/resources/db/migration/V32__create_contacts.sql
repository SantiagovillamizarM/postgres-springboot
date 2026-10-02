CREATE TABLE contacts (
    id         UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    full_name  VARCHAR(200),
    email      VARCHAR(150),
    notes      TEXT,
    city_id    UUID NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    created_by UUID NOT NULL,
    updated_at TIMESTAMP,
    updated_by UUID,
    CONSTRAINT fk_contacts_city_id FOREIGN KEY (city_id) REFERENCES city_municipalities (id),
    CONSTRAINT fk_contacts_created_by FOREIGN KEY (created_by) REFERENCES professionals (id),
    CONSTRAINT fk_contacts_updated_by FOREIGN KEY (updated_by) REFERENCES professionals (id)
);
