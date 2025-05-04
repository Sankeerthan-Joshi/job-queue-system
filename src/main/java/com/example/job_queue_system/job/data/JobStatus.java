package com.example.job_queue_system.job.data;

public enum JobStatus {
    PENDING,
    RUNNING,
    SUCCESS,
    FAILED,
    CANCELLED;

    public static JobStatus fromString(String status) {
        return JobStatus.valueOf(status.toUpperCase());
    }
    
}