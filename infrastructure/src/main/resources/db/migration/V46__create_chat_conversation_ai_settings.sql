CREATE TABLE chat_conversation_ai_settings (
    id               UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    conversation_id  UUID NOT NULL,
    ai_enabled       BOOLEAN DEFAULT TRUE,
    default_model_id UUID NOT NULL,
    created_at       TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at       TIMESTAMP,
    CONSTRAINT fk_chat_conversation_ai_settings_conversation_id FOREIGN KEY (conversation_id) REFERENCES chat_conversations (id),
    CONSTRAINT fk_chat_conversation_ai_settings_default_model_id FOREIGN KEY (default_model_id) REFERENCES ai_models (id)
);
