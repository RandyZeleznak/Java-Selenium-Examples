package com.zsquared.introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://facebook.com");
		driver.findElement(By.xpath("//*[@id=\'email\']")).sendKeys("my self");
		driver.findElement(By.xpath("//*[@id=\'pass\']")).sendKeys("pass it");
		driver.findElement(By.xpath("//*[@id=\"u_0_b\"]")).click();

	}

}
