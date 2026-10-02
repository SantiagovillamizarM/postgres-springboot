CREATE TABLE provider_models_ai (
    id               UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name_provider_ai VARCHAR(100),
    razon_social     VARCHAR,
    sitio_web        TEXT,
    is_active        BOOLEAN DEFAULT TRUE,
    created_at       TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at       TIMESTAMP
);
