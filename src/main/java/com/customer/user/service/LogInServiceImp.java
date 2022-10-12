package com.customer.user.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.user.authentication.LogInRequest;
import com.customer.user.authentication.LogInResponse;
import com.customer.user.exception.ResourceNotFoundException;
import com.customer.user.model.AuthUser;



import lombok.extern.log4j.Log4j2;


@Log4j2
@Service
public class LogInServiceImp implements ILogInService {

	@Autowired
	private ILogInRepository logInRepo;


	@Override
	public LogInResponse checkUser(LogInRequest user) {
		try {
			AuthUser obj = logInRepo.findByEmail(user.getEmail());
			if ((obj == null)) {
				return new LogInResponse("NOT FOUND PLZ CHECK USER DETAILS", 415);
			} else if (!(user.getPassWord().equals(obj.getPassWord()))) {
				return new LogInResponse("INCORRECT PASSWORD", 415);
			} else {
				return new LogInResponse("SUCCESS", 201, obj);
			}
		} catch (Exception ex) {
			System.out.println(ex.getLocalizedMessage());
		}
		return new LogInResponse("SOMETHING IS WRONG", 415);

	}

	@Override
	public  Integer createUser(AuthUser user) {
		

			AuthUser obj = logInRepo.save(user);
//			AuthUser obj1=new AuthUser(obj.getUserId(),obj.getFirstName(),obj.getLastName(),obj.getCustomerAddress(),obj.getState(),obj.getCountry(),obj.getPan(),obj.getContactNo(),obj.getEmail(), obj.getDateOfBirth(),obj.getPassWord(),obj.getContactPreference());
			return obj.getUserId();
		

	}
	
	

	@Override
	public Boolean ifExistsUser(AuthUser user) {
		boolean obj= logInRepo.existsByEmail(user.getEmail());
		return obj;
	}

	
	@Override
	public AuthUser updateCustomer(AuthUser user , Integer userId)
	{
		AuthUser existinguser = logInRepo.findById(userId).orElseThrow(()
				-> new ResourceNotFoundException("AuthUser", "userId", userId));
		
		existinguser.setContactNo(user.getContactNo());
		existinguser.setFirstName(user.getFirstName());
		
		existinguser.setLastName(user.getLastName());
		existinguser.setCountry(user.getCountry());
		existinguser.setCustomerAddress(user.getCustomerAddress());
		existinguser.setDateOfBirth(user.getDateOfBirth());
		existinguser.setPan(user.getPan());
		existinguser.setState(user.getState());
		existinguser.setContactPreference(user.getContactPreference());
		
		logInRepo.save(existinguser);
		System.out.println("existinguser"+existinguser);
		return existinguser;
	}
	
	@Override
	public List <AuthUser> showListCustomer(String emailId) {
	
		List<Object[]>b=logInRepo.showListCustomer(emailId);
	
		List<AuthUser>list=new ArrayList<>();
	
		for(Object [] object:b) {
			AuthUser payment=new AuthUser();
		
			
			payment.setUserId((int)object[0]);
			payment.setContactNo((int)object[1]);
			payment.setContactPreference((String)object[2]);
			payment.setCountry((String)object[3]);
		
			payment.setCustomerAddress((String)object[4]);
			payment.setDateOfBirth((Date)object[5]);
			payment.setEmail((String)object[6]);
			payment.setFirstName((String)object[7]);
			payment.setLastName((String)object[8]);
		
			payment.setPan((String)object[9]);
			payment.setPassWord((String)object[10]);
		
			payment.setState((String)object[11]);
		
			list.add(payment);
	
		}
		System.out.println(list);
		
		log.info("Customer saved with id={}",list);	
	return list;
}
		


	@Override
	public Optional<AuthUser> getCustomerByid(Integer userId) {
		return logInRepo.findById(userId);
	}
	@Override
	public Optional<AuthUser> findUserByEmail(String email) {
		AuthUser user=logInRepo.findByEmail(email);
		return Optional.ofNullable(user);
	}
	@Override
	public AuthUser updateUser(AuthUser user, Integer id) {
		AuthUser existingcustomer = logInRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
		existingcustomer.setFirstName(user.getFirstName());
		existingcustomer.setLastName(user.getLastName());
		existingcustomer.setPan(user.getPan());
		existingcustomer.setDateOfBirth(user.getDateOfBirth());
		existingcustomer.setContactNo(user.getContactNo());
		existingcustomer.setCustomerAddress(user.getCustomerAddress());
	

		logInRepo.save(existingcustomer);
		return existingcustomer;
	}
	
}