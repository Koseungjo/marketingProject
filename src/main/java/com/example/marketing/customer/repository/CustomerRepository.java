package com.example.marketing.customer.repository;

import com.example.marketing.customer.dto.CustomerResponse;
import com.example.marketing.customer.entity.Customer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long>{

    @Query("SELECT c FROM Customer c " +
            "WHERE 1=1 " +
            "AND (:name = '' OR c.customerName LIKE CONCAT('%', :name, '%')) " +
            "AND (:email = '' OR c.email LIKE CONCAT('%', :email, '%')) " +
            "AND (:status = '' OR :status = '-1' OR c.status = :status) " +
            "AND (:gender = '' OR :gender = '-1' OR c.gender = :gender) " )
    List<Customer> findAll(String name, String gender, String email, String status, Pageable pageable);
}
