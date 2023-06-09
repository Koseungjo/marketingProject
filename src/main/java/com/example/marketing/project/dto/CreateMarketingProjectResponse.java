package com.example.marketing.project.dto;

import com.example.marketing.project.entity.MarketingProject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateMarketingProjectResponse {
    private Long projectId;
    private String projectName;

    private CreateMarketingProjectResponse(MarketingProject marketingProject){
        this.projectId = marketingProject.getProjectId();
        this.projectName = marketingProject.getProjectName();
    }

    public static CreateMarketingProjectResponse of(MarketingProject marketingProject){
        return new CreateMarketingProjectResponse(marketingProject);
    }
}
