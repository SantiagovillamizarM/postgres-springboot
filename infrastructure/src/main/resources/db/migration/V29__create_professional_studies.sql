CREATE TABLE professional_studies (
    id                UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    study_id          UUID NOT NULL,
    professional_id   UUID NOT NULL,
    title             VARCHAR(100),
    university        VARCHAR(100),
    is_valid          BOOLEAN DEFAULT FALSE,
    resolution_number VARCHAR(60),
    country_id        UUID NOT NULL,
    created_at        TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at        TIMESTAMP,
    CONSTRAINT fk_professional_studies_study_id FOREIGN KEY (study_id) REFERENCES studies (id),
    CONSTRAINT fk_professional_studies_professional_id FOREIGN KEY (professional_id) REFERENCES professionals (id),
    CONSTRAINT fk_professional_studies_country_id FOREIGN KEY (country_id) REFERENCES countries (id)
);
