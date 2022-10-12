package com.customer.user;
import static org.mockito.Mockito.when;
import java.util.Date;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.customer.user.authentication.LogInResponse;
import com.customer.user.model.AuthUser;
import com.customer.user.service.ILogInRepository;
import com.customer.user.service.LogInServiceImp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

//
//@RunWith(SpringRunner.class)
//@SpringBootTest
class CustomerUserApplicationTests {
	
//	@Autowired
//	private LogInServiceImp logInService;
//	
//    @MockBean
//    private ILogInRepository logInRepo;
//
//     AuthUser user=new AuthUser( 1,"Khushboo","Sharma","Customer1Address","Uttar Pradesh","India","123456",234567,"KhushbooSharma@cognizant.com",new Date(2022-10-07),"contactNo","Khushu@2244");
//     LogInResponse logIn = new LogInResponse("USER CREATED SUCCESSFULLY", 201, user);
//     Optional<AuthUser> op=Optional.of(user);
//
//
//
//
//
//@Test
//public void getCustomerByIdTest() {
//	
//	
//	when(logInRepo.findById(1)).thenReturn(Optional.of(user));
//	assertEquals(op, logInService.getCustomerByid(1));
//}
//
//
//@Test
//
//public void updateUserTest() {
//	AuthUser savedUser=new AuthUser( 1,"Khushboo","Sharma","Customer1Address","Uttar Pradesh","India","123456",2234567,"KhushbooSharma@cognizant.com",new Date(2022-10-07),"contactNo","Khushu@2244");
//
//	// when - action or the behaviour
//	String newEmail = "Khushboo1Sharma1@cognizant.com";
//
//	savedUser.setEmail(newEmail);
//
//	// then - verify the output
//	assertThat(savedUser).isNotNull();
//
//	assertThat(savedUser.getEmail()).isEqualTo(newEmail);
//}
//@Test
//public void createUserTest() {
//	when(logInRepo.save(user)).thenReturn(user);
//	assertEquals(user.getUserId(), logInService.createUser(user));
//	
//}
//
//
//@Test
//public void findCustomerByEmailTest() {
//	when(logInRepo.findByEmail("KhushbooSharma@cognizant.com")).thenReturn((user));
//	
//	assertEquals(op, logInService.findUserByEmail("KhushbooSharma@cognizant.com"));
//	
//}


}


