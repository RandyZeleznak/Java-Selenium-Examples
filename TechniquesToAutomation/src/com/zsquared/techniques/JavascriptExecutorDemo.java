package com.zsquared.techniques;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavascriptExecutorDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,500)");
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=100");
		
		List<WebElement> amounts = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		
		int sum=0;
		for ( int i = 0; i < amounts.size(); i++) {
			sum = sum + Integer.parseInt(amounts.get(i).getText());
			
		}

		System.out.println("Sum = " + sum);
		driver.findElement(By.cssSelector(".totalAmount")).getText();
		int totalAmount = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		Assert.assertEquals(sum, totalAmount);
	}

} 	
