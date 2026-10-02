CREATE TABLE treatment_plans (
    id                  UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    encounter_id        UUID NOT NULL,
    professional_id     UUID NOT NULL,
    title               VARCHAR(200),
    description         TEXT,
    start_date          DATE,
    end_date            DATE,
    treatment_status_id UUID NOT NULL,
    created_at          TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at          TIMESTAMP,
    CONSTRAINT fk_treatment_plans_encounter_id FOREIGN KEY (encounter_id) REFERENCES encounters (id),
    CONSTRAINT fk_treatment_plans_professional_id FOREIGN KEY (professional_id) REFERENCES professionals (id),
    CONSTRAINT fk_treatment_plans_treatment_status_id FOREIGN KEY (treatment_status_id) REFERENCES treatment_statusses (id)
);
