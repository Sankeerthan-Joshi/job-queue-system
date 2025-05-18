-- changeset sankeerthan:3
-- modify job table for unque name
ALTER TABLE job
ADD CONSTRAINT unique_job_name UNIQUE (name);
