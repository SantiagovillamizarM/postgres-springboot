CREATE TABLE treatment_goals (
    id                UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    treatment_plan_id UUID NOT NULL,
    description       TEXT,
    target_date       DATE,
    completed_at      TIMESTAMP,
    notes             TEXT,
    treatment_goal_id UUID NOT NULL,
    created_at        TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at        TIMESTAMP,
    CONSTRAINT fk_treatment_goals_treatment_plan_id FOREIGN KEY (treatment_plan_id) REFERENCES treatment_plans (id),
    CONSTRAINT fk_treatment_goals_treatment_goal_id FOREIGN KEY (treatment_goal_id) REFERENCES treatment_goal_statusses (id)
);
