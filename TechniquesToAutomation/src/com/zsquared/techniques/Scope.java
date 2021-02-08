package com.zsquared.techniques;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://qaclickacademy.com/practice.php");
		System.out.println(driver.findElements(By.tagName("a")).size());
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(columnDriver.findElements(By.tagName("a")).size());
		
		for(int i = 1; i < columnDriver.findElements(By.tagName("a")).size() ; i++) {
			String clickOnLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
			columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLink);
			
		}
			Set<String> tabber = driver.getWindowHandles();
			Iterator<String> iterator = tabber.iterator();
			
			while(iterator.hasNext()){
				driver.switchTo().window(iterator.next());
				System.out.println(driver.getTitle());
			}
		

	}

}
