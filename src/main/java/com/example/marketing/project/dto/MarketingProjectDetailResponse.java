package com.example.marketing.project.dto;

import com.example.marketing.project.entity.MarketingProject;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MarketingProjectDetailResponse {
    private String projectName;
    private String content;
    private String status;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private MarketingProjectDetailResponse(MarketingProject marketingProject) {
       this.projectName = marketingProject.getProjectName();
       this.content = marketingProject.getContent();
       this.status = marketingProject.getStatus();
       this.startDate = marketingProject.getStartDate();
       this.endDate = marketingProject.getEndDate();
    }

    public static MarketingProjectDetailResponse of(MarketingProject marketingProject){
        return new MarketingProjectDetailResponse(marketingProject);
    }
}
