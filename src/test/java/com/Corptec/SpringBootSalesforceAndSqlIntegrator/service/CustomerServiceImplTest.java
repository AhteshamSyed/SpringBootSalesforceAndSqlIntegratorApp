package com.Corptec.SpringBootSalesforceAndSqlIntegrator.service;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.Corptec.SpringBootSalesforceAndSqlIntegrator.dto.CustomerDto;
import com.Corptec.SpringBootSalesforceAndSqlIntegrator.model.Customer;
import com.Corptec.SpringBootSalesforceAndSqlIntegrator.repository.CustomerRepository;

import java.util.function.Function;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.server.reactive.ChannelSendOperator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.DirectProcessor;
import reactor.core.publisher.Mono;

@ContextConfiguration(classes = {CustomerServiceImpl.class})
@ExtendWith(SpringExtension.class)
class CustomerServiceImplTest {
    @MockBean
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerServiceImpl customerServiceImpl;

    /**
     * Method under test: {@link CustomerServiceImpl#saveCustomer(CustomerDto)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSaveCustomer() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "reactor.core.publisher.Mono.map(java.util.function.Function)" because "savedCustomer" is null
        //       at com.Corptec.SpringBootSalesforceAndSqlIntegrator.service.CustomerServiceImpl.saveCustomer(CustomerServiceImpl.java:20)
        //   See https://diff.blue/R013 to resolve this issue.

        when(customerRepository.save(Mockito.<Customer>any())).thenReturn(null);
        customerServiceImpl
                .saveCustomer(new CustomerDto("42", "janedoe", "iloveyou", "jane.doe@example.org", "6625550144"));
    }

    /**
     * Method under test: {@link CustomerServiceImpl#saveCustomer(CustomerDto)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSaveCustomer2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.Corptec.SpringBootSalesforceAndSqlIntegrator.dto.CustomerDto.getId()" because "customerDto" is null
        //       at com.Corptec.SpringBootSalesforceAndSqlIntegrator.mapper.CustomerMapper.mapToCustomer(CustomerMapper.java:18)
        //       at com.Corptec.SpringBootSalesforceAndSqlIntegrator.service.CustomerServiceImpl.saveCustomer(CustomerServiceImpl.java:17)
        //   See https://diff.blue/R013 to resolve this issue.

        when(customerRepository.save(Mockito.<Customer>any())).thenReturn(null);
        customerServiceImpl.saveCustomer(null);
    }

    /**
     * Method under test: {@link CustomerServiceImpl#saveCustomer(CustomerDto)}
     */
    @Test
    void testSaveCustomer3() {
        Mono<Customer> mono = mock(Mono.class);
        when(mono.map(Mockito.<Function<Customer, Object>>any())).thenReturn(null);
        when(customerRepository.save(Mockito.<Customer>any())).thenReturn(mono);
        assertNull(customerServiceImpl
                .saveCustomer(new CustomerDto("42", "janedoe", "iloveyou", "jane.doe@example.org", "6625550144")));
        verify(customerRepository).save(Mockito.<Customer>any());
        verify(mono).map(Mockito.<Function<Customer, Object>>any());
    }

    /**
     * Method under test: {@link CustomerServiceImpl#getCustomer(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetCustomer() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "reactor.core.publisher.Mono.map(java.util.function.Function)" because "customerMono" is null
        //       at com.Corptec.SpringBootSalesforceAndSqlIntegrator.service.CustomerServiceImpl.getCustomer(CustomerServiceImpl.java:26)
        //   See https://diff.blue/R013 to resolve this issue.

        when(customerRepository.findById(Mockito.<String>any())).thenReturn(null);
        customerServiceImpl.getCustomer("42");
    }

    /**
     * Method under test: {@link CustomerServiceImpl#getCustomer(String)}
     */
    @Test
    void testGetCustomer2() {
        Mono<Customer> mono = mock(Mono.class);
        when(mono.map(Mockito.<Function<Customer, Object>>any())).thenReturn(null);
        when(customerRepository.findById(Mockito.<String>any())).thenReturn(mono);
        assertNull(customerServiceImpl.getCustomer("42"));
        verify(customerRepository).findById(Mockito.<String>any());
        verify(mono).map(Mockito.<Function<Customer, Object>>any());
    }

