package com.zsquared.techniques;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertPractice {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("name")).sendKeys("Randy");
		driver.findElement(By.cssSelector("[id='alertbtn']")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		driver.findElement(By.cssSelector("[id='confirmbtn']")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		driver.findElement(By.cssSelector("[id='confirmbtn']")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();

	}

}
