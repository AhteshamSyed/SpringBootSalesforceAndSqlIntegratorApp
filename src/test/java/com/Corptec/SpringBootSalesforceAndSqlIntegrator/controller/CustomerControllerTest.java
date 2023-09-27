package com.Corptec.SpringBootSalesforceAndSqlIntegrator.controller;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.Corptec.SpringBootSalesforceAndSqlIntegrator.dto.CustomerDto;
import com.Corptec.SpringBootSalesforceAndSqlIntegrator.service.CustomerServiceImpl;

import java.util.function.Function;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.reactivestreams.Publisher;
import org.springframework.http.server.reactive.ChannelSendOperator;
import reactor.core.publisher.DirectProcessor;

class CustomerControllerTest {
    /**
     * Method under test: {@link CustomerController#saveCustomer(CustomerDto)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSaveCustomer() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R005 Unable to load class.
        //   Class: org.springframework.web.servlet.FlashMapManager
        //   Please check that the class is available on your test runtime classpath.
        //   See https://diff.blue/R005 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.Corptec.SpringBootSalesforceAndSqlIntegrator.repository.CustomerRepository.save(Object)" because "<local3>.customerRepository" is null
        //       at com.Corptec.SpringBootSalesforceAndSqlIntegrator.service.CustomerServiceImpl.saveCustomer(CustomerServiceImpl.java:18)
        //       at com.Corptec.SpringBootSalesforceAndSqlIntegrator.controller.CustomerController.saveCustomer(CustomerController.java:27)
        //   See https://diff.blue/R013 to resolve this issue.

        CustomerController customerController = new CustomerController(new CustomerServiceImpl());
        customerController.saveCustomer(new CustomerDto("42", "janedoe", "iloveyou", "jane.doe@example.org", "6625550144"));
    }

    /**
     * Method under test: {@link CustomerController#saveCustomer(CustomerDto)}
     */
    @Test
    void testSaveCustomer2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R005 Unable to load class.
        //   Class: org.springframework.web.servlet.FlashMapManager
        //   Please check that the class is available on your test runtime classpath.
        //   See https://diff.blue/R005 to resolve this issue.

