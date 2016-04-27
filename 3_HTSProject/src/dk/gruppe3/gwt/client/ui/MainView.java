package dk.gruppe3.gwt.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import opr.client.ui.UnitWeightView;


public class MainView extends Composite implements HasText {

	private VerticalPanel content = new VerticalPanel();
	private MenuView menu;
	private Login login;
	private AbsolutePanel aPanel = new AbsolutePanel();
	private VerticalPanel vPanel = new VerticalPanel();
	private HorizontalPanel hPanel = new HorizontalPanel();

	
	public MainView() {
		initWidget(aPanel);
		aPanel.setSize(Integer.toString(Window.getClientWidth()) + "px",
		Integer.toString(Window.getClientHeight()) + "px");
		aPanel.clear();
		aPanel.add(vPanel);
		aPanel.add(hPanel);
		menu = new MenuView(this);
		login = new Login(this);
		hPanel.add(login);
		aPanel.setWidgetPosition(hPanel, Window.getClientWidth()/2 - 156/2, 70);
	}

	public void openLogin() throws Exception{
		content.clear();
		vPanel.clear();
		hPanel.clear();
		vPanel.add(menu);
		Label label = new Label("Welcome User");
		hPanel.add(label);
		label.addStyleName("gwt-title");
		aPanel.setWidgetPosition(vPanel, 10, 70);
		aPanel.setWidgetPosition(hPanel, Window.getClientWidth()/2 - 156/2, 30);
	}
	
	public void openLogout() throws Exception{
		content.clear();
		vPanel.clear();
		hPanel.clear();
		hPanel.add(login);
		aPanel.setWidgetPosition(hPanel, Window.getClientWidth()/2 - 156/2, 70);
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
