package com.example.marketing.project.service;

import com.example.marketing.project.dto.*;
import com.example.marketing.project.entity.MarketingProject;
import com.example.marketing.project.global.MarketingProjectEnum;
import com.example.marketing.project.global.ResponseCodeEnum;
import com.example.marketing.project.repository.MarketingProjectRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class MarketingProjectCUDService {

    private final MarketingProjectRepository marketingProjectRepository;
    public ResponseDTO createMarketingProject(CreateMarketingProjectRequest request) {
        MarketingProject marketingProject = MarketingProject.toEntity(request);
        marketingProject = marketingProjectRepository.save(marketingProject);
        return ResponseDTO.ok(CreateMarketingProjectResponse.of(marketingProject));
    }

    public ResponseDTO<MarketingProjectDetailResponse> startMarketingProject(Long projectId) {
        MarketingProject marketingProject = marketingProjectRepository.findByProjectIdAndStatus(projectId, MarketingProjectEnum.WAITING.getStatus()).orElse(null);
        if (marketingProject == null)
            throw new NoSuchElementException("대기중인 프로젝트가 존재하지 않습니다.");
        marketingProject.startProject();
        return ResponseDTO.ok(MarketingProjectDetailResponse.of(marketingProject));

    }

    public ResponseDTO<MarketingProjectDetailResponse> endMarketingProject(Long projectId) {
        MarketingProject marketingProject = marketingProjectRepository.findByProjectIdAndStatus(projectId, MarketingProjectEnum.COMPLETED.getStatus()).orElse(null);
        if (marketingProject == null)
            throw new NoSuchElementException("진행중인 프로젝트가 존재하지 않습니다.");
        marketingProject.endProject();
        return ResponseDTO.ok(MarketingProjectDetailResponse.of(marketingProject));
    }
}
