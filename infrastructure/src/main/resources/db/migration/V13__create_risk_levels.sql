CREATE TABLE risk_levels (
    id         UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    code       VARCHAR(20) NOT NULL UNIQUE,
    name       VARCHAR(50),
    active     BOOLEAN DEFAULT TRUE,
    severity   INTEGER,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP
);
