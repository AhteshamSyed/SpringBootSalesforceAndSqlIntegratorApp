package com.Corptec.SpringBootSalesforceAndSqlIntegrator.controller;

import com.Corptec.SpringBootSalesforceAndSqlIntegrator.dto.AdminAuthDto;
import com.Corptec.SpringBootSalesforceAndSqlIntegrator.dto.AdminLoginResponseDto;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

class AuthControllerTest {
    /**
     * Method under test: {@link AuthController#adminRegister(AdminAuthDto)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAdminRegister() {
        // TODO: Complete this test.
        //   Reason: R005 Unable to load class.
        //   Class: org.springframework.web.servlet.FlashMapManager
        //   Please check that the class is available on your test runtime classpath.
        //   See https://diff.blue/R005 to resolve this issue.

        // Arrange
        // TODO: Populate arranged inputs
        AuthController authController = null;
        AdminAuthDto adminAuthDto = null;

        // Act
        ResponseEntity<String> actualAdminRegisterResult = authController.adminRegister(adminAuthDto);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link AuthController#login(AdminAuthDto)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testLogin() {
        // TODO: Complete this test.
        //   Reason: R005 Unable to load class.
        //   Class: org.springframework.web.servlet.FlashMapManager
        //   Please check that the class is available on your test runtime classpath.
        //   See https://diff.blue/R005 to resolve this issue.

        // Arrange
        // TODO: Populate arranged inputs
        AuthController authController = null;
        AdminAuthDto adminAuthDto = null;

        // Act
        ResponseEntity<AdminLoginResponseDto> actualLoginResult = authController.login(adminAuthDto);

        // Assert
        // TODO: Add assertions on result
    }
}

