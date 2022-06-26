package com.bekjando.orderBook.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
@Entity
@NoArgsConstructor
@Accessors(chain = true)
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "customer_id")
    private List<Booking> bookings;

}
