package com.example.job_queue_system.job.domain;

import org.springframework.stereotype.Service;

@Service
public class JobRepositoryWrapper {
    
    private final JobRepository jobRepository;

    public JobRepositoryWrapper(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public Job save(Job job) {
        return jobRepository.save(job);
    }

    public Job findById(String id) {
        return jobRepository.findById(id).orElse(null);
    }

    public void delete(Job job) {
        jobRepository.delete(job);
    }
}