        CustomerServiceImpl customerService = mock(CustomerServiceImpl.class);
        when(customerService.saveCustomer(Mockito.<CustomerDto>any())).thenReturn(null);
        CustomerController customerController = new CustomerController(customerService);
        assertNull(customerController
                .saveCustomer(new CustomerDto("42", "janedoe", "iloveyou", "jane.doe@example.org", "6625550144")));
        verify(customerService).saveCustomer(Mockito.<CustomerDto>any());
    }

    /**
     * Method under test: {@link CustomerController#getAllCustomers()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllCustomers() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R005 Unable to load class.
        //   Class: org.springframework.web.servlet.DispatcherServlet
        //   Please check that the class is available on your test runtime classpath.
        //   See https://diff.blue/R005 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.Corptec.SpringBootSalesforceAndSqlIntegrator.repository.CustomerRepository.findAll()" because "<local2>.customerRepository" is null
        //       at com.Corptec.SpringBootSalesforceAndSqlIntegrator.service.CustomerServiceImpl.getAllCustomers(CustomerServiceImpl.java:31)
        //       at com.Corptec.SpringBootSalesforceAndSqlIntegrator.controller.CustomerController.getAllCustomers(CustomerController.java:33)
        //   See https://diff.blue/R013 to resolve this issue.

        (new CustomerController(new CustomerServiceImpl())).getAllCustomers();
    }

    /**
     * Method under test: {@link CustomerController#getAllCustomers()}
     */
    @Test
    void testGetAllCustomers2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R005 Unable to load class.
        //   Class: org.springframework.web.servlet.DispatcherServlet
        //   Please check that the class is available on your test runtime classpath.
        //   See https://diff.blue/R005 to resolve this issue.

        CustomerServiceImpl customerService = mock(CustomerServiceImpl.class);
        DirectProcessor<CustomerDto> createResult = DirectProcessor.create();
        when(customerService.getAllCustomers()).thenReturn(createResult);
        assertSame(createResult, (new CustomerController(customerService)).getAllCustomers());
        verify(customerService).getAllCustomers();
    }

    /**
     * Method under test: {@link CustomerController#getCustomerById(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetCustomerById() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R005 Unable to load class.
        //   Class: org.springframework.web.servlet.DispatcherServlet
        //   Please check that the class is available on your test runtime classpath.
        //   See https://diff.blue/R005 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.Corptec.SpringBootSalesforceAndSqlIntegrator.repository.CustomerRepository.findById(Object)" because "<local3>.customerRepository" is null
        //       at com.Corptec.SpringBootSalesforceAndSqlIntegrator.service.CustomerServiceImpl.getCustomer(CustomerServiceImpl.java:25)
        //       at com.Corptec.SpringBootSalesforceAndSqlIntegrator.controller.CustomerController.getCustomerById(CustomerController.java:38)
        //   See https://diff.blue/R013 to resolve this issue.

        (new CustomerController(new CustomerServiceImpl())).getCustomerById("42");
    }

    /**
     * Method under test: {@link CustomerController#getCustomerById(String)}
     */
    @Test
    void testGetCustomerById2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R005 Unable to load class.
        //   Class: org.springframework.web.servlet.DispatcherServlet
        //   Please check that the class is available on your test runtime classpath.
        //   See https://diff.blue/R005 to resolve this issue.

        CustomerServiceImpl customerService = mock(CustomerServiceImpl.class);
        when(customerService.getCustomer(Mockito.<String>any())).thenReturn(null);
        assertNull((new CustomerController(customerService)).getCustomerById("42"));
        verify(customerService).getCustomer(Mockito.<String>any());
    }

    /**
     * Method under test: {@link CustomerController#updateCustomer(CustomerDto, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateCustomer() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R005 Unable to load class.
        //   Class: org.springframework.web.servlet.FlashMapManager
        //   Please check that the class is available on your test runtime classpath.
        //   See https://diff.blue/R005 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.Corptec.SpringBootSalesforceAndSqlIntegrator.repository.CustomerRepository.findById(Object)" because "<local4>.customerRepository" is null
        //       at com.Corptec.SpringBootSalesforceAndSqlIntegrator.service.CustomerServiceImpl.updateCustomer(CustomerServiceImpl.java:38)
        //       at com.Corptec.SpringBootSalesforceAndSqlIntegrator.controller.CustomerController.updateCustomer(CustomerController.java:43)
        //   See https://diff.blue/R013 to resolve this issue.

        CustomerController customerController = new CustomerController(new CustomerServiceImpl());
        customerController
                .updateCustomer(new CustomerDto("42", "janedoe", "iloveyou", "jane.doe@example.org", "6625550144"), "42");
    }

    /**
     * Method under test: {@link CustomerController#updateCustomer(CustomerDto, String)}
     */
    @Test
    void testUpdateCustomer2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R005 Unable to load class.
        //   Class: org.springframework.web.servlet.FlashMapManager
        //   Please check that the class is available on your test runtime classpath.
        //   See https://diff.blue/R005 to resolve this issue.

        CustomerServiceImpl customerService = mock(CustomerServiceImpl.class);
        when(customerService.updateCustomer(Mockito.<CustomerDto>any(), Mockito.<String>any())).thenReturn(null);
        CustomerController customerController = new CustomerController(customerService);
        assertNull(customerController
                .updateCustomer(new CustomerDto("42", "janedoe", "iloveyou", "jane.doe@example.org", "6625550144"), "42"));
        verify(customerService).updateCustomer(Mockito.<CustomerDto>any(), Mockito.<String>any());
    }

    /**
     * Method under test: {@link CustomerController#deleteEmployees(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDeleteEmployees() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R005 Unable to load class.
        //   Class: org.springframework.web.servlet.DispatcherServlet
        //   Please check that the class is available on your test runtime classpath.
        //   See https://diff.blue/R005 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.Corptec.SpringBootSalesforceAndSqlIntegrator.repository.CustomerRepository.deleteById(Object)" because "this.customerRepository" is null
        //       at com.Corptec.SpringBootSalesforceAndSqlIntegrator.service.CustomerServiceImpl.deleteCustomer(CustomerServiceImpl.java:49)
        //       at com.Corptec.SpringBootSalesforceAndSqlIntegrator.controller.CustomerController.deleteEmployees(CustomerController.java:48)
        //   See https://diff.blue/R013 to resolve this issue.

        (new CustomerController(new CustomerServiceImpl())).deleteEmployees("42");
    }

    /**
     * Method under test: {@link CustomerController#deleteEmployees(String)}
     */
    @Test
    void testDeleteEmployees2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R005 Unable to load class.
        //   Class: org.springframework.web.servlet.DispatcherServlet
        //   Please check that the class is available on your test runtime classpath.
        //   See https://diff.blue/R005 to resolve this issue.

        CustomerServiceImpl customerService = mock(CustomerServiceImpl.class);
        ChannelSendOperator<Object> channelSendOperator = new ChannelSendOperator<>(mock(Publisher.class),
                mock(Function.class));

        when(customerService.deleteCustomer(Mockito.<String>any())).thenReturn(channelSendOperator);
        assertSame(channelSendOperator, (new CustomerController(customerService)).deleteEmployees("42"));
        verify(customerService).deleteCustomer(Mockito.<String>any());
    }
}

