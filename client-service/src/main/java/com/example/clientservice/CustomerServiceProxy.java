package com.example.clientservice;

import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class CustomerServiceProxy {
    private final RestTemplate restTemplate;

    public Customer getCustomer(){
        return restTemplate.getForObject("http://localhost:8080/customers/1" , Customer.class);
    }

    public List<Customer> getAllCustomer(){
        ResponseEntity<Customer[]> exchange = restTemplate.getForEntity("http://localhost:8080/customers",
                Customer[].class);
        Customer[] body = exchange.getBody();
        return Arrays.stream(body).collect(Collectors.toList());
    }



}
