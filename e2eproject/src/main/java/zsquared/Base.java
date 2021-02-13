package zsquared;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	public WebDriver driver;
	
	public WebDriver initializeDriver() throws IOException{
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Randy\\udemy\\JavaSelenium\\e2eproject\\src\\main\\java\\zsquared\\data.properties");
		
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if(browserName == "chrome") {
			System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}else if (browserName == "firefox") {
			System.setProperty("webdriver.firefox.driver", "C:\\GeckoDriver\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}else {
			System.out.println("Only CHrome and Firefox");
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}


}
