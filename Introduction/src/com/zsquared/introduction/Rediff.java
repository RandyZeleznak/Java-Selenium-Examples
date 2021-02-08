package com.zsquared.introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Rediff {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://rediff.com");
		driver.findElement(By.cssSelector("a[title*='Sign in']")).click();
		driver.findElement(By.xpath("//input[@id='login1']")).sendKeys("Hey Yoy");
		driver.findElement(By.cssSelector("input#password")).sendKeys("Goody");
		driver.findElement(By.xpath("//input[contains(@name, 'procee')]")).click();

	}

}
