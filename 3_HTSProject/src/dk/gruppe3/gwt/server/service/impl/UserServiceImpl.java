package dk.gruppe3.gwt.server.service.impl;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import dk.gruppe3.gwt.client.service.user.UserService;
import dk.gruppe3.gwt.shared.dtos.UserDTO;

public class UserServiceImpl extends RemoteServiceServlet implements UserService {

	@Override
	public UserDTO validateUser(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO getUser(String userID) {
		// TODO Auto-generated method stub
		return null;
	}

}
