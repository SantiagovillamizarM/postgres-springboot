CREATE TABLE chat_escalation_assignments (
    id              UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    escalation_id   UUID NOT NULL,
    professional_id UUID NOT NULL,
    assigned_at     TIMESTAMP,
    CONSTRAINT fk_chat_escalation_assignments_escalation_id FOREIGN KEY (escalation_id) REFERENCES chat_escalations (id),
    CONSTRAINT fk_chat_escalation_assignments_professional_id FOREIGN KEY (professional_id) REFERENCES professionals (id)
);
