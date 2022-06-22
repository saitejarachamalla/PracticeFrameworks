package Business;

import org.testng.annotations.Test;
import base.BaseTest;

public class fb extends BaseTest{
	@Test
	public void facebook() {
		getDriver().get("https://www.facekbook.com");
	}
}
