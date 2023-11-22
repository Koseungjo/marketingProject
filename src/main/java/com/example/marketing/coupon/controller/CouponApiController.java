package com.example.marketing.coupon.controller;

import com.example.marketing.coupon.dto.*;
import com.example.marketing.coupon.service.CouponCUDService;
import com.example.marketing.coupon.service.CouponReadService;
import com.example.marketing.global.ResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/")
public class CouponApiController {

    private final CouponCUDService couponCUDService;
    private final CouponReadService couponReadService;

    @PostMapping("/coupon")
    public ResponseDTO createCoupon(CreateCouponRequest request){
        log.info("COUPON_CREATE :: NAME : {}" , request.getName());
        couponCUDService.createCoupon(request);
        return ResponseDTO.ok();
    }

    @GetMapping("/coupon/{couponId}")
    public ResponseDTO<CouponResponse> getCouponDetail(@PathVariable Long couponId){
        CouponResponse response = couponReadService.getCouponDetail(couponId);
        return ResponseDTO.ok(response);
    }
    @GetMapping("/coupons")
    public ResponseDTO<CouponListResponse> getCouponList(@ModelAttribute CouponListRequest request){
        CouponListResponse response = couponReadService.getCouponList(request);
        return ResponseDTO.ok(response);
    }

    @PatchMapping("/coupon")
    public ResponseDTO updateCoupon(@RequestBody CouponUpdateRequest request){
        couponCUDService.updateCoupon(request);
        return ResponseDTO.ok();
    }

    @DeleteMapping("/coupon/{couponId}")
    public ResponseDTO deleteCoupon(@PathVariable Long couponId){
        couponCUDService.deleteCoupon(couponId);
        return ResponseDTO.ok();
    }
}
