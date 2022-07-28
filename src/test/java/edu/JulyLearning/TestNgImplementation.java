package edu.JulyLearning;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNgImplementation {
	
	WebDriver driver;

	@BeforeMethod
	public void launchAndGotoApplication() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://www.naukri.com/");
	}
	
	@Test
	public void workingonElmeents() {
		Actions action = new Actions(driver);
		WebElement elementjobs = driver.findElement(By.xpath("(//div[@class='mTxt'])[1]"));
		action.moveToElement(elementjobs).perform(); 
		action.moveToElement(driver.findElement(By.xpath("//a[text()='IT jobs']"))).click().build().perform();
	}
	
	@AfterMethod
	public void browserClose() {
		driver.quit();
	}
	
	
}
