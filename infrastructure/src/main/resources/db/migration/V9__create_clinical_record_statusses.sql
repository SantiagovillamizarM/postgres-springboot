CREATE TABLE clinical_record_statusses (
    id         UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    code       VARCHAR(20) NOT NULL UNIQUE,
    name       VARCHAR(50) NOT NULL UNIQUE,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP
);
