package objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RediffLoginPagePF {
	
	WebDriver driver;
	public RediffLoginPagePF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//*[@id="login1"]

	/*By username = By.xpath(".//*[@id='login1']");
	By password = By.name("passwd");
	By go=By.name("proceed");
	By home = By.linkText("Home");*/
	
	@FindBy(xpath=".//*[@id='login1']")
	WebElement username;
	
	@FindBy(name="passwd")
	WebElement password;
	
	@FindBy(name="proceed")
	WebElement go;
	
	@FindBy(linkText="home")
	WebElement home;
	
	public WebElement EmailId() {
		return username;
		
	}
	
	public WebElement password() {
		return password;
		
	}
	public WebElement submit() {
		return go;
		
	}
	
	public WebElement home() {
		return home;
		
	}
}
