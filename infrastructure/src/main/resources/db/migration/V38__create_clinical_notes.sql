CREATE TABLE clinical_notes (
    id               UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    encounter_id     UUID NOT NULL,
    professional_id  UUID NOT NULL,
    subjective       TEXT,
    objective        TEXT,
    assessment       TEXT,
    plan             TEXT,
    additional_notes TEXT,
    signed_at        TIMESTAMP,
    created_at       TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at       TIMESTAMP,
    CONSTRAINT fk_clinical_notes_encounter_id FOREIGN KEY (encounter_id) REFERENCES encounters (id),
    CONSTRAINT fk_clinical_notes_professional_id FOREIGN KEY (professional_id) REFERENCES professionals (id)
);
