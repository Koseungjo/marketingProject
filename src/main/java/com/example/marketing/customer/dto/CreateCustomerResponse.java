package com.example.marketing.customer.dto;

import com.example.marketing.customer.entity.Customer;
import lombok.Getter;

@Getter
public class CreateCustomerResponse {
    private Long id;
    private String name;
    private String email;



    private CreateCustomerResponse(Customer customer){
        this.id = customer.getId();
        this.name = customer.getName();
        this.email = customer.getEmail();
    }

    public static CreateCustomerResponse of(Customer customer){
        return new CreateCustomerResponse(customer);
    }
}
