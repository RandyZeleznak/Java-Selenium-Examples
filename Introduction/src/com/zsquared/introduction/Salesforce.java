package com.zsquared.introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Salesforce {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("Hello");
		driver.findElement(By.name("pw")).sendKeys("122345");
		driver.findElement(By.xpath("//*[@id='Login']")).click();
		System.out.println(driver.findElement(By.cssSelector("div#error.loginError")).getText());
		
		
		

	}

}
