package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import objectrepository.RediffHomePage;
import objectrepository.RediffLoginPage;

public class LoginApplication {
	
	@Test
	public void Login() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		RediffLoginPage rd = new RediffLoginPage(driver);
		rd.EmailId().sendKeys("hello");
		rd.password().sendKeys("hello");
		//rd.submit().click();
		RediffHomePage rhp = new RediffHomePage(driver);
		rhp.Search().sendKeys("rediff");
		rhp.Submit().click();
		
	}

}
