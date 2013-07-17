package com.wordible.client.ui;

import com.github.gwtbootstrap.client.ui.SubmitButton;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.wordible.client.GreetingService;
import com.wordible.client.GreetingServiceAsync;

public class CharacterPropertiesViewImpl extends Composite implements
		CharacterPropertiesView {

	GreetingService service;

	@UiField
	SubmitButton submit;

	interface ViewUiBinder extends
			UiBinder<Widget, CharacterPropertiesViewImpl> {
	}

	public interface Factory {
		CharacterPropertiesViewImpl create();
	}

	@Inject
	public CharacterPropertiesViewImpl(ViewUiBinder uiBinder,
			final GreetingServiceAsync service) {
		initWidget(uiBinder.createAndBindUi(this));
		submit.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				Window.alert("clciked");
				service.greetServer("abc", new AsyncCallback<String>() {
					
					@Override
					public void onSuccess(String result) {
						Window.alert("succc");		
					}
					
					@Override
					public void onFailure(Throwable caught) {
						caught.printStackTrace();
						Window.alert("faill");
					}
				});
			}
		});
	}
}
