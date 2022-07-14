package com.bekjando.orderBook.repository;

import com.bekjando.orderBook.model.Customer;
import com.bekjando.orderBook.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByUserName(String userName);
}
