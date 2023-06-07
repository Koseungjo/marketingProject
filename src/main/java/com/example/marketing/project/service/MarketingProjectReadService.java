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
        List<MarketingProject> entityList = marketingProjectRepository.findAllByProjectNameAndStatus(pageable, request.getProjectName(), request.getStatus());
        List<MarketingProjectResponse> responses = entityList.stream().map(MarketingProjectResponse::new).collect(Collectors.toList());
        return ResponseDTO.success(ResponseCodeEnum.OK.getCode(),ResponseCodeEnum.OK.getMessage(), responses);
    }

    public ResponseDTO getMarketingProjectDetail(Long id) {
        MarketingProject entity = marketingProjectRepository.findByProjectId(id).orElse(null);

        if (entity == null)
            return ResponseDTO.fail(ResponseCodeEnum.BAD_REQUEST.getCode(), ResponseCodeEnum.BAD_REQUEST.getMessage());

        return ResponseDTO.success(ResponseCodeEnum.OK.getCode(),ResponseCodeEnum.OK.getMessage(), MarketingProjectDetailResponse.toDto(entity));
    }
}
