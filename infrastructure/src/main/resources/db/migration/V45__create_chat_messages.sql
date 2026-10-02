CREATE TABLE chat_messages (
    id              UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    conversation_id UUID NOT NULL,
    message_type_id UUID NOT NULL,
    participant_id  UUID NOT NULL,
    content         JSONB,
    metadata        JSONB,
    created_at      TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_chat_messages_conversation_id FOREIGN KEY (conversation_id) REFERENCES chat_conversations (id),
    CONSTRAINT fk_chat_messages_message_type_id FOREIGN KEY (message_type_id) REFERENCES message_types (id),
    CONSTRAINT fk_chat_messages_participant_id FOREIGN KEY (participant_id) REFERENCES chat_participants (id)
);
