package com.customer.user.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.user.authentication.LogInRequest;
import com.customer.user.model.AuthUser;

import com.customer.user.service.LogInServiceImp;

@RestController
@RequestMapping("/customerServiceUser")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins= "*")
public class LogInController {
	
	@Autowired
	private LogInServiceImp logInService;

	@PostMapping("/login")
	public ResponseEntity<?> authenticationCheck(@RequestBody LogInRequest logInRequest){
		return ResponseEntity.ok(logInService.checkUser(logInRequest));
	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> createUser(@RequestBody AuthUser user){
		return new ResponseEntity<>(logInService.createUser(user),HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/checkDuplicate")
	public ResponseEntity<?> checkDuplicateUser(@RequestBody AuthUser user){
		return ResponseEntity.ok(logInService.ifExistsUser(user));
	}
	

	@GetMapping("/getCustomer/{emailId}")
	
	public ResponseEntity<?> showListOfPurchasedBooks(@PathVariable("emailId")String emailId){
		
		return ResponseEntity.ok(logInService.showListCustomer(emailId));
	}
	 @PutMapping("/update/{userId}")
		public ResponseEntity<AuthUser> updateCustomer(@PathVariable("userId") Integer userId, @RequestBody AuthUser user)
		{
			return new ResponseEntity<AuthUser>(logInService.updateCustomer(user, userId), HttpStatus.OK);
		}
	 
	 
	
}