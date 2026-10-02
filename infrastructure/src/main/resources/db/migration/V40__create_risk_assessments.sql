CREATE TABLE risk_assessments (
    id                 UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    encounter_id       UUID NOT NULL,
    risk_level_id      UUID NOT NULL,
    suicidal_ideation  BOOLEAN DEFAULT FALSE,
    suicide_plan       BOOLEAN DEFAULT FALSE,
    suicide_intent     BOOLEAN DEFAULT FALSE,
    self_harm          BOOLEAN DEFAULT FALSE,
    harm_to_others     BOOLEAN DEFAULT FALSE,
    risk_factors       TEXT,
    protective_factors TEXT,
    clinical_actions   TEXT,
    observations       TEXT,
    assessed_at        TIMESTAMP,
    assessed_by        UUID NOT NULL,
    CONSTRAINT fk_risk_assessments_encounter_id FOREIGN KEY (encounter_id) REFERENCES encounters (id),
    CONSTRAINT fk_risk_assessments_risk_level_id FOREIGN KEY (risk_level_id) REFERENCES risk_levels (id),
    CONSTRAINT fk_risk_assessments_assessed_by FOREIGN KEY (assessed_by) REFERENCES professionals (id)
);
