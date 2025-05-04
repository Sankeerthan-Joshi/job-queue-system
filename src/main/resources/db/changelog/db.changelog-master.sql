-- Liquibase SQL changelog example

-- ChangeSet: Unique identifier for each change
-- Format: -- changeset author:id

-- Create a table
-- changeset sankeerthan:1
CREATE TABLE job (
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(255) NOT NULL,
    `status` VARCHAR(50) NOT NULL,
    `description` TEXT NULL
);

-- changeset sankeerthan:2
DROP TABLE IF EXISTS job;
CREATE TABLE job (
    id PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    payload TEXT,
    status VARCHAR(50) NOT NULL,
    retry_count INT DEFAULT 0,
    max_retries INT DEFAULT 5,
    next_run_at TIMESTAMP,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE job_log (
    id BIGSERIAL PRIMARY KEY,
    job_id UUID REFERENCES job(id),
    status VARCHAR(50) NOT NULL,
    error_message TEXT,
    execution_time INT,
    created_at TIMESTAMP DEFAULT NOW()
);
