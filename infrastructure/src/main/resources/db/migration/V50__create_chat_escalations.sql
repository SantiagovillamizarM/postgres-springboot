CREATE TABLE chat_escalations (
    id              UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    conversation_id UUID NOT NULL,
    status_id       UUID NOT NULL,
    from_ai         BOOLEAN DEFAULT FALSE,
    reason          TEXT,
    created_at      TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_chat_escalations_conversation_id FOREIGN KEY (conversation_id) REFERENCES chat_conversations (id),
    CONSTRAINT fk_chat_escalations_status_id FOREIGN KEY (status_id) REFERENCES escalations_statuses (id)
);
