package com.bekjando.orderBook.dto.mapper;

import com.bekjando.orderBook.dto.CustomerDto;
import com.bekjando.orderBook.entity.Customer;

import java.util.stream.Collectors;

public class CustomerMapper {

    public static CustomerDto CustomerToCustomerDto(Customer customer) {
        return null;
    }

    public static Customer customerDtoToCustom(CustomerDto customerDto) {
        Customer customer = new Customer()
                .setFirstName(customerDto.firstName)
                .setLastName(customerDto.lastName)
                .setBookings(customerDto.bookings.stream().map(BookingMapper::bookingDtoToBooking).collect(Collectors.toList()));
        return customer;
    }
}
