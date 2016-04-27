package dk.gruppe3.gwt.client.service.user;

import com.google.gwt.core.shared.GWT;

import dk.gruppe3.gwt.client.ui.MainView;

public class UserServiceClientImpl {
	
	private UserServiceAsync service;
	private MainView main;
	
	public UserServiceClientImpl(MainView main) {
		this.main = main;
		this.service = GWT.create(UserService.class);
	}

}
