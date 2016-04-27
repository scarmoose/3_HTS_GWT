package dk.gruppe3.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

import dk.gruppe3.gwt.client.ui.MainView;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class __HTSProject implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while ";
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		MainView mainView;
		try {
			mainView = new MainView();
			RootPanel.get().add(mainView);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