    /**
     * Method under test: {@link CustomerServiceImpl#getAllCustomers()}
     */
    @Test
    void testGetAllCustomers() {
        DirectProcessor<Customer> createResult = DirectProcessor.create();
        when(customerRepository.findAll()).thenReturn(createResult);
        customerServiceImpl.getAllCustomers();
        verify(customerRepository).findAll();
    }

    /**
     * Method under test: {@link CustomerServiceImpl#updateCustomer(CustomerDto, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateCustomer() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "reactor.core.publisher.Mono.flatMap(java.util.function.Function)" because "customerMono" is null
        //       at com.Corptec.SpringBootSalesforceAndSqlIntegrator.service.CustomerServiceImpl.updateCustomer(CustomerServiceImpl.java:39)
        //   See https://diff.blue/R013 to resolve this issue.

        when(customerRepository.findById(Mockito.<String>any())).thenReturn(null);
        customerServiceImpl
                .updateCustomer(new CustomerDto("42", "janedoe", "iloveyou", "jane.doe@example.org", "6625550144"), "42");
    }

    /**
     * Method under test: {@link CustomerServiceImpl#updateCustomer(CustomerDto, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateCustomer2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "reactor.core.publisher.Mono.map(java.util.function.Function)" because the return value of "reactor.core.publisher.Mono.flatMap(java.util.function.Function)" is null
        //       at com.Corptec.SpringBootSalesforceAndSqlIntegrator.service.CustomerServiceImpl.updateCustomer(CustomerServiceImpl.java:44)
        //   See https://diff.blue/R013 to resolve this issue.

        Mono<Customer> mono = mock(Mono.class);
        when(mono.flatMap(Mockito.<Function<Customer, Mono<Object>>>any())).thenReturn(null);
        when(customerRepository.findById(Mockito.<String>any())).thenReturn(mono);
        customerServiceImpl
                .updateCustomer(new CustomerDto("42", "janedoe", "iloveyou", "jane.doe@example.org", "6625550144"), "42");
    }

    /**
     * Method under test: {@link CustomerServiceImpl#updateCustomer(CustomerDto, String)}
     */
    @Test
    void testUpdateCustomer3() {
        Mono<Object> mono = mock(Mono.class);
        when(mono.map(Mockito.<Function<Object, Object>>any())).thenReturn(null);
        Mono<Customer> mono2 = mock(Mono.class);
        when(mono2.flatMap(Mockito.<Function<Customer, Mono<Object>>>any())).thenReturn(mono);
        when(customerRepository.findById(Mockito.<String>any())).thenReturn(mono2);
        assertNull(customerServiceImpl
                .updateCustomer(new CustomerDto("42", "janedoe", "iloveyou", "jane.doe@example.org", "6625550144"), "42"));
        verify(customerRepository).findById(Mockito.<String>any());
        verify(mono2).flatMap(Mockito.<Function<Customer, Mono<Object>>>any());
        verify(mono).map(Mockito.<Function<Object, Object>>any());
    }

    /**
     * Method under test: {@link CustomerServiceImpl#deleteCustomer(String)}
     */
    @Test
    void testDeleteCustomer() {
        ChannelSendOperator<Object> channelSendOperator = new ChannelSendOperator<>(mock(Publisher.class),
                mock(Function.class));

        when(customerRepository.deleteById(Mockito.<String>any())).thenReturn(channelSendOperator);
        assertSame(channelSendOperator, customerServiceImpl.deleteCustomer("42"));
        verify(customerRepository).deleteById(Mockito.<String>any());
    }
}

