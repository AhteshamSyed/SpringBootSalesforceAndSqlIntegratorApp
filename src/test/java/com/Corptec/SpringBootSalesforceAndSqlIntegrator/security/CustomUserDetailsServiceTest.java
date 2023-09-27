package com.Corptec.SpringBootSalesforceAndSqlIntegrator.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.Corptec.SpringBootSalesforceAndSqlIntegrator.model.UserType;
import com.Corptec.SpringBootSalesforceAndSqlIntegrator.repository.AdminRepository;
import com.Corptec.SpringBootSalesforceAndSqlIntegrator.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CustomUserDetailsService.class})
@ExtendWith(SpringExtension.class)
class CustomUserDetailsServiceTest {
    @MockBean
    private AdminRepository adminRepository;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @MockBean
    private CustomerRepository customerRepository;

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link CustomUserDetailsService#setUserType(UserType)}
     *   <li>{@link CustomUserDetailsService#getUserType()}
     * </ul>
     */
    @Test
    void testSetUserType() {
        CustomUserDetailsService customUserDetailsService = new CustomUserDetailsService();
        customUserDetailsService.setUserType(UserType.ADMIN);
        assertEquals(UserType.ADMIN, customUserDetailsService.getUserType());
    }

    /**
     * Method under test: {@link CustomUserDetailsService#loadUserByUsername(String)}
     */
    @Test
    void testLoadUserByUsername() throws UsernameNotFoundException {
        assertNull(customUserDetailsService.loadUserByUsername("janedoe"));
    }
}

