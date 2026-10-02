CREATE TABLE clinical_records (
    id            UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    patient_id    UUID NOT NULL,
    creation_date TIMESTAMP,
    record_number VARCHAR(50),
    opened_at     TIMESTAMP,
    closed_at     TIMESTAMP,
    status_id     UUID NOT NULL,
    created_at    TIMESTAMP NOT NULL DEFAULT NOW(),
    created_by    UUID NOT NULL,
    CONSTRAINT fk_clinical_records_patient_id FOREIGN KEY (patient_id) REFERENCES patients (id),
    CONSTRAINT fk_clinical_records_status_id FOREIGN KEY (status_id) REFERENCES clinical_record_statusses (id),
    CONSTRAINT fk_clinical_records_created_by FOREIGN KEY (created_by) REFERENCES professionals (id)
);
