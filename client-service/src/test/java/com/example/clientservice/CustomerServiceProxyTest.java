package com.example.clientservice;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = CustomerServiceProxy.class)
@AutoConfigureStubRunner(ids = {"com.example:customer-service:+:stubs:8080"}
        , stubsMode = StubRunnerProperties.StubsMode.LOCAL)
@Import(value = RestTest.class)
public class CustomerServiceProxyTest {
    @Autowired
    private CustomerServiceProxy customerServiceProxy;

    @Test
    public void getOneCustomer()
    {
        Customer mohsin = new Customer(10, "mohsin");
        Customer customer = customerServiceProxy.getCustomer();
        Assertions.assertThat(customer).isEqualTo(mohsin);
        Assertions.assertThat(customer.getAge()).isEqualTo(10);
        Assertions.assertThat(customer.getName()).isEqualTo("mohsin");
    }

    @Test
    public void getAllCustomer(){
        Customer mohsin = new Customer(10, "mohsin");
        Customer omar = new Customer(20, "omar");
        List<Customer> allCustomer = customerServiceProxy.getAllCustomer();
        Assertions.assertThat(allCustomer.size()).isEqualTo(2);
        Assertions.assertThat(allCustomer).contains(mohsin);
        Assertions.assertThat(allCustomer).contains(omar);
    }
}

@TestConfiguration
class RestTest{
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}