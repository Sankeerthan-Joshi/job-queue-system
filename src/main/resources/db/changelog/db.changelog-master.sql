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
