package com.pacheco.ibeth.tablay.domain.exception;

public class UserNotFoundException extends RuntimeException {
	
	public UserNotFoundException(Long userId){
		super("Users with ID " + userId + " not found.");
	}

}
