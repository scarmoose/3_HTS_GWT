package dk.gruppe3.gwt.client;

import com.google.gwt.core.client.EntryPoint;

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
		MainView main = new MainView();
	}
}
