package dk.gruppe3.gwt.client.service.user;

import dk.gruppe3.gwt.shared.dtos.UserDTO;

public interface UserService {
	
	UserDTO validateUser(String username, String password);
	UserDTO getUser(String userID);
	
}
