package com.bekjando.orderBook.dto;

import lombok.Data;

import java.util.List;

@Data
public class CustomerDto {
    public String firstName;
    public String lastName;
    public List<BookingDto> bookings;
}
