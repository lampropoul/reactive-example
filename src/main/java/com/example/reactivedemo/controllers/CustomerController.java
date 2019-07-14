package com.example.reactivedemo.controllers;

import com.example.reactivedemo.model.Customer;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    List<Customer> list = new ArrayList<>();
    private DataSource dataSource;

    public CustomerController(DataSource dataSource) {
        Customer customer = Customer.builder()
                .cid(1L)
                .name("Bill")
                .surname("Lamp")
                .profession("Engineer")
                .build();
        customer.add(ControllerLinkBuilder.linkTo(CustomerController.class).slash(customer.getCid()).withSelfRel());
        list.add(customer);
        customer = Customer.builder()
                .cid(2L)
                .name("Foo")
                .surname("Bar")
                .profession("Designer")
                .build();
        customer.add(ControllerLinkBuilder.linkTo(CustomerController.class).slash(customer.getCid()).withSelfRel());
        list.add(customer);
        this.dataSource = dataSource;
    }

    @GetMapping(path = "/all", produces = "application/json")
    public List<Customer> getAllCustomers() {
        return list;
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public Customer getCustomer(@PathVariable("id") Long id) {
        return list.get(Math.toIntExact(id - 1));
    }

}
