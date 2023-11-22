package com.example.marketing.coupon.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CouponUpdateRequest {

    private Long couponId;
    private String name;
    private String description;
    private LocalDate validityStart; // 날짜 필드 (시간대 정보 없음)
    private LocalDate validityEnd;
}
