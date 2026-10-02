CREATE TABLE countries (
    id               UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name_country     VARCHAR(50),
    code_country     VARCHAR(10),
    description      VARCHAR(100),
    is_active        BOOLEAN DEFAULT TRUE,
    telephone_prefix VARCHAR(5),
    created_at       TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at       TIMESTAMP
);
