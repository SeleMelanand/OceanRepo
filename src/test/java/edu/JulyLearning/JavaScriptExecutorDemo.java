package edu.JulyLearning;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutorDemo {
	
	@Test
	public void scrollview() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		WebElement sectionToview = driver.findElement(By.xpath("//h2[contains(text(),'Today’s Deals')]/.."));
		// for page scrolldown to specific element
		jse.executeScript("arguments[0]. scrollIntoView(false);", sectionToview);
		

		Thread.sleep(3000);
		WebElement clickAllDetails = driver.findElement(By.linkText("See all deals"));
		// for click
		jse.executeScript("arguments[0].click();", clickAllDetails);

	}

}
