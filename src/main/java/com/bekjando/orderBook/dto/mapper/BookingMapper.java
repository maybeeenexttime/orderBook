package com.bekjando.orderBook.dto.mapper;

import com.bekjando.orderBook.dto.BookingDto;
import com.bekjando.orderBook.entity.Booking;

public class BookingMapper {
    public static Booking bookingDtoToBooking(BookingDto bookingDto) {
        Booking booking = new Booking();
        booking.setName(bookingDto.name);
        booking.setStatus(bookingDto.status);
        return booking;
    }
}
