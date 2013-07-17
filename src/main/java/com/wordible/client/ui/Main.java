package com.wordible.client.ui;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class Main extends Composite {

	interface MainUiBinder extends UiBinder<Widget, Main> {
	}

	CharacterPropertiesViewImpl.Factory factory;
	
	@Inject
	public Main(MainUiBinder uiBinder, CharacterPropertiesViewImpl.Factory factory) {
		this.factory = factory;
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@UiFactory
	public CharacterPropertiesViewImpl buildProps() {
		return factory.create();
	}
}
