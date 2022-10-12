package com.customer.user.service;

import java.util.List;
import java.util.Optional;

import com.customer.user.authentication.LogInRequest;
import com.customer.user.authentication.LogInResponse;
import com.customer.user.model.AuthUser;





public interface ILogInService {

	public LogInResponse checkUser(LogInRequest user);
	
	public Integer createUser(AuthUser user);
	List<AuthUser> showListCustomer(String emailId);
	
	public Boolean ifExistsUser(AuthUser user);
	AuthUser updateCustomer(AuthUser user , Integer userId);
	Optional<AuthUser> getCustomerByid(Integer userId);
	AuthUser updateUser(AuthUser customer, Integer id);
	Optional<AuthUser> findUserByEmail(String email);
	
}