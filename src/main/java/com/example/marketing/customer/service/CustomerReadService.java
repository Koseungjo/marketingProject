package com.example.marketing.customer.service;

import com.example.marketing.customer.dto.CustomerDetailResponse;
import com.example.marketing.customer.dto.CustomerListResponse;
import com.example.marketing.customer.dto.CustomerResponse;
import com.example.marketing.customer.dto.CustomerSearchRequest;
import com.example.marketing.customer.entity.Customer;
import com.example.marketing.customer.repository.CustomerRepository;
import com.example.marketing.project.dto.MarketingProjectResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerReadService {

    private final CustomerRepository customerRepository;
    public CustomerListResponse getCustomerList(CustomerSearchRequest request, Pageable pageable) {
        List<Customer> customerList = customerRepository.findAll(request.getName(),request.getGender(),request.getEmail(),request.getStatus(),pageable);
        List<CustomerResponse> responses = customerList.stream().map(item -> CustomerResponse.of(item)).collect(Collectors.toList());
        return CustomerListResponse.of(responses);
    }

    public CustomerDetailResponse getCustomerDetails(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        CustomerDetailResponse response = CustomerDetailResponse.of(customer);
        return response;
    }
}
