package com.example.marketing.project.dto;

import com.example.marketing.project.entity.MarketingProject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MarketingProjectResponse {
    private String projectName;
    private String status;

    public MarketingProjectResponse(MarketingProject marketingProject){
        this.projectName = marketingProject.getProjectName();
        this.status = marketingProject.getStatus();
    }
}
