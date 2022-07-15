package com.example.customerservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @GetMapping("/customers")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Customer> customers(){
        return List.of(
                new Customer(   10, "mohsin"),
                new Customer(   20, "omar")
        );
    }


    @GetMapping("/customers/{id}")
    public Customer one()
    {
        return new Customer(10, "mohsin");
    }

}

