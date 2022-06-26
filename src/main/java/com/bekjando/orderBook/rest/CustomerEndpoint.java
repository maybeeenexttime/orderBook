package com.bekjando.orderBook.rest;

import com.bekjando.orderBook.dto.CustomerDto;
import com.bekjando.orderBook.entity.Customer;
import com.bekjando.orderBook.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/customer")
public class CustomerEndpoint {

    @Autowired
    CustomerServiceImpl customerService;

    @PostMapping("/save")
    public void saveCustomer(@RequestBody CustomerDto customerDto) {
        customerService.saveCustomer(customerDto);
    }

    @GetMapping("/getCustomer/{id}")
    public Customer getById(@PathVariable Long id) {
        return customerService.getById(id);
    }
}
