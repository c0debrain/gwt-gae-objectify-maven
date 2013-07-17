package com.wordible.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.inject.client.assistedinject.GinFactoryModuleBuilder;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.wordible.client.ui.CharacterPropertiesView;
import com.wordible.client.ui.CharacterPropertiesViewImpl;
import com.wordible.client.ui.Main;

public class WordibleClientModule extends AbstractGinModule {
	protected void configure() {
		bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
//		bind(PlaceController.class).in(Singleton.class);
//		bind(GreetingService.class).in(Singleton.class);
//		bind(CharacterPropertiesView.class).to(CharacterPropertiesViewImpl.class);
		install(new GinFactoryModuleBuilder().build(CharacterPropertiesViewImpl.Factory.class));
	}
	
	@Provides
	@Inject
	PlaceController placeController(EventBus eventBus) {
		return new PlaceController(eventBus);
	}
}