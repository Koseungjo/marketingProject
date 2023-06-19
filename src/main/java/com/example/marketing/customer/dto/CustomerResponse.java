package com.example.marketing.customer.dto;

import com.example.marketing.coupon.entity.Coupon;
import com.example.marketing.customer.entity.Customer;
import com.example.marketing.project.dto.MarketingProjectResponse;
import com.example.marketing.project.entity.MarketingProject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {
    private Long id;
    private String name;
    private String email;
    private String status;
    private String gender;
    private List<Coupon> coupons;

    private CustomerResponse(Customer customer){
        this.id = customer.getCustomerId();
        this.name = customer.getCustomerName();
        this.email = customer.getEmail();
        this.status = customer.getStatus();
        this.gender = customer.getGender();
        this.coupons = customer.getCoupons();
    }

    public static CustomerResponse of(Customer customer){
        return new CustomerResponse(customer);
    }

}
