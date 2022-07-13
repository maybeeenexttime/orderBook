package com.bekjando.orderBook.service;

import com.bekjando.orderBook.dto.CustomerDto;
import com.bekjando.orderBook.dto.mapper.CustomerMapperInterface;
import com.bekjando.orderBook.entity.Customer;
import com.bekjando.orderBook.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CustomerServiceImpl {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerMapperInterface customerMapperInterface;

    public void saveCustomer(CustomerDto customerDto) {
        Customer customer = customerMapperInterface.toEntity(customerDto);
        customerRepository.save(customer);
    }

    public Customer getById(long id) {
        return customerRepository.findById(id);
    }
}
