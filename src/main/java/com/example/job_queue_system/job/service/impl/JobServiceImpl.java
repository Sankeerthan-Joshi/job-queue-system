package com.example.job_queue_system.job.service.impl;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.job_queue_system.common.exception.CustomBadRequestException;
import com.example.job_queue_system.job.data.JobPayload;
import com.example.job_queue_system.job.data.JobResponse;
import com.example.job_queue_system.job.domain.Job;
import com.example.job_queue_system.job.domain.JobRepositoryWrapper;
import com.example.job_queue_system.job.service.JobService;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepositoryWrapper jobRepository;

    public JobServiceImpl(JobRepositoryWrapper jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public JobResponse createJob(JobPayload jobPayload) {
        // Implementation for creating a job
        Job job = Job.builder()
                .name(jobPayload.getJobName())
                .maxRetries(jobPayload.getNoOfRetries())
                .payload(jobPayload.getJobMetadata())
                .build();
        try {
            job = jobRepository.save(job);

        } catch (DataIntegrityViolationException e) {
            throw new CustomBadRequestException("Job with the same name already exists");
        }
        return JobResponse.builder()
                .jobId(job.getId())
                .build();
        
    }

    @Override
    public JobResponse updateJob(String jobId, JobPayload jobPayload) {
        Job job = jobRepository.findById(jobId);
        if (job == null) {
            throw new CustomBadRequestException("Job not found");
        }

        if (jobPayload.getJobName() != null) {

            job.setName(jobPayload.getJobName());
        }

        if (jobPayload.getNoOfRetries() != null) {

            job.setMaxRetries(jobPayload.getNoOfRetries());
        }
        if (jobPayload.getJobMetadata() != null) {

            job.setPayload(jobPayload.getJobMetadata());
        }
        job = jobRepository.save(job);
        return JobResponse.builder()
                .jobId(job.getId())
                .build();
    }

    @Override
    public JobResponse deleteJob(String jobId) {
        Job job = jobRepository.findById(jobId);
        if (job == null) {
            throw new CustomBadRequestException("Job not found");
        }
        jobRepository.delete(job);
        return JobResponse.builder()
                .jobId(jobId)
                .build();
    }
    
}
