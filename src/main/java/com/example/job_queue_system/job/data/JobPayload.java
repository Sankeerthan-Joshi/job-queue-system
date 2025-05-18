package com.example.job_queue_system.job.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobPayload {

    private String jobName;
    private String jobMetadata;
    private Integer noOfRetries;

    
}
