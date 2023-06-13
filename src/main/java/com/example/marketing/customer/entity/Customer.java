package com.example.marketing.customer.entity;

import com.example.marketing.coupon.entity.Coupon;
import com.example.marketing.customer.dto.CreateCustomerRequest;
import com.example.marketing.customer.global.CustomerStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    @Column(name = "customer_name", nullable = false)
    private String name;

    @Column(name = "gender")
    private String gender;

    @Column(name = "birth_date",nullable = false)
    private String birthDate;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "marketing_send_yn", nullable = false)
    private String marketingSendYn;

    @CreationTimestamp
    @Column(name = "sign_up_date", nullable = false)
    private LocalDateTime signUpDate;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Coupon> coupons = new ArrayList<>();

    // getters and setters

    public static Customer toEntity(CreateCustomerRequest request) {
        return Customer.builder()
                .name(request.getName())
                .gender(request.getGender())
                .birthDate(request.getBirthDate())
                .email(request.getEmail())
                .marketingSendYn(request.getMarketingSendYn())
                .status(CustomerStatus.ACTIVE.getStatus())
                .build();
    }

}
