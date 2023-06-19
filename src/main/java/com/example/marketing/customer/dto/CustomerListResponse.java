package com.example.marketing.customer.dto;

import com.example.marketing.customer.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class CustomerListResponse {
    private List<CustomerResponse> customerResponse;

    private CustomerListResponse(List<CustomerResponse> responses){
       this.customerResponse = responses;
    }

    public static CustomerListResponse of(List<CustomerResponse> responses){
       return new CustomerListResponse(responses);
    }
}
