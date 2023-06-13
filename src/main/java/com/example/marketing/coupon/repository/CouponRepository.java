package com.example.marketing.coupon.repository;

import com.example.marketing.coupon.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon,Long> {

}
