package com.zsquared.techniques;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartExample {

	public static void main(String[] args) throws InterruptedException {
		String[] itemsNeeded = {"Brocolli", "Cucumber", "Beetroot" };
	
		
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://rahulshettyacademy.com/seleniumPractise/");
		addItems(driver, itemsNeeded);
		
		//Thread.sleep(3000);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		WebDriverWait w = new WebDriverWait(driver, 5);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		
	

	}
	
	public static void addItems(WebDriver driver, String[] itemsNeeded) {
		int j = 0;
		
	List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		
		for(int i =0; i<products.size(); i++) {
			String name [] = products.get(i).getText().split("-");
			String formattedName = name[0].trim();
			
			List itemsNeededList = Arrays.asList(itemsNeeded);
			
			
			
			if(itemsNeededList.contains(formattedName)){
				System.out.println("Veggie = " +formattedName);
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				j++;
				if(j >= itemsNeeded.length) {
					break;
				}
			}
		}
	}
	

}
