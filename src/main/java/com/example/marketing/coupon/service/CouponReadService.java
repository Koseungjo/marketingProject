package com.example.marketing.coupon.service;

import com.example.marketing.coupon.dto.CouponListRequest;
import com.example.marketing.coupon.dto.CouponListResponse;
import com.example.marketing.coupon.dto.CouponResponse;
import com.example.marketing.coupon.entity.Coupon;
import com.example.marketing.coupon.repository.CouponRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CouponReadService {
    private final CouponRepository couponRepository;
    public CouponListResponse getCouponList(CouponListRequest request) {
        List<Coupon> couponList = couponRepository.findAllByCouponName(request.getCouponName());
        List<CouponResponse> couponResponseList = couponList.stream().map(item -> CouponResponse.of(item)).collect(Collectors.toList());
        return CouponListResponse.of(couponResponseList);
    }
}
