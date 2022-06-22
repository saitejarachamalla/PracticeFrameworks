package Business;

import org.testng.annotations.Test;

import base.BaseTest;

public class Gmail extends BaseTest {
	@Test
	public void gmail(){
		getDriver().get("https://www.gmail.com");
		
	}

}
