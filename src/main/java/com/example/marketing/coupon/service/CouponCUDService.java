package com.example.marketing.coupon.service;

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
        List<Coupon> couponList  =  new ArrayList<>();
        List<Customer> customerList = customerRepository.findAllById(request.getCustomerIdList());

        if (request.getCustomerIdList().size() == 0){
            throw new NoSuchElementException("회원이 존재하지 않습니다.");
        }

        for (Customer customer : customerList){
            couponList.add(Coupon.toEntity(request.getCouponName(), customer,request.getValidityPeriod()));
        }
        couponRepository.saveAll(couponList);
    }
}
