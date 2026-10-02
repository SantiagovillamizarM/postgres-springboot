CREATE TABLE diagnostic_systems (
    id         UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    code       VARCHAR(20) NOT NULL UNIQUE,
    name       VARCHAR(50),
    active     BOOLEAN DEFAULT TRUE,
    version    VARCHAR(20),
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP
);
