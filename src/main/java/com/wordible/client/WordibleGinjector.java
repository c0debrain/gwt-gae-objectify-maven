package com.wordible.client;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.wordible.client.ui.CharacterPropertiesView;
import com.wordible.client.ui.Main;
import com.wordible.client.ui.CharacterPropertiesViewImpl;

@GinModules(WordibleClientModule.class)
public interface WordibleGinjector extends Ginjector {
	Main getMain();
//	CellTreeExample2 getTree();
}