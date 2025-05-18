package com.example.job_queue_system.job.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.job_queue_system.job.data.JobPayload;
import com.example.job_queue_system.job.data.JobResponse;
import com.example.job_queue_system.job.service.JobService;

@RestController
@RequestMapping("/job")
public class JobController {
    
    private final JobService jobService;
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    // Endpoint to create a job
    @PostMapping
    public JobResponse createJob(@RequestBody JobPayload job) {
        return jobService.createJob(job);
    }

    // Endpoint to update a job
    @PutMapping("/{jobId}")
    public JobResponse updateJob(@PathVariable String jobId, @RequestBody JobPayload job) {
        return jobService.updateJob(jobId, job);
    }

    // Endpoint to delete a job
    @DeleteMapping("/{jobId}")
    public void deleteJob(@PathVariable String jobId) {
        jobService.deleteJob(jobId);
    }
    
}
