package com.example.marketing.customer.controller;

import com.example.marketing.global.ResponseDTO;
import com.example.marketing.customer.dto.*;
import com.example.marketing.customer.service.CustomerCUDService;
import com.example.marketing.customer.service.CustomerReadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/")
public class CustomerApiController {

    private final CustomerCUDService customerCUDService;
    private final CustomerReadService customerReadService;

    //TODO: 유저 생성
    @PostMapping("/customer")
    private ResponseDTO<CreateCustomerResponse> createCustomer(@RequestBody CreateCustomerRequest request){
        CreateCustomerResponse response = customerCUDService.createCustomer(request);
        return ResponseDTO.ok(response);
    }

    //TODO: 유저 조회
    @GetMapping("/customers")
    private ResponseDTO<CustomerListResponse> getCustomerList(@ModelAttribute CustomerSearchRequest request, Pageable pageable){
       CustomerListResponse response = customerReadService.getCustomerList(request,pageable);
       return ResponseDTO.ok(response);
    }

    //TODO: 유저 상세조회
    @GetMapping("/customer/{id}")
    private ResponseDTO<CustomerDetailResponse> getCustomerDetails(@PathVariable Long id){
        CustomerDetailResponse response = customerReadService.getCustomerDetails(id);
        return ResponseDTO.ok(response);
    }
}
