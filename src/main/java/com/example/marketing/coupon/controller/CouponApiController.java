package com.example.marketing.coupon.controller;

import com.example.marketing.coupon.dto.CreateCouponRequest;
import com.example.marketing.coupon.dto.CreateCouponResponse;
import com.example.marketing.coupon.service.CouponCUDService;
import com.example.marketing.coupon.service.CouponReadService;
import com.example.marketing.customer.dto.*;
import com.example.marketing.customer.service.CustomerCUDService;
import com.example.marketing.customer.service.CustomerReadService;
import com.example.marketing.global.ResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/")
public class CouponApiController {

    private final CouponCUDService customerCUDService;
    private final CouponReadService customerReadService;

    //TODO: 쿠폰 생성
    @PostMapping("/coupon")
    public ResponseDTO<CreateCouponResponse> createCoupon(CreateCouponRequest request){
        CreateCouponResponse response = customerCUDService.createCoupon(request);
        return ResponseDTO.ok(response);
    }
    //TODO: 쿠폰 조회

}
