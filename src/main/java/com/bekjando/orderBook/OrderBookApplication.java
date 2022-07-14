package com.bekjando.orderBook;

import com.bekjando.orderBook.model.Customer;
import com.bekjando.orderBook.model.Role;
import com.bekjando.orderBook.service.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class OrderBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderBookApplication.class, args);
	}

	CommandLineRunner run(CustomerService customerService){
		return args -> {
			customerService.saveRole(new Role(null, "ROLE_CLIENT"));
			customerService.saveRole(new Role(null, "ROLE_MANAGER"));
			customerService.saveRole(new Role(null, "ROLE_ADMIN"));
			customerService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			customerService.saveCustomer(new Customer
					(null, "Fernando Torres", "elnino",
					"fernando9torres", new ArrayList<>()));
			customerService.saveCustomer(new Customer
					(null, "Steven Gerrard", "stevege",
							"steve8", new ArrayList<>()));
			customerService.saveCustomer(new Customer
					(null, "Jamie Carragher", "jamiec",
							"jamie233223", new ArrayList<>()));
			customerService.saveCustomer(new Customer
					(null, "Dirk Kuyt", "rizhiy",
							"superKuyt18", new ArrayList<>()));


			customerService.addRoleToCustomer("elnino", "ROLE_CLIENT");
			customerService.addRoleToCustomer("rizhiy", "ROLE_MANAGER");
			customerService.addRoleToCustomer("jamiec", "ROLE_ADMIN");
			customerService.addRoleToCustomer("stevege", "ROLE_CLIENT");
			customerService.addRoleToCustomer("stevege", "ROLE_ADMIN");
			customerService.addRoleToCustomer("stevege", "ROLE_SUPER_ADMIN");

		};
	}

}
