package com.example.marketing.project.controller;

import com.example.marketing.project.dto.*;
import com.example.marketing.project.service.MarketingProjectCUDService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MarketingProjectApiController {
    private final MarketingProjectCUDService marketingProjectCUDService;

    @PostMapping("/marketingProject")
    public ResponseEntity<CreateMarketingProjectResponse> createMarketingProject(@RequestBody CreateMarketingProjectRequest request){
        CreateMarketingProjectResponse response = marketingProjectCUDService.createMarketingProject(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/marketingProjects")
    public ResponseEntity<MarketingProjectResponseList> getMarketingProjectList(@RequestBody MarketingProjectSearchRequest request, Pageable pageable){
        MarketingProjectResponseList response = marketingProjectCUDService.getMarketingProjectList(request,pageable);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/marketingProject/{id}")
    public ResponseEntity<MarketingProjectDetailResponse> getMarketingProjectDetail(@PathVariable Long id){
        MarketingProjectDetailResponse response = marketingProjectCUDService.getMarketingProjectDetail(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
