package com.example.marketing.project.controller;

import com.example.marketing.project.dto.*;
import com.example.marketing.project.service.MarketingProjectCUDService;
import com.example.marketing.project.service.MarketingProjectReadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/")
public class MarketingProjectApiController {
    private final MarketingProjectCUDService marketingProjectCUDService;
    private final MarketingProjectReadService marketingProjectReadService;

    @PostMapping("/marketing/project")
    public ResponseEntity<ResponseDTO> createMarketingProject(@RequestBody CreateMarketingProjectRequest request){
        ResponseDTO<CreateMarketingProjectResponse> response = marketingProjectCUDService.createMarketingProject(request);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/marketing/projects")
    public ResponseEntity<ResponseDTO> getMarketingProjectList(@ModelAttribute MarketingProjectSearchRequest request, Pageable pageable){
        ResponseDTO<MarketingProjectResponseList> response = marketingProjectReadService.getMarketingProjectList(request,pageable);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/marketing/project/{projectId}")
    public ResponseEntity<ResponseDTO> getMarketingProjectDetail(@PathVariable Long projectId){
        ResponseDTO<MarketingProjectDetailResponse> response = marketingProjectReadService.getMarketingProjectDetail(projectId);
        return ResponseEntity.ok().body(response);
    }

    @PatchMapping("/marketing/project/{projectId}/start")
    public ResponseEntity<ResponseDTO> startMarketingProject(@PathVariable Long projectId){
        ResponseDTO<MarketingProjectDetailResponse> response = marketingProjectCUDService.startMarketingProject(projectId);
        return ResponseEntity.ok().body(response);
    }

    @PatchMapping("/marketing/project/{projectId}/end")
    public ResponseEntity<ResponseDTO> endMarketingProject(@PathVariable Long projectId){
        ResponseDTO<MarketingProjectDetailResponse> response = marketingProjectCUDService.endMarketingProject(projectId);
        return ResponseEntity.ok().body(response);
    }
}
