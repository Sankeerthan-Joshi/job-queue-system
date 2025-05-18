package com.example.job_queue_system.job.service;

import com.example.job_queue_system.job.data.JobPayload;
import com.example.job_queue_system.job.data.JobResponse;

public interface JobService {
    // This class will handle the business logic for job management
    // It will include methods to create, update, delete, and retrieve jobs

    public JobResponse createJob(JobPayload jobPayload);

    public JobResponse updateJob(String jobId, JobPayload jobPayload);

    public JobResponse deleteJob(String jobId);
}
