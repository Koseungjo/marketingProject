package com.example.marketing.coupon.entity;

import com.example.marketing.customer.entity.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Map;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "coupon_issuance") // 매핑될 데이터베이스 테이블의 이름을 "coupon_issuance"으로 지정
public class CouponIssuance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_id", insertable = false, updatable = false)
    private Long customerId;
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    private LocalDate issuedDate;
    private Boolean redeemed;
    private LocalDate redemptionDate;

    @ManyToOne
    @JoinColumn(name = "coupon_id")
    private Coupon coupon;
}
