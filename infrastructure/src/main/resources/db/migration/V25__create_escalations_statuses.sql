CREATE TABLE escalations_statuses (
    id          UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name_status VARCHAR(50),
    created_at  TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at  TIMESTAMP
);
