package dk.gruppe3.gwt.server.service.impl;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

import org.eclipse.jetty.util.ajax.JSON;
import org.json.simple.JSONObject;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import dk.gruppe3.gwt.client.service.user.UserService;
import dk.gruppe3.gwt.client.ui.Login;
import dk.gruppe3.gwt.client.ui.MainView;
import dk.gruppe3.gwt.shared.dtos.UserDTO;
import dk.gruppe3.gwt.client.Users;

public class UserServiceImpl {
	
	Users user = new Users();
	MainView main;
	Login login;
	int j = 0;
	int k = 0;
	int runtimes = 0;
	String loks = "";
	String seperator = "&";
	
	public final TextBox seskey = new TextBox();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public void Connect(String task, final String username, String password){

		final String url = "http://52.58.112.107:8080/HelpingTeacherServer2/HTSservlet?logininfo={\"TASK\":\""+ task +"\",\"USERNAME\":\""+ username + "\",\"PASSWORD\":\"" + password + "\"}";
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);
		
		try {
		  Request request = builder.sendRequest(null, new RequestCallback() {
		    public void onError(Request request, Throwable exception) {
		    	Window.alert("Kunne ikke oprettet forbindelse");
		    	user.setSessionkey("ERROR");
		    }

		    public void onResponseReceived(Request request, Response response) {
		      if (200 == response.getStatusCode()) {
		          // Process the response in response.getText()
		    	  String delimiter = "\"";
		    	  String[] temp = response.getText().split(delimiter);
		    	  int i;
		    	  user.setUserN(username);
		    	  user.setSessionkey(temp[7]);
		    	  Rooms("getuser",user.getUserN(),user.getSessionkey());
		      } else {
		    	  user.setSessionkey("fejl");
		    	  
		      }
		    }
		  });
		} catch (RequestException e) {
		  // Couldn't connect to server
		}
		
	}
	
	public void Rooms(String task, final String username, String sessionkey){
	
		final String url = "http://52.58.112.107:8080/HelpingTeacherServer2/HTSservlet?logininfo={\"TASK\":\""+task+"\",\"USERNAME\":\""+username+"\",\"SESSIONKEY\":\""+sessionkey+"\",\"GETNAME\":\""+username+"\"}";
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);
		
		try {
		  Request request = builder.sendRequest(null, new RequestCallback() {
		    public void onError(Request request, Throwable exception) {
		    	Window.alert("Der kunne ikke oprettet forbindelse");
		    	user.setSessionkey("ERROR");
		    }

		    public void onResponseReceived(Request request, Response response) {
		      if (200 == response.getStatusCode()) {
		    	  String str = response.getText(); 
		    	  String result = str.substring(str.indexOf("[") + 1, str.indexOf("]"));
		    	  result = result.replace("\"", "");
		    	  result = result.replace("\\", "");
		    	  user.setRooms(result);
		    	  String str2 = user.getRooms();
					final String[] lokale = str2.split(",");
					try {
						for (k = 0;k<lokale.length;k++){
							SplitRooms(lokale[k]);
							Timer timer = new Timer() {
								public void run() {
									runtimes++;
									if (runtimes==100000)
									{
										Window.alert("100000 forsoeg");
									}
									if(user.getRoomInfo()=="")
									{
										run();
									}
									else if(user.getRoomInfo()=="failed"){
										Window.alert("Kan ikke finde nogle rooms");
									}
									else if(user.getRoomInfo()!=""){
										runtimes = 0;
									}
									
								}
							};
							timer.schedule(200);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
		      } else {
		    	  user.setSessionkey("fejl");
		    	  
		      }
		    }
		  });
		} catch (RequestException e) {
		  // Couldn't connect to server
		}
		
	}
	
	public void SplitRooms(String lokale){
		//String str = user.getRooms();
		//String[] lokale = str.split(",");
		user.setRoomInfo("");
		final String url = "http://52.58.112.107:8080/HelpingTeacherServer2/HTSservlet?logininfo={\"TASK\":\"getroom\",\"USERNAME\":\""+user.getUserN()+"\",\"SESSIONKEY\":\""+user.getSessionkey()+"\",\"ROOMKEY\":\""+lokale+"\"}";
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);
		
		try {
		  Request request = builder.sendRequest(null, new RequestCallback() {
		    public void onError(Request request, Throwable exception) {
		    	Window.alert("Get Rekt");
		    	user.setSessionkey("ERROR");
		    }

		    public void onResponseReceived(Request request, Response response) {
		      if (200 == response.getStatusCode()) {
		    	  	user.setRoomInfo(user.getRoomInfo()+response.getText()+"&");
		      } else {
		    	  user.setSessionkey("fejl");
		      }
		    }
		  });
		} catch (RequestException e) {
		  // Couldn't connect to server
		}
				
	}
}
