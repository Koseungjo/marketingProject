package com.example.marketing.customer.service;

import com.example.marketing.customer.dto.CreateCustomerRequest;
import com.example.marketing.customer.dto.CreateCustomerResponse;
import com.example.marketing.customer.entity.Customer;
import com.example.marketing.customer.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class CustomerCUDService {

    private final CustomerRepository customerRepository;
    public CreateCustomerResponse createCustomer(CreateCustomerRequest request) {
        Customer createCustomer = Customer.toEntity(request);
        createCustomer = customerRepository.save(createCustomer);
        CreateCustomerResponse response = CreateCustomerResponse.of(createCustomer);
        return response;
    }
}
