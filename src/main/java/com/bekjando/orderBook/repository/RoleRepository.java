package com.bekjando.orderBook.repository;

import com.bekjando.orderBook.model.Customer;
import com.bekjando.orderBook.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
