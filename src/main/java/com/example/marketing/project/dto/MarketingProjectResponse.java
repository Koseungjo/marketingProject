package com.example.marketing.project.dto;

import com.example.marketing.project.entity.MarketingProject;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MarketingProjectResponse {
    private String projectName;
    private String status;

    private MarketingProjectResponse(MarketingProject marketingProject){
        this.projectName = marketingProject.getProjectName();
        this.status = marketingProject.getStatus();
    }

    public static MarketingProjectResponse of(MarketingProject marketingProject){
       return new MarketingProjectResponse(marketingProject);
    }

}
