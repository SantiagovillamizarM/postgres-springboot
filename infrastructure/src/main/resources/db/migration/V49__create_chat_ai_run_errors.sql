CREATE TABLE chat_ai_run_errors (
    id                UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    ai_run_id         UUID NOT NULL,
    error_message     TEXT,
    error_code        VARCHAR(80),
    provider_error_id VARCHAR(120),
    created_at        TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_chat_ai_run_errors_ai_run_id FOREIGN KEY (ai_run_id) REFERENCES chat_ai_runs (id)
);
