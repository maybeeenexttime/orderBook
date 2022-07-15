package com.bekjando.orderBook.service;


import com.bekjando.orderBook.model.Customer;
import com.bekjando.orderBook.model.Role;
import com.bekjando.orderBook.repository.CustomerRepository;
import com.bekjando.orderBook.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService, UserDetailsService {

    private final CustomerRepository customerRepository;

    private final RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByUserName(username);
        if(customer == null){
            log.error("Данного пользователя нет в Базе Данных");
            throw new UsernameNotFoundException("Данного пользователя нет в Базе Данных");
        } else {
            log.info("Данный пользователь найден в Базе Данных {}", username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        customer.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new User(customer.getUserName(), customer.getPassword(), authorities);
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        log.info("Saving new customer {} to the database", customer.getName());
        return customerRepository.save(customer);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to the database", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToCustomer(String userName, String roleName) {
        log.info("Adding role {} to user {}", roleName, userName);
        Customer customer = customerRepository.findByUserName(userName);
        Role role = roleRepository.findByName(roleName);
        customer.getRoles().add(role);
    }

    @Override
    public Customer getCustomer(String userName) {
        log.info("Fetching user {}", userName);
        return customerRepository.findByUserName(userName);
    }

    @Override
    public List<Customer> getCustomers() {
        log.info("Fetching all users");
        return customerRepository.findAll();
    }


}
