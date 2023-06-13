package com.example.marketing.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerSearchRequest {
    private String name;
    private String status;
    private String gender;
    private String email;
}
