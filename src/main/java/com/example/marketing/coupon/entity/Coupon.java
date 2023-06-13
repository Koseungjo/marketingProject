package com.example.marketing.coupon.entity;

import com.example.marketing.coupon.dto.CreateCouponRequest;
import com.example.marketing.coupon.global.CouponStatus;
import com.example.marketing.customer.dto.CreateCustomerRequest;
import com.example.marketing.customer.entity.Customer;
import com.example.marketing.customer.global.CustomerStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "coupon")
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coupon_id")
    private Long id;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "coupon_name")
    private String couponName;

    @Column(name = "status")
    private String status;

    @Column(name = "validity_period", nullable = false)
    private LocalDate validityPeriod;

    @PrePersist
    public void setDefaultValidityPeriod(int plusDay) {
        if (validityPeriod == null) {
            validityPeriod = LocalDate.now().plusDays(plusDay);
        }
    }

    public static Coupon toEntity(String couponName, Long customerId, int ) {
        return Coupon.builder()
                .couponName(couponName)
                .customerId(customerId)
                .status(CouponStatus.ACTIVE.getStatus())
                .
                .build();
    }

}
