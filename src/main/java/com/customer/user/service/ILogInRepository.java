package com.customer.user.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.customer.user.model.AuthUser;




public interface ILogInRepository extends JpaRepository<AuthUser, Integer> {
	
	AuthUser findByEmail(String email);

	Boolean existsByEmail(String email);
	 
	@Query(value = "select * from auth_user where email=?1",nativeQuery = true)
	List<Object[]> showListCustomer(String emailId);
	

}