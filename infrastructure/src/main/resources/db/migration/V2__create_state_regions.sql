CREATE TABLE state_regions (
    id          UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name_region VARCHAR(50),
    code_region VARCHAR(10),
    description VARCHAR(100),
    is_active   BOOLEAN DEFAULT TRUE,
    country_id  UUID NOT NULL,
    created_at  TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at  TIMESTAMP,
    CONSTRAINT fk_state_regions_country_id FOREIGN KEY (country_id) REFERENCES countries (id)
);
