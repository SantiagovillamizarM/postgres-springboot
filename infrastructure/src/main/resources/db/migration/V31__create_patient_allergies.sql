CREATE TABLE patient_allergies (
    id          UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    patient_id  UUID NOT NULL,
    substance   VARCHAR(200),
    reaction    TEXT,
    severity    VARCHAR(20),
    active      BOOLEAN DEFAULT TRUE,
    recorded_at TIMESTAMP,
    recorded_by UUID,
    created_at  TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at  TIMESTAMP,
    CONSTRAINT fk_patient_allergies_patient_id FOREIGN KEY (patient_id) REFERENCES patients (id)
);
