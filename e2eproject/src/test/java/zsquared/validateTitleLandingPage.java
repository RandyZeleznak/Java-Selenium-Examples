package zsquared;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;



public class validateTitleLandingPage extends Base{
	private static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		//driver.get("http://qaclickacademy.com");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home Page");
	}
	
	@Test
	public void basePageNavigation() throws IOException {
		
		
		LandingPage lp = new LandingPage(driver);
		Assert.assertEquals(lp.getTitle().getText(), "Login");
		log.info("Success Nevigated to Home Landing Page");
		
	}
	
	@AfterTest
	public void teatDown() {
		driver.close();
	}
	


}
