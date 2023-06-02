package com.example.marketing.project.dto;

import com.example.marketing.project.entity.MarketingProject;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MarketingProjectDetailResponse {
    private String projectName;
    private String content;
    private String status;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public static MarketingProjectDetailResponse toDto(MarketingProject marketingProject){
        return MarketingProjectDetailResponse.builder()
                .projectName(marketingProject.getProjectName())
                .content(marketingProject.getContent())
                .status(marketingProject.getStatus())
                .startDate(marketingProject.getStartDate())
                .endDate(marketingProject.getEndDate())
                .build();
    }
}
