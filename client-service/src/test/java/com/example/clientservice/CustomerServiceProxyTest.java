package com.example.clientservice;

import org.assertj.core.api.Assertions;
import org.junit.Test;
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
    public void getOneCustomer(){
        String customer = customerServiceProxy.getCustomer();
        Assertions.assertThat(customer).isEqualTo("mohsin");
    }

    @Test
    public void getAllCustomer(){
        List<String> allCustomer = customerServiceProxy.getAllCustomer();
        Assertions.assertThat(allCustomer).first().isEqualTo("mohsin");
        Assertions.assertThat(allCustomer).contains("omar");
    }

}

@TestConfiguration
class RestTest{
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}