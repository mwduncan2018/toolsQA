package com.angelframework;

import java.util.function.BooleanSupplier;

public class PageOne {
	
	static String url = "http://localhost:54070/Alpha/PageOne";

	public void goTo() {
		Browser.goTo(url);
	}

	public BooleanSupplier isAt() {
		return null;
	}

}
