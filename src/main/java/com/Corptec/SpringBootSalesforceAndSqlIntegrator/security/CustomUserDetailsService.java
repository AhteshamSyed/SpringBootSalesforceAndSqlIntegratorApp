package com.Corptec.SpringBootSalesforceAndSqlIntegrator.security;

import com.Corptec.SpringBootSalesforceAndSqlIntegrator.model.Admin;
import com.Corptec.SpringBootSalesforceAndSqlIntegrator.model.Customer;
import com.Corptec.SpringBootSalesforceAndSqlIntegrator.model.UserType;
import com.Corptec.SpringBootSalesforceAndSqlIntegrator.repository.AdminRepository;
import com.Corptec.SpringBootSalesforceAndSqlIntegrator.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private AdminRepository adminRepo;

	@Autowired
	private CustomerRepository cutomerRepo;
	
	private UserType userType;
	
	public UserType getUserType()
	{
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(userType);
		if(userType==UserType.ADMIN) {
			
			Admin adminEntity = adminRepo.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("Admin Username "+ username+ "not found"));
			
			SimpleGrantedAuthority adminAuthority = new SimpleGrantedAuthority(UserType.ADMIN.toString());
			Collection<GrantedAuthority> authorities = new ArrayList<>();
			authorities.add(adminAuthority);
			return new User(adminEntity.getUsername(), adminEntity.getPassword(), authorities);
		} else if(userType == UserType.CUSTOMER) {
			Customer customerEntity = cutomerRepo.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("Customer Email "+ username+ "not found"));

			SimpleGrantedAuthority adminAuthority = new SimpleGrantedAuthority(UserType.CUSTOMER.toString());
			Collection<GrantedAuthority> authorities = new ArrayList<>();
			authorities.add(adminAuthority);
			return new User(customerEntity.getEmail(), customerEntity.getPassword(), authorities);
		}
		return null;
	}
	
}
