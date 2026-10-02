CREATE TABLE message_types (
    id         UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name_type  VARCHAR(50),
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP
);
