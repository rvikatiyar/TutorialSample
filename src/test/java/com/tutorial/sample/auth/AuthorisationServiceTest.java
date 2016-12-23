package com.tutorial.sample.auth;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.tutorial.sample.db.UserStorageInterface;
import com.tutorial.sample.info.UserInfoInterface;

public class AuthorisationServiceTest {
	
	AuthorisationService authorisationService;
	
	
	@Before
	public void init(){
		authorisationService = new AuthorisationService();
	}
	
	@Test
	public void authoriseTest(){
		
		UserInfoInterface info = new UserInfoInterface();
		info.setName("Mukesh");
		info.setDob("22121985");
		info.setPhone("9826098260");
		
		UserStorageInterface userStorageInterface = Mockito.mock(UserStorageInterface.class);
		when(userStorageInterface.isKeyPresent("8922uM")).thenReturn(true);
		
		boolean result = authorisationService.authorise(info, userStorageInterface);
		
		verify(userStorageInterface, times(1)).isKeyPresent("8922uM");
		
		assertTrue(result);
	}
	
	@Test
	public void authoriseFailedTest(){
		
		UserInfoInterface info = new UserInfoInterface();
		info.setName("Mukesh");
		info.setDob("22121985");
		info.setPhone("9826098260");
		
		UserStorageInterface userStorageInterface = Mockito.mock(UserStorageInterface.class);
		when(userStorageInterface.isKeyPresent("1922uM")).thenReturn(true);
		
		boolean result = authorisationService.authorise(info, userStorageInterface);
		
		verify(userStorageInterface, times(1)).isKeyPresent("8922uM");
		
		assertFalse(result);
	}

}
