package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public WebDriver driver;
	
	
	By signin = By.cssSelector("a[href*='sign_in']");
	By title = By.cssSelector(".text-center>h2");
	By navbar = By.cssSelector("#homepage > header > div.navbar.navbar-default.navbar-static-top > div > nav");
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getLogin() {
		return driver.findElement(signin);
	}
	
	public WebElement getNavBar() {
		return driver.findElement(navbar);
	}

	public WebElement getTitle() {
		return driver.findElement(signin);
	}

}
