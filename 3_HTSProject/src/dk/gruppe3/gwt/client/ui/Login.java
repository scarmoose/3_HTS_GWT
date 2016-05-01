package dk.gruppe3.gwt.client.ui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
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

	LayoutPanel lPanel = new LayoutPanel();
	PasswordTextBox password = new PasswordTextBox();

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
				try {
					main.openLogin();
					userID.setText("");
					password.setText("");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
		});

		vPanel.add(btnOne);	
		btnOne.addStyleName("btnOne");
		vPanel.setBorderWidth(2);
		btnOne.setPixelSize(160, 30);


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

	public PasswordTextBox getPassword() {
		return password;
	}

	public void setPassword(PasswordTextBox password) {
		this.password = password;
	}
	
}
