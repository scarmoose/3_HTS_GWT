package dk.gruppe3.gwt.client.ui;

import dk.gruppe3.gwt.client.Users;
import dk.gruppe3.gwt.server.service.impl.UserServiceImpl;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;


public class Login extends Composite {
	private VerticalPanel vPanel = new VerticalPanel();
	Label lblOne = new Label("User ID ");
	Label lblTwo = new Label("Password ");
	TextBox userID = new TextBox();
	String sessionkey;
	
	int runtimes = 0;
	
	Users user = new Users();
	
	LayoutPanel lPanel = new LayoutPanel();
	PasswordTextBox password = new PasswordTextBox();
	
	private UserServiceImpl UserS = new UserServiceImpl();
	

	public Login(final MainView main){
		this.initWidget(vPanel);
		
		vPanel.add(lblOne);
		vPanel.add(userID);
		vPanel.add(lblTwo);
		vPanel.add(password);
		
		userID.addStyleName("userID");
		userID.setPixelSize(157, 20);
		vPanel.setBorderWidth(2);
		password.addStyleName("password");
		password.setPixelSize(157, 20);
		vPanel.setBorderWidth(2);
	
		Button btnOne = new Button("Login", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				UserS.Connect("loginauth", userID.getText(), password.getText());
				Timer timer = new Timer() {
					public void run() {
						runtimes++;
						if (runtimes==100000)
						{
							Window.alert("100000 forsoeg");
						}
						if(user.getSessionkey()=="")
						{
							run();
						}
						else if(user.getSessionkey()=="fejl" || user.getSessionkey()=="ERROR" || user.getSessionkey()=="failed")
						{
							Window.alert("Brugernavn passer ikke med kodeord. Proev igen.");
						}
						else if(user.getSessionkey().length()==15)
						{
							try {
								main.openLogin();
								clear();
							} 
							catch (Exception e) 
							{
								e.printStackTrace();
							}
						}
					}
				};
				timer.schedule(500);
			}	
		});
		
		Button btn2 = new Button("Create User", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				UserS.CreateUser();
				Timer timer = new Timer() {
					public void run() {
						runtimes++;
						if (runtimes==100000)
						{
							Window.alert("100000 forsoeg");
						}
						if(user.getUserN()=="")
						{
							run();
						}
						else if(user.getUserN()=="fejl" || user.getUserN()=="ERROR" || user.getSessionkey()=="failed")
						{
							Window.alert("Brugernavn passer ikke med kodeord. Proev igen.");
						}
						else if(user.getUserN()!="")
						{
							try {
								Window.alert(user.getUserN());
								clear();
							} 
							catch (Exception e) 
							{
								e.printStackTrace();
							}
						}
					}
				};
				timer.schedule(500);
			}	
		});

		vPanel.add(btnOne);	
		btnOne.addStyleName("btnOne");
		vPanel.setBorderWidth(2);
		btnOne.setPixelSize(160, 30);
		
		vPanel.add(btn2);	
		btn2.addStyleName("btnOne");
		vPanel.setBorderWidth(2);
		btn2.setPixelSize(160, 30);


	}
	
	public void clear() {
		userID.setText("");
		password.setText("");
	}
	
	public String getUName() {
		return userID.getText();
	}
	public String getPassW() {
		return password.getText();
	}
	public TextBox getUserID() {
		return userID;
	}

	public void setUserID(TextBox userID) {
		this.userID = userID;
	}

	public String getSessionkey() {
		return sessionkey;
	}
	
	public void setSessionkey(String sessionkey){
		this.sessionkey = sessionkey;
	}
	
	
	public PasswordTextBox getPassword() {
		return password;
	}

	public void setPassword(PasswordTextBox password) {
		this.password = password;
	}
	
}
