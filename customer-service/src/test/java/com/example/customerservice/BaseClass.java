package com.example.customerservice;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CustomerController.class)
public abstract class BaseClass {
    @Autowired CustomerController controller;

    @BeforeEach
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(this.controller);
    }
}

