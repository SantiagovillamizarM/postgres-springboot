CREATE TABLE ai_models (
    id                 UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    provider_model_id  UUID NOT NULL,
    name_model         VARCHAR(100),
    model_key          VARCHAR(120),
    input_token_price  DECIMAL(12,8),
    output_token_price DECIMAL(12,8),
    max_tokens         INTEGER,
    context_window     INTEGER,
    is_active          BOOLEAN DEFAULT TRUE,
    created_at         TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at         TIMESTAMP,
    CONSTRAINT fk_ai_models_provider_model_id FOREIGN KEY (provider_model_id) REFERENCES provider_models_ai (id)
);
