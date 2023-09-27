package com.Corptec.SpringBootSalesforceAndSqlIntegrator.security;

//import com.examportal.model.UserType;
import com.Corptec.SpringBootSalesforceAndSqlIntegrator.model.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Autowired
	private JwtAuthEntryPoint jwtAuthEntryPoint;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.csrf(csrf->csrf.disable())
				.exceptionHandling(ex ->ex.authenticationEntryPoint(jwtAuthEntryPoint) )
				.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

				.authorizeHttpRequests(authCustomizer -> authCustomizer
						.requestMatchers(HttpMethod.GET,"/api/customer/**").hasAuthority(UserType.CUSTOMER.toString())
						.requestMatchers(HttpMethod.POST,"/api/customer/**").hasAuthority(UserType.CUSTOMER.toString())
						.requestMatchers("/api/v1/adminRegister").permitAll()
						.requestMatchers("/api/v1/adminLogin").permitAll()
						.requestMatchers("/api/v1/customerRegister").permitAll()
						.requestMatchers("/api/v1/adminLogin").permitAll()
						.requestMatchers("/api/v1/customer/**").hasAuthority(UserType.ADMIN.toString())
						.requestMatchers("/api/vi/api-docs","/swagger-resources/configuration/ui","/swagger-resources","/swagger-resources/configuration/security","/swagger-ui.html", "/webjars/**").permitAll()
						.requestMatchers("/api/v1/**").authenticated());


		http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public JwtAuthenticationFilter jwtAuthenticationFilter() {
		return new JwtAuthenticationFilter();
	}
}
