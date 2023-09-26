package org.hook;

import org.baseclass.Baseclass;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hookclass extends Baseclass {
	
	@Before
	public void initialSetup() {
	
		browserLaunch("chrome");
		maximizeWindow();
		loadUrl("https://www.facebook.com/");
	}
	
	@After
	public void finalSetup() {
	
		quiting();

	}

}
