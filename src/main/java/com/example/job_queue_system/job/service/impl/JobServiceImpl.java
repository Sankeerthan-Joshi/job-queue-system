package com.example.job_queue_system.job.service.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

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
                .maxRetries(jobPayload.getNoOfRetires())
                .payload(jobPayload.getJobMetadata())
                .build();
        job = jobRepository.save(job);
        return JobResponse.builder()
                .jobId(String.valueOf(job.getId()))
                .build();
        
    }

    @Override
    public JobResponse updateJob(String jobId, JobPayload jobPayload) {
        Job job = jobRepository.findById(UUID.fromString(jobId));
        if (job == null) {
            throw new IllegalArgumentException("Job not found");
        }
        if(job.getStatus() != null){

            job.setName(jobPayload.getJobName());
        }

        if(job.getName() != null){

            job.setName(jobPayload.getJobName());
        }

        if(job.getMaxRetries() != null){

            job.setMaxRetries(jobPayload.getNoOfRetires());
        }
        if(job.getPayload() != null){

            job.setPayload(jobPayload.getJobMetadata());
        }
        job = jobRepository.save(job);
        return JobResponse.builder()
                .jobId(String.valueOf(job.getId()))
                .build();
    }

    @Override
    public JobResponse deleteJob(Long jobId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteJob'");
    }
    
}
