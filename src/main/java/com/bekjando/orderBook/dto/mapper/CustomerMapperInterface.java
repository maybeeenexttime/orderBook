package com.bekjando.orderBook.dto.mapper;

import com.bekjando.orderBook.dto.CustomerDto;
import com.bekjando.orderBook.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = BookingMapperInterface.class)
public interface CustomerMapperInterface {
    Customer toEntity(CustomerDto customerDto);
    CustomerDto toDto(Customer customer);
}
