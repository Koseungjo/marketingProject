package com.example.marketing.project.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@NoArgsConstructor
public class MarketingProjectResponseList {
    private List<MarketingProjectResponse> marketingProjectResponseList;

    private MarketingProjectResponseList(List<MarketingProjectResponse> responses) {
        this.marketingProjectResponseList = responses;
    }
    public static MarketingProjectResponseList of(List<MarketingProjectResponse> responses) {
        return new MarketingProjectResponseList(responses);
    }
}
