package myproject.loginapp.factory;

import myproject.loginapp.service.UserService;
import myproject.loginapp.service.UserServiceImpl;

public class UserServiceFactory {

	private static UserService userService ;
	static {
		userService = new UserServiceImpl();
	}
	
	public static UserService getUserService() {
		return userService;
	}
}
