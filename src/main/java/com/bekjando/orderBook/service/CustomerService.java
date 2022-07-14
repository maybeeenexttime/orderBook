package com.bekjando.orderBook.service;

import com.bekjando.orderBook.model.Customer;
import com.bekjando.orderBook.model.Role;

import java.util.List;


public interface CustomerService {
    Customer saveCustomer(Customer customer);

    Role saveRole(Role role);

    void addRoleToCustomer(String userName, String roleName);

    Customer getCustomer(String userName);

    List<Customer> getCustomers();
}
