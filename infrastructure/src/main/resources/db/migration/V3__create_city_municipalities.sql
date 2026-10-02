CREATE TABLE city_municipalities (
    id          UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name_city   VARCHAR(50),
    code_city   VARCHAR(10),
    description VARCHAR(100),
    is_active   BOOLEAN DEFAULT TRUE,
    region_id   UUID NOT NULL,
    created_at  TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at  TIMESTAMP,
    CONSTRAINT fk_city_municipalities_region_id FOREIGN KEY (region_id) REFERENCES state_regions (id)
);
