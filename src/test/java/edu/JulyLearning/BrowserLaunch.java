package edu.JulyLearning;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLaunch {
	
	WebDriver driver;

	public void ChromeBrowserlaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.manage().window().maximize();
	}
	
	//@Test(groups = { "dailyExecution" })
	public void retrieveVlaueAndPrint() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/");
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("dresses",Keys.ENTER);
		
		String value = driver.findElement(By.className("login")).getText();
		System.out.println(value);
		//driver.findElement(By.className("login")).click();
		
		
		
		
		
		//String val = driver.findElement(By.xpath("//h1[text()='Authentication']")).getText();
		//System.out.println(val);
	}

}
