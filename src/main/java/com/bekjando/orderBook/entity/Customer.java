package com.bekjando.orderBook.entity;

import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "customer_id")
    private List<Order> orders;

}
