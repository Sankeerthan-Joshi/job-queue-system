-- changeset sankeerthan:1
CREATE TABLE job (
    id VARCHAR(255) PRIMARY KEY,
    `name` VARCHAR(255) NOT NULL,
    payload TEXT,
    `status` VARCHAR(50) NOT NULL,
    retry_count INT DEFAULT 0,
    max_retries INT DEFAULT 5,
    next_run_at TIMESTAMP,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);