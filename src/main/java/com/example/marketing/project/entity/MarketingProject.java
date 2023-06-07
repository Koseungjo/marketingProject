package com.example.marketing.project.entity;

import com.example.marketing.project.dto.CreateMarketingProjectRequest;
import com.example.marketing.project.global.MarketingProjectEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "marketing_project")
public class MarketingProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long projectId;

    @Column(name = "project_name")
    private String projectName;
    @Column(name = "content")
    private String content;
    @Column(name = "start_date")
    private LocalDateTime startDate;
    @Column(name = "end_date")
    private LocalDateTime endDate;
    @Column(name = "status")
    private String status;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    @CreationTimestamp
    private LocalDateTime updatedAt;

    public static MarketingProject toEntity(CreateMarketingProjectRequest request) {
        return MarketingProject.builder()
                .projectName(request.getProjectName())
                .content(request.getContent())
                .status(MarketingProjectEnum.WAITING.getStatus())
                .build();
    }

    public void startProject() {
        this.startDate = LocalDateTime.now();
    }
}
