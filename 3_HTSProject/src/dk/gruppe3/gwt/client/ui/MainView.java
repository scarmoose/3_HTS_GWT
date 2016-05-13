package dk.gruppe3.gwt.client.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

import dk.gruppe3.gwt.shared.dtos.Connection;
import dk.gruppe3.gwt.server.service.impl.UserServiceImpl;
import dk.gruppe3.gwt.client.Users;


public class MainView extends Composite implements HasText {

	private VerticalPanel content = new VerticalPanel();
	private MenuView menu;
	private Login login;
	//private Connection connection = new Connection();
	private UserServiceImpl UserS = new UserServiceImpl();
	
	DockPanel aPanel = new DockPanel();
	Users user = new Users();
	
	private AbsolutePanel abPanel = new AbsolutePanel();
	private VerticalPanel vPanel = new VerticalPanel();
	private HorizontalPanel hPanel = new HorizontalPanel();

	Button logs = new Button("Login Site", new ClickHandler() {
		@Override 
		public void onClick(ClickEvent event) {
			try {
				abPanel.clear();
				abPanel.add(login);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	});
	
	public MainView() throws IOException {
		//UserS.Connect();
		initWidget(aPanel);
		aPanel.clear();
		/*aPanel.add(vPanel);
		aPanel.add(hPanel);
		menu = new MenuView(this);
		login = new Login(this);
		hPanel.add(login);
		aPanel.setWidgetPosition(hPanel, Window.getClientWidth()/2 - 156/2, 70);*/
		aPanel.setStyleName("cw-DockPanel");
	    aPanel.setSpacing(4);
	    aPanel.setHorizontalAlignment(DockPanel.ALIGN_CENTER);

		menu = new MenuView(this);
		login = new Login(this);
		abPanel.setPixelSize(Window.getClientWidth()-260, Window.getClientHeight()-35);
		Label label = new Label("Would you like yo login?");
		abPanel.add(label);
		logs.setPixelSize(215, 40);
		aPanel.add(logs, DockPanel.WEST);
		//aPanel.add(menu, DockPanel.WEST);
	    aPanel.add(abPanel, DockPanel.CENTER);

	}

	public void openLogin() throws Exception{
		aPanel.clear();
		aPanel.add(menu, DockPanel.WEST);
		abPanel.clear();
		abPanel.setPixelSize(Window.getClientWidth()-260, Window.getClientHeight()-35);
		Label label = new Label("Welcome "+user.getUserN()+"\n with Sessionkey: "+user.getSessionkey());
		abPanel.add(label);
		aPanel.add(abPanel, DockPanel.CENTER);
		
	}
	
	public void openLogout() throws Exception{
		aPanel.clear();
		abPanel.clear();
		abPanel.setPixelSize(Window.getClientWidth()-260, Window.getClientHeight()-35);
		abPanel.add(login);
		logs.setPixelSize(215, 40);
		aPanel.add(logs, DockPanel.WEST);
	    aPanel.add(abPanel, DockPanel.CENTER);
	}
	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void setText(String text) {
		// TODO Auto-generated method stub
		
	}
}
