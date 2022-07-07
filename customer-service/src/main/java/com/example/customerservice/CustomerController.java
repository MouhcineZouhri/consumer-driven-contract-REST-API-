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
    public List<String> customers(){
        return List.of("mohsin" , "omar");
    }


    @GetMapping("/customers/{id}")
    public String one(){
        return "mohsin";
    }

}
