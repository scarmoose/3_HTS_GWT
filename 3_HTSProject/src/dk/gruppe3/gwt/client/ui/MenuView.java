package dk.gruppe3.gwt.client.ui;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

import dk.gruppe3.gwt.client.Users;
import dk.gruppe3.gwt.server.service.impl.UserServiceImpl;

public class MenuView extends Composite {
	private VerticalPanel vPanel = new VerticalPanel();

	Users user = new Users();
	int runtimes = 0;
	String[] romminfo;
	String roomkey;
	String owner = "";
	String title ="";
	int i = 0;
	int itera = 0;
	
	ArrayList<Button> Adminbuttons = new ArrayList<Button>();
	ArrayList<Button> Memberbuttons = new ArrayList<Button>();

	
	private UserServiceImpl UserS = new UserServiceImpl();
	ArrayList<String> admin = new ArrayList<String>();
	ArrayList<String> member = new ArrayList<String>();
	public MenuView(final MainView main){
		initWidget(this.vPanel);
		this.vPanel.setBorderWidth(1);

		
		//-----------------------------------------------------
		//list-button, opens ListView when pressed
		//-----------------------------------------------------

		final Label RLbl = new Label("Your rooms");
		final Label MLbl = new Label("Member of");
		final Label ALbl = new Label("Admin of");
		
		final Button Room000Btn = new Button("Load rooms", new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				vPanel.clear();
				String str = user.getRoomInfo();
				String[] lokale = str.split("&");
				for(int i = 0; i<lokale.length; i++){
					String[] str2 = lokale[i].split("\"");
					for(int k = 0 ; k < str2.length ; k++){
						if (str2[k]=="OWNER"){
							k=k+2;
							String name = str2[k];
							if(name==user.getUserN()){
								admin.add(lokale[i]);
							}
							else{
								member.add(lokale[i]);
							}
						}
					}
				}
				vPanel.add(RLbl);
				RLbl.addStyleName("gwt-roomname");
				vPanel.add(ALbl);
				vPanel.setCellHorizontalAlignment(ALbl, HasHorizontalAlignment.ALIGN_CENTER );
				for (int t = 0 ; t < admin.size() ; t++){
					final String adminstr = admin.get(t);
					final String[] astring = adminstr.split("\"");
					for(int n = 0; n<astring.length; n++){
						if (astring[n]=="TITLE"){
							n++;
							n++;
							final String titlen = astring[n];
							Adminbuttons.add( new Button(titlen, new ClickHandler(){
								@Override
								public void onClick(ClickEvent event) {
									try {
										String info = adminstr;
										for (int t = 0 ; t < astring.length ; t++){
											if (astring[t]=="ROOMKEY"){
												t++;t++;
												roomkey = astring[t];
											}
										}
										Window.alert("Roomkey: "+roomkey);
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							}) );
							Adminbuttons.get(t).setPixelSize(200, 40);
						}
					}
				}
				for (int b = 0 ; b < Adminbuttons.size() ; b++){
					vPanel.add(Adminbuttons.get(b));
				}
				vPanel.add(MLbl);
				vPanel.setCellHorizontalAlignment(MLbl, HasHorizontalAlignment.ALIGN_CENTER );
				for (int t = 0 ; t < member.size() ; t++){
					final String adminstr = member.get(t);
					final String[] astring = adminstr.split("\"");
					for(int n = 0; n<astring.length; n++){
						if (astring[n]=="TITLE"){
							n++;
							n++;
							final String titlen = astring[n];
							Memberbuttons.add( new Button(titlen, new ClickHandler(){
								@Override
								public void onClick(ClickEvent event) {
									try {
										String info = adminstr;
										for (int t = 0 ; t < astring.length ; t++){
											if (astring[t]=="ROOMKEY"){
												t++;t++;
												roomkey = astring[t];
											}
										}
										Window.alert("Roomkey: "+roomkey);
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							}) );
							Memberbuttons.get(t).setPixelSize(200, 40);
						}
					}
				}
				for (int b = 0 ; b < Memberbuttons.size() ; b++){
					vPanel.add(Memberbuttons.get(b));
				}
			}
		});
		Button Room001Btn = new Button("Room 001", new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				try {
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		Button Room002Btn = new Button("Room 002", new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				try {
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		//-----------------------------------------------------
		//logout-button, reopens LoginView when pressed
		//-----------------------------------------------------

		Button logoutBtn = new Button("LOGOUT", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				try {
					user.setSessionkey("");
					user.setUserN("");
					main.openLogout();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		//-----------------------------------------------------
		//weight-button, opens WeightView when pressed
		//-----------------------------------------------------

		
		
		//-----------------------------------------------------
		//adding buttons to vertical panel, setting pixel size
		//-----------------------------------------------------

		RLbl.setPixelSize(200, 30);
		MLbl.setPixelSize(200, 30);
		ALbl.setPixelSize(200, 30);
		Room000Btn.setPixelSize(200, 40);
		Room001Btn.setPixelSize(200, 40);
		Room002Btn.setPixelSize(200, 40);
		logoutBtn.setPixelSize(200, 40);
		//vPanel.add(RLbl);
		//RLbl.addStyleName("gwt-roomname");
		//vPanel.setCellHorizontalAlignment(RLbl, HasHorizontalAlignment.ALIGN_CENTER );
		vPanel.add(Room000Btn);
		/*vPanel.add(ALbl);
		vPanel.setCellHorizontalAlignment(ALbl, HasHorizontalAlignment.ALIGN_CENTER );
		vPanel.add(MLbl);
		vPanel.setCellHorizontalAlignment(MLbl, HasHorizontalAlignment.ALIGN_CENTER );*/
	
	}
}



