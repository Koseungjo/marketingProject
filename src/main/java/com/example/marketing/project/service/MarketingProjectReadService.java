package com.example.marketing.project.service;

import com.example.marketing.project.dto.*;
import com.example.marketing.project.entity.MarketingProject;
import com.example.marketing.project.global.ResponseCodeEnum;
import com.example.marketing.project.repository.MarketingProjectRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class MarketingProjectReadService {

    private final MarketingProjectRepository marketingProjectRepository;

    public ResponseDTO getMarketingProjectList(MarketingProjectSearchRequest request, Pageable pageable) {
        List<MarketingProject> marketingProjectList = marketingProjectRepository.findAllByProjectNameAndStatus(pageable, request.getProjectName(), request.getStatus());
        List<MarketingProjectResponse> responses = marketingProjectList.stream().map(item -> MarketingProjectResponse.of(item)).collect(Collectors.toList());
        return ResponseDTO.ok(responses);
    }

    public ResponseDTO getMarketingProjectDetail(Long projectId) {
        MarketingProject marketingProject = marketingProjectRepository.findByProjectId(projectId).orElse(null);

        if (marketingProject == null)
            throw new NoSuchElementException("존재하지 않는 프로젝트 입니다.");

        return ResponseDTO.ok(MarketingProjectDetailResponse.of(marketingProject));
    }
}
