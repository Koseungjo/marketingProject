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
public class MarketingProjectApiController {
    private final MarketingProjectCUDService marketingProjectCUDService;
    private final MarketingProjectReadService marketingProjectReadService;

    @PostMapping("/marketingProject")
    public ResponseEntity<ResponseDTO> createMarketingProject(@RequestBody CreateMarketingProjectRequest request){
        ResponseDTO<CreateMarketingProjectResponse> response = marketingProjectCUDService.createMarketingProject(request);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/marketingProjects")
    public ResponseEntity<ResponseDTO> getMarketingProjectList(@RequestBody MarketingProjectSearchRequest request, Pageable pageable){
        ResponseDTO<MarketingProjectResponseList> response = marketingProjectReadService.getMarketingProjectList(request,pageable);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/marketingProject/{id}")
    public ResponseEntity<ResponseDTO> getMarketingProjectDetail(@PathVariable Long id){
        ResponseDTO<MarketingProjectDetailResponse> response = marketingProjectReadService.getMarketingProjectDetail(id);
        return ResponseEntity.ok().body(response);
    }

//    @PatchMapping("/marketingProject/{id}/start")
//    public ResponseEntity<ResponseDTO> startMarketingProject(@PathVariable Long id){
//        ResponseDTO<MarketingProjectDetailResponse> response = marketingProjectCUDService.startMarketingProject(id);
//        return ResponseEntity.ok().body(response);
//    }
}
