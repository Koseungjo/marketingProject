package com.example.marketing.project.service;

import com.example.marketing.project.dto.*;
import com.example.marketing.project.entity.MarketingProject;
import com.example.marketing.project.repository.MarketingProjectRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class MarketingProjectCUDService {

    private final MarketingProjectRepository marketingProjectRepository;
    public CreateMarketingProjectResponse createMarketingProject(CreateMarketingProjectRequest request) {
        MarketingProject entity = MarketingProject.toEntity(request);
        return new CreateMarketingProjectResponse(marketingProjectRepository.save(entity));
    }


    public MarketingProjectResponseList getMarketingProjectList(MarketingProjectSearchRequest request, Pageable pageable) {
        List<MarketingProject> entityList = marketingProjectRepository.findAllByProjectNameAndStatus(pageable, request.getProjectName(), request.getStatus());
        List<MarketingProjectResponse> responses = entityList.stream().map(MarketingProjectResponse::new).collect(Collectors.toList());
        return MarketingProjectResponseList.create(responses);
    }

    public MarketingProjectDetailResponse getMarketingProjectDetail(Long id) {
        MarketingProject entity = marketingProjectRepository.findByProjectId(id).orElseThrow(
                () -> new NoSuchElementException("존재하지 않는 프로젝트 입니다.")
        );
        return MarketingProjectDetailResponse.toDto(entity);
    }
}
