package com.example.marketing.coupon.service;

import com.example.marketing.coupon.dto.CouponUpdateRequest;
import com.example.marketing.coupon.dto.CreateCouponRequest;
import com.example.marketing.coupon.entity.Coupon;
import com.example.marketing.coupon.repository.CouponRepository;
import com.example.marketing.customer.entity.Customer;
import com.example.marketing.customer.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class CouponCUDService {
    private final CouponRepository couponRepository;
    private final CustomerRepository customerRepository;
    public void createCoupon(CreateCouponRequest request) {
        Coupon coupon = Coupon.toEntity(request);
        couponRepository.save(coupon);
    }


    public void updateCoupon(CouponUpdateRequest request) {
        Coupon coupon = couponRepository.findById(request.getCouponId()).orElseThrow(
                () -> new NoSuchElementException("존재하지 않는 쿠폰입니다.")
        );

        coupon.update(request);
    }

    public void deleteCoupon(Long couponId) {
        couponRepository.deleteById(couponId);
    }
}
