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
public class CreateMarketingProjectResponse {
    private String projectName;

    public CreateMarketingProjectResponse(MarketingProject marketingProject){
        this.projectName = marketingProject.getProjectName();
    }
}
