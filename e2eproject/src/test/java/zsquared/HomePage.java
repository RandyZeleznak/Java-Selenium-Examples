package zsquared;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;



public class HomePage extends Base{
	private static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized");
		
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String userName, String passWord, String usage) throws IOException {
		
		driver.get(prop.getProperty("url"));
		
		LandingPage lp = new LandingPage(driver);
		lp.getLogin().click();;
		LoginPage logPage = new LoginPage(driver);
		logPage.getEmail().sendKeys(userName);
		logPage.getPassword().sendKeys(passWord);
		logPage.getLogin().click();
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][3];
		data[0][0] = "abc@def.com";
		data[0][1] = "password";
		data[0][2] = "Restricted User";
		
		data[1][0] = "xyz@def.com";
		data[1][1] = "password";
		data[1][2] = "Non-Restricted User";
		
		return data;
		
	}
	
	@AfterTest
	public void teatDown() {
		driver.close();
	}

}
