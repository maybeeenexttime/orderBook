package com.bekjando.orderBook.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Entity
@NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "booking_seq")
    @SequenceGenerator(name = "booking_seq")
    private Long id;
    private String name;
    private String status;
}
