CREATE TABLE chat_escalation_status_history (
    id                   UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    escalation_id        UUID NOT NULL,
    escalation_status_id UUID NOT NULL,
    created_at           TIMESTAMP NOT NULL DEFAULT NOW(),
    changed_at           TIMESTAMP,
    CONSTRAINT fk_chat_escalation_status_history_escalation_id FOREIGN KEY (escalation_id) REFERENCES chat_escalations (id),
    CONSTRAINT fk_chat_escalation_status_history_escalation_status_id FOREIGN KEY (escalation_status_id) REFERENCES escalations_statuses (id)
);
