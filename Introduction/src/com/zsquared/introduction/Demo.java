package com.zsquared.introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://google.com");
		driver.findElement(By.xpath("//div[@class='RNNXgb']/div/div[2]/div/input")).sendKeys("Here we go");
	//	driver.get("http://facebook.com");
//		driver.findElement(By.id("email"));
		//System.out.println(driver.getTitle());
		//System.out.println(driver.getCurrentUrl());
	//	System.out.println(driver.getPageSource());

		
		
	//	driver.get("http://yahoo.com");
	//	driver.navigate().back();
		driver.close();
	}

}
