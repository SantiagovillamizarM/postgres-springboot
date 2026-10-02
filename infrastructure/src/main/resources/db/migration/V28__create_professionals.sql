CREATE TABLE professionals (
    id                UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    document_type_id  UUID NOT NULL,
    document_number   VARCHAR(30) NOT NULL UNIQUE,
    first_name        VARCHAR(60),
    last_name         VARCHAR(60),
    professional_type UUID NOT NULL,
    license_number    VARCHAR(100) NOT NULL UNIQUE,
    active            BOOLEAN DEFAULT TRUE,
    city_id           UUID NOT NULL,
    created_at        TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at        TIMESTAMP,
    CONSTRAINT fk_professionals_document_type_id FOREIGN KEY (document_type_id) REFERENCES document_types (id),
    CONSTRAINT fk_professionals_professional_type FOREIGN KEY (professional_type) REFERENCES professional_types (id),
    CONSTRAINT fk_professionals_city_id FOREIGN KEY (city_id) REFERENCES city_municipalities (id)
);
