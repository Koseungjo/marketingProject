package com.example.marketing.project.service;

import com.example.marketing.project.dto.*;
import com.example.marketing.project.entity.MarketingProject;
import com.example.marketing.project.global.ResponseCodeEnum;
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
    public ResponseDTO createMarketingProject(CreateMarketingProjectRequest request) {
        MarketingProject entity = MarketingProject.toEntity(request);
        entity = marketingProjectRepository.save(entity);
        return ResponseDTO.success(ResponseCodeEnum.CREATED.getCode(),ResponseCodeEnum.CREATED.getMessage(), CreateMarketingProjectResponse.of(entity));
    }

//    public ResponseDTO<MarketingProjectDetailResponse> startMarketingProject(Long id) {
//        MarketingProject marketingProject = marketingProjectRepository.findByProjectIdAndStatus(id).orElse(null);
//
//        if (marketingProject == null)
//            return ResponseDTO.fail(ResponseCodeEnum.BAD_REQUEST.getCode(), ResponseCodeEnum.BAD_REQUEST.getMessage());
//
//        marketingProject.startProject();
//
//        return ResponseDTO.success(ResponseCodeEnum.OK.getCode(), ResponseCodeEnum.OK.getMessage(), MarketingProjectDetailResponse.toDto(marketingProject));
//
//    }
}
