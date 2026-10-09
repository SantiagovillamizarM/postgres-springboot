CREATE TABLE users (
    id              UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    email           VARCHAR(150) NOT NULL UNIQUE,
    password_hash   VARCHAR(100) NOT NULL,
    role            VARCHAR(20)  NOT NULL,
    professional_id UUID,
    active          BOOLEAN      NOT NULL DEFAULT TRUE,
    created_at      TIMESTAMP    NOT NULL DEFAULT NOW(),
    updated_at      TIMESTAMP,
    CONSTRAINT ck_users_role CHECK (role IN ('ADMIN', 'PROFESSIONAL')),
    CONSTRAINT fk_users_professional_id FOREIGN KEY (professional_id) REFERENCES professionals (id)
);
