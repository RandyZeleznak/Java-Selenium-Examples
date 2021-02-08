package com.zsquared.techniques;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SSLCertificationDemo {

	public static void main(String[] args) {
		DesiredCapabilities ch = DesiredCapabilities.chrome();
		ch.acceptInsecureCerts();
		ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		ChromeOptions c = new ChromeOptions();
		c.merge(ch);
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(c);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		

	}

}
