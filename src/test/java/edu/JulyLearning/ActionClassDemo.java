package edu.JulyLearning;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionClassDemo {
	
	@Test(dependsOnMethods="BrowserLaunch.launchChromeBrowser()")
	public void actionClass() {
				
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://o3.openmrs.org/openmrs/spa/login");
		
		driver.findElement(By.id("username")).sendKeys("admin");
		
		WebElement joinButton = driver.findElement(By.xpath("//button[@type='submit']"));
		joinButton.click();
		
		Actions action = new Actions(driver);
		action.moveToElement(joinButton).click().perform();
		
		
	}

}
