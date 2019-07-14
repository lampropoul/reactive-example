package com.example.reactivedemo.services;

import com.example.reactivedemo.model.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {

    Flux<Customer> findAll();

    Mono<Customer> findById(Long id);
}
