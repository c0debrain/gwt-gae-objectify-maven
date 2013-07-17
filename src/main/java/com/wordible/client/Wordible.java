package com.wordible.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Wordible implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting
	 * service.
	 */
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);

	private final Messages messages = GWT.create(Messages.class);

//	interface Binder extends UiBinder<DockLayoutPanel, Wordible> {
//	}

//	private static final Binder binder = GWT.create(Binder.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		WordibleGinjector injector = GWT.create(WordibleGinjector.class);

//		DockLayoutPanel outer = binder.createAndBindUi(this);

		// Get rid of scrollbars, and clear out the window's built-in margin,
		// because we want to take advantage of the entire client area.
		Window.enableScrolling(false);
		Window.setMargin("0px");

		// Attach two child widgets to a LayoutPanel, laying them out
		// horizontally,
		// splitting at 50%.
		// Widget childOne = new HTML("left"), childTwo = new HTML("right");
		// LayoutPanel x = new LayoutPanel();
		// x.add(injector.getTree());
		// x.add(childTwo);
		//
		// x.setWidgetBottomHeight(injector.getTree(), 0, Unit.PCT, 50,
		// Unit.PCT);
		// x.setWidgetTopHeight(childTwo, 0, Unit.PCT, 50, Unit.PCT);
		//
		// DockLayoutPanel p = new DockLayoutPanel(Unit.EM);
		// // p.addNorth(new HTML("north"), 1);
		// // p.addSouth(new HTML("south"), 1);
		// // p.addEast(new HTML("east"), 1);
		// p.addWest(x, 29);
		// p.setHeight("100%");
		// p.setWidth("100%");

		RootLayoutPanel.get().add(injector.getMain());
	}
}
