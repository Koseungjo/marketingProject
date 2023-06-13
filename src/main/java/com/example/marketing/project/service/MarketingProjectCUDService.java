package com.example.marketing.project.service;

import com.example.marketing.project.dto.*;
import com.example.marketing.project.entity.MarketingProject;
import com.example.marketing.project.global.MarketingProjectEnum;
import com.example.marketing.project.repository.MarketingProjectRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class MarketingProjectCUDService {

    private final MarketingProjectRepository marketingProjectRepository;
    public CreateMarketingProjectResponse createMarketingProject(CreateMarketingProjectRequest request) {
        MarketingProject marketingProject = MarketingProject.toEntity(request);
        marketingProject = marketingProjectRepository.save(marketingProject);
        return CreateMarketingProjectResponse.of(marketingProject);
    }

    public MarketingProjectDetailResponse startMarketingProject(Long projectId) {
        MarketingProject marketingProject = marketingProjectRepository.findByProjectIdAndStatus(projectId, MarketingProjectEnum.WAITING.getStatus()).orElse(null);
        if (marketingProject == null)
            throw new NoSuchElementException("대기중인 프로젝트가 존재하지 않습니다.");
        marketingProject.startProject();
        return MarketingProjectDetailResponse.of(marketingProject);

    }

    public MarketingProjectDetailResponse endMarketingProject(Long projectId) {
        MarketingProject marketingProject = marketingProjectRepository.findByProjectIdAndStatus(projectId, MarketingProjectEnum.IN_PROGRESS.getStatus()).orElse(null);
        if (marketingProject == null)
            throw new NoSuchElementException("진행중인 프로젝트가 존재하지 않습니다.");
        marketingProject.endProject();
        return MarketingProjectDetailResponse.of(marketingProject);
    }
}
