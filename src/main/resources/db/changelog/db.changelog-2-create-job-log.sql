-- changeset sankeerthan:2
CREATE TABLE job_log (
    id BIGINT PRIMARY KEY,
    job_id VARCHAR(255) REFERENCES job(id),
    `status` VARCHAR(50) NOT NULL,
    error_message TEXT,
    execution_time INT,
    created_at TIMESTAMP DEFAULT NOW()
);