CREATE TABLE chat_ai_run_metrics (
    id                UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    ai_run_id         UUID NOT NULL,
    prompt_tokens     INTEGER,
    completion_tokens INTEGER,
    total_tokens      INTEGER,
    cost              DECIMAL(10,6),
    created_at        TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_chat_ai_run_metrics_ai_run_id FOREIGN KEY (ai_run_id) REFERENCES chat_ai_runs (id)
);
