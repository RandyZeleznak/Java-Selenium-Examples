package com.zsquared.techniques;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice");
		
		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		for(WebElement link : links) {
			String url = link.getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respCode = conn.getResponseCode();
			System.out.println("RespCode = " +respCode);
			if(respCode>400) {
				System.out.println("The link "+link+" is broken with code "+respCode);
				Assert.assertTrue(false);
			}
			
		}
		
	}

}
