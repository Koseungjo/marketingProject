package com.example.marketing.coupon.entity;

import com.example.marketing.coupon.dto.CouponUpdateRequest;
import com.example.marketing.coupon.dto.CreateCouponRequest;
import com.example.marketing.coupon.enums.DiscountType;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "coupon") // 매핑될 데이터베이스 테이블의 이름을 "coupon"으로 지정
public class Coupon {

    @Id // 엔티티의 기본 키를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키 생성 전략을 지정 (DB가 자동 생성)
    private Long couponId;
    private String name;

    @Column(nullable = false, unique = true) // 필드는 null을 허용하지 않으며, 유니크해야 함
    private String code;

    private String description;

    private String discountType;

    private Double discountValue;

    private LocalDate validityStart; // 날짜 필드 (시간대 정보 없음)
    private LocalDate validityEnd;

    private LocalDate createdDate;

    private LocalDate updateDate;

    public static Coupon toEntity(CreateCouponRequest request) {
        return Coupon.builder()
                .name(request.getName())
                .code(request.getCode())
                .description(request.getDescription())
                .discountType(selectType(request.getDiscountType()))
                .discountValue(request.getDiscountValue())
                .validityStart(request.getValidityStart())
                .validityEnd(request.getValidityEnd())
                .createdDate(LocalDate.now())
                .build();
    }

    private static String selectType(String type){
        if (DiscountType.PERCENTAGE.getStatus().equals(type)){
            return DiscountType.PERCENTAGE.getStatus();
        }
        return DiscountType.FIXED_AMOUNT.getStatus();
    }

    public void update(CouponUpdateRequest request) {
        this.name = request.getName();
        this.description = request.getDescription();
        this.validityStart = request.getValidityStart();
        this.validityEnd = request.getValidityEnd();
    }
}
