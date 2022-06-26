package com.bekjando.orderBook.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String status;
}
