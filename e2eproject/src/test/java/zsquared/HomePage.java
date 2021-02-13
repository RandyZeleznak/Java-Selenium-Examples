package zsquared;

import java.io.IOException;

import org.testng.annotations.Test;
import zsquared.Base;


public class HomePage extends Base{
	
	@Test
	public void basePageNavigation() throws IOException {
		driver = initializeDriver();
		driver.get("http://qaclickacademy.com");
	}

}
