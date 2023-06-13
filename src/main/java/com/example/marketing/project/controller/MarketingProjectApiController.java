package com.example.marketing.project.controller;

import com.example.marketing.global.ResponseDTO;
import com.example.marketing.project.dto.*;
import com.example.marketing.project.service.MarketingProjectCUDService;
import com.example.marketing.project.service.MarketingProjectReadService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/")
public class MarketingProjectApiController {
    private final MarketingProjectCUDService marketingProjectCUDService;
    private final MarketingProjectReadService marketingProjectReadService;

    @PostMapping("/marketing/project")
    public ResponseDTO<CreateMarketingProjectResponse> createMarketingProject(@RequestBody @Valid CreateMarketingProjectRequest request){
        CreateMarketingProjectResponse response = marketingProjectCUDService.createMarketingProject(request);
        return ResponseDTO.ok(response);
    }

    @GetMapping("/marketing/projects")
    public ResponseDTO<MarketingProjectResponseList> getMarketingProjectList(@ModelAttribute MarketingProjectSearchRequest request, Pageable pageable){
        MarketingProjectResponseList response = marketingProjectReadService.getMarketingProjectList(request,pageable);
        return ResponseDTO.ok(response);
    }

    @GetMapping("/marketing/project/{projectId}")
    public ResponseDTO<MarketingProjectDetailResponse> getMarketingProjectDetail(@PathVariable Long projectId){
        MarketingProjectDetailResponse response = marketingProjectReadService.getMarketingProjectDetail(projectId);
        return ResponseDTO.ok(response);
    }

    @PatchMapping("/marketing/project/{projectId}/start")
    public ResponseDTO<MarketingProjectDetailResponse> startMarketingProject(@PathVariable Long projectId){
        MarketingProjectDetailResponse response = marketingProjectCUDService.startMarketingProject(projectId);
        return ResponseDTO.ok(response);
    }

    @PatchMapping("/marketing/project/{projectId}/end")
    public ResponseDTO<MarketingProjectDetailResponse> endMarketingProject(@PathVariable Long projectId){
        MarketingProjectDetailResponse response = marketingProjectCUDService.endMarketingProject(projectId);
        return ResponseDTO.ok(response);
    }
}
