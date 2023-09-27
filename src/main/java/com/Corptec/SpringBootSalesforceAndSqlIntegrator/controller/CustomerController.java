package com.Corptec.SpringBootSalesforceAndSqlIntegrator.controller;

import com.Corptec.SpringBootSalesforceAndSqlIntegrator.dto.CustomerDto;
import com.Corptec.SpringBootSalesforceAndSqlIntegrator.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/customer/")
@AllArgsConstructor
@Slf4j
public class CustomerController {

    private CustomerService customerService;



    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<CustomerDto> saveCustomer(@RequestBody CustomerDto customerDto){
        log.info("Inside saveCustomer in CustomerserviceImpl");
        return customerService.saveCustomer(customerDto);
    }
    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<CustomerDto> getAllCustomers(){
        log.info("Inside getAllCustomers in CustomerserviceImpl");
        return customerService.getAllCustomers();
    }
    @GetMapping("{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<CustomerDto> getCustomerById(@PathVariable("id") String customerId){
        return customerService.getCustomer(customerId);
    }
    @PutMapping("{id}")
    public Mono<CustomerDto> updateCustomer(@RequestBody CustomerDto customerDto,
                                            @PathVariable("id") String customerId){
        return customerService.updateCustomer(customerDto, customerId);
    }
    @DeleteMapping("{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<Void> deleteEmployees(@PathVariable("id") String customerId){
        return customerService.deleteCustomer(customerId);
    }
}
