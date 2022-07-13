package com.bekjando.orderBook.dto.mapper;

import com.bekjando.orderBook.dto.BookingDto;
import com.bekjando.orderBook.entity.Booking;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookingMapperInterface {
    Booking toEntity(BookingDto bookingDto);
    BookingDto toDto(Booking booking);
}
