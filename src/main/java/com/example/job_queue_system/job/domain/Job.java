package com.example.job_queue_system.job.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import com.example.job_queue_system.common.Auditable;
import com.example.job_queue_system.job.data.JobStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "job")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Job extends Auditable {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    @Lob
    private String payload;

    @Enumerated(EnumType.STRING)
    @Default
    private JobStatus status = JobStatus.PENDING;

    private Integer retryCount;

    private Integer maxRetries;

    private LocalDateTime nextRunAt;

}