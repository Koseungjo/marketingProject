package com.example.marketing.coupon.service;

import com.example.marketing.coupon.dto.CreateCouponRequest;
import com.example.marketing.coupon.dto.CreateCouponResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class CouponCUDService {
    public CreateCouponResponse createCoupon(CreateCouponRequest request) {

        return null;
    }
}
