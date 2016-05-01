package dk.gruppe3.gwt.client.ui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MenuView extends Composite {
	private VerticalPanel vPanel = new VerticalPanel();


	public MenuView(final MainView main){
		initWidget(this.vPanel);
		this.vPanel.setBorderWidth(1);

		
		//-----------------------------------------------------
		//list-button, opens ListView when pressed
		//-----------------------------------------------------

		Label RLbl = new Label("Your rooms");
		Label MLbl = new Label("Member of");
		Label ALbl = new Label("Admin of");
		
		Button Room000Btn = new Button("Room 000", new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				try {
					
				} catch (Exception e) {
					e.printStackTrace();
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

		RLbl.setPixelSize(150, 30);
		MLbl.setPixelSize(150, 30);
		ALbl.setPixelSize(150, 30);
		Room000Btn.setPixelSize(150, 30);
		Room001Btn.setPixelSize(150, 30);
		Room002Btn.setPixelSize(150, 30);
		logoutBtn.setPixelSize(150, 30);
		vPanel.add(RLbl);
		RLbl.addStyleName("gwt-roomname");
		//vPanel.setCellHorizontalAlignment(RLbl, HasHorizontalAlignment.ALIGN_CENTER );
		vPanel.add(ALbl);
		vPanel.setCellHorizontalAlignment(ALbl, HasHorizontalAlignment.ALIGN_CENTER );
		vPanel.add(Room000Btn);
		vPanel.add(MLbl);
		vPanel.setCellHorizontalAlignment(MLbl, HasHorizontalAlignment.ALIGN_CENTER );
		vPanel.add(Room001Btn);
		vPanel.add(Room002Btn);
		vPanel.add(logoutBtn);
		
	}
}



