package dk.gruppe3.gwt.client.service.user;

import com.google.gwt.user.client.rpc.AsyncCallback;

import dk.gruppe3.gwt.shared.dtos.UserDTO;

public interface UserServiceAsync {
	
	void validateUser(String username, String password, AsyncCallback<Boolean> callback);
	void getUser(String userID, AsyncCallback<UserDTO> callback);

}
