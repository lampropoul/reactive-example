package com.example.reactivedemo.controllers;

import com.example.reactivedemo.model.Customer;
import com.example.reactivedemo.services.CustomerService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Customer> getAllCustomers() {
        return customerService.findAll();
    }

    @GetMapping(path = "/{cid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Customer> getCustomer(@PathVariable("cid") Long cid) {
        return customerService.findById(cid);
    }

}
