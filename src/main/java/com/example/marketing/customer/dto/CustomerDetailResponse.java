package com.example.marketing.customer.dto;

import com.example.marketing.coupon.entity.Coupon;
import com.example.marketing.coupon.entity.CouponIssuance;
import com.example.marketing.customer.entity.Customer;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDetailResponse {

    private Long id;
    private String name;
    private String gender;
    private String birthDate;
    private String email;
    private String marketingSendYn;
    private LocalDateTime signUpDate;
    private String status;
    private List<CouponIssuance> couponIssuance;

    private CustomerDetailResponse(Customer customer) {
        this.id = customer.getCustomerId();
        this.name = customer.getCustomerName();
        this.gender = customer.getGender();
        this.birthDate = customer.getBirthDate();
        this.email = customer.getEmail();
        this.marketingSendYn = customer.getMarketingSendYn();
        this.signUpDate = customer.getSignUpDate();
        this.status = customer.getStatus();
        this.couponIssuance = customer.getCouponIssuance();
    }

    public static CustomerDetailResponse of(Customer customer){
        return new CustomerDetailResponse(customer);
    }
}
