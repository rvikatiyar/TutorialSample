package com.tutorial.sample.auth;

import com.tutorial.sample.db.UserStorageInterface;
import com.tutorial.sample.info.UserInfoInterface;

public class AuthorisationService {

	public boolean authorise(UserInfoInterface userInfoInterface, UserStorageInterface userStorageInterface){
		
		String first = userInfoInterface.getName().trim().substring(0, 2);
		String second = userInfoInterface.getDob().trim().substring(0,2);
		String third = userInfoInterface.getPhone().trim().substring(0,2);
		StringBuffer  key = new StringBuffer();
		key.append(first);
		key.append(second);
		key.append(third);
		key = key.reverse();
		
		boolean isAuthorised = userStorageInterface.isKeyPresent(key.toString());
		return isAuthorised;
	}
}
