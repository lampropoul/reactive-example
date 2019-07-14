package com.example.reactivedemo.controllers;

import com.example.reactivedemo.model.Customer;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private List<Customer> list = new ArrayList<>();

    public CustomerController() {
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
    }

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<List<Customer>> getAllCustomers() {
        return Mono.just(list);
    }

    @GetMapping(path = "/{cid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Customer> getCustomer(@PathVariable("cid") Long cid) {
        return Mono.just(list.get(Math.toIntExact(cid - 1)));
    }

}
