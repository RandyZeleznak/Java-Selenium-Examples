package com.zsquared.techniques;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarHandlingDemoTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://path2usa.com/travel-companions");
		driver.findElement(By.xpath(".//*[@id='travel_date']")).click();
		
		while(!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("March")) 
		{
			driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
			
		}
		
		
		List<WebElement> dates = driver.findElements(By.className("day"));
		
		int count = driver.findElements(By.className("day")).size();
		System.out.println("Count = " +count);
		
		for(int i =0; i< count; i++) {
			String dayText = driver.findElements(By.className("day")).get(i).getText();
			if(dayText.equalsIgnoreCase("5")) {
				driver.findElements(By.className("day")).get(i).click();
				break;
			}
		}

	}

}
