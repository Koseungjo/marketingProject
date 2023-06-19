package com.example.marketing.coupon.entity;

import com.example.marketing.coupon.dto.CreateCouponRequest;
import com.example.marketing.coupon.global.CouponStatus;
import com.example.marketing.customer.dto.CreateCustomerRequest;
import com.example.marketing.customer.entity.Customer;
import com.example.marketing.customer.global.CustomerStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
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
    private Long couponId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonBackReference
    private Customer customer;

    @Column(name = "coupon_name")
    private String couponName;

    @Column(name = "status")
    private String status;

    @Column(name = "validity_period", nullable = false)
    private LocalDate expirationDate;

    public static Coupon toEntity(String couponName,Customer customer,int validityPeriod) {
        return Coupon.builder()
                .customer(customer)
                .couponName(couponName)
                .status(CouponStatus.ACTIVE.getStatus())
                .expirationDate(LocalDate.now().plusDays(validityPeriod))
                .build();
    }

}
