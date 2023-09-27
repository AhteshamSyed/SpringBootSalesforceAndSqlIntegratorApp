package com.Corptec.SpringBootSalesforceAndSqlIntegrator.controller;

import com.Corptec.SpringBootSalesforceAndSqlIntegrator.dto.AdminAuthDto;
import com.Corptec.SpringBootSalesforceAndSqlIntegrator.dto.AdminLoginResponseDto;
import com.Corptec.SpringBootSalesforceAndSqlIntegrator.model.Admin;
import com.Corptec.SpringBootSalesforceAndSqlIntegrator.model.UserType;
import com.Corptec.SpringBootSalesforceAndSqlIntegrator.repository.AdminRepository;
import com.Corptec.SpringBootSalesforceAndSqlIntegrator.repository.CustomerRepository;
import com.Corptec.SpringBootSalesforceAndSqlIntegrator.security.CustomUserDetailsService;
import com.Corptec.SpringBootSalesforceAndSqlIntegrator.security.JwtGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AuthController {
	
	@Autowired
	private AdminRepository adminRepo;

	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private JwtGenerator jwtGenerator;
	
	@PostMapping("api/v1/adminRegister")
	public ResponseEntity<String> adminRegister(@RequestBody AdminAuthDto adminAuthDto) {
		if(adminRepo.existsByUsername(adminAuthDto.getUsername())) {
			return new ResponseEntity<String>("Username is taken !! ",HttpStatus.BAD_REQUEST);
		}
		Admin admin = new Admin();
		admin.setUsername(adminAuthDto.getUsername());
		admin.setPassword(passwordEncoder.encode(adminAuthDto.getPassword()));

		adminRepo.save(admin);
		return new ResponseEntity<String>("User Register successfull !! ", HttpStatus.CREATED);
	}
	
	@PostMapping("api/v1/adminLogin")
	public ResponseEntity<AdminLoginResponseDto> login(@RequestBody AdminAuthDto adminAuthDto) {
		System.out.println("adminLogin");
		customUserDetailsService.setUserType(UserType.ADMIN);
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(adminAuthDto.getUsername(), adminAuthDto.getPassword())); 
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String token = jwtGenerator.generateToken(authentication,UserType.ADMIN.toString());
		AdminLoginResponseDto responseDto = new AdminLoginResponseDto();
		responseDto.setSuccess(true);
		responseDto.setMessage("login successful !!");
		responseDto.setToken(token);
		Admin admin = adminRepo.findByUsername(adminAuthDto.getUsername()).orElseThrow();
		responseDto.setAdmin(admin.getUsername(), admin.getId());
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}


	
	/*@PostMapping("api/v1/studentRegister")
	public ResponseEntity<SuccessandMessageDto> studentRegister(@RequestBody StudentRegisterDto studentRegisterDto) {
		System.out.println("studentRegister");
		SuccessandMessageDto response = new SuccessandMessageDto();
		if(studentRepo.existsByEmail(studentRegisterDto.getEmail())) {
			response.setMessage("Email is already registered !!");
			response.setSuccess(false);
			return new ResponseEntity<SuccessandMessageDto>(response, HttpStatus.BAD_REQUEST);
		}
		StudentEntity studentEntity = new StudentEntity();
		studentEntity.setName(studentRegisterDto.getUsername());
		studentEntity.setPassword(passwordEncoder.encode(studentRegisterDto.getPassword()));
		studentEntity.setEmail(studentRegisterDto.getEmail());
		studentEntity.setStatus(true);
		studentRepo.save(studentEntity);
		response.setMessage("Profile Created Successfully !!");
		response.setSuccess(true);
		return new ResponseEntity<SuccessandMessageDto>(response, HttpStatus.OK);
	}*/
	
	/*@PostMapping("api/v1/studentLogin")
	public ResponseEntity<CustomerLoginResponseDto> studentLogin(@RequestBody StudentLoginDto studentLoginDto) {
		System.out.println("studentLogin");
		customUserDetailsService.setUserType(UserType.STUDENT);
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(studentLoginDto.getEmail(), studentLoginDto.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String token = jwtGenerator.generateToken(authentication, UserType.STUDENT.toString());
		StudentLoginResponseDto responseDto = new StudentLoginResponseDto();
		responseDto.setSuccess(true);
		responseDto.setMessage("login successful !!");
		responseDto.setToken(token);
		StudentEntity student = studentRepo.findByEmail(studentLoginDto.getEmail()).orElseThrow();
		responseDto.setStudent(student.getName(), student.getEmail(), student.getId());
		return new ResponseEntity<StudentLoginResponseDto>(responseDto, HttpStatus.OK);
	}*/
}
