package com.example.marketing.coupon.repository;

import com.example.marketing.coupon.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CouponRepository extends JpaRepository<Coupon,Long> {

    @Query("select c from Coupon c " +
            "WHERE (:couponName = '' OR c.name LIKE CONCAT('%', :couponName, '%'))")
    List<Coupon> findAllByCouponName(String couponName);
}
