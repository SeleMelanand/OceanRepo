package edu.JulyLearning;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAccount {
	
	//@Test
	public void createAccountAutomationPractise() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://o3.openmrs.org/openmrs/spa/login");
		driver.findElement(By.id("username")).sendKeys("oceanAca");
		driver.findElement(By.linkText("Contact the site administrator")).click();
		
		String loginUserName = driver.findElement(By.className("account")).getText();
		System.out.println(loginUserName);
		
		Assert.assertTrue(loginUserName.equalsIgnoreCase("satish m"));
		
		
		/*
		 * if(loginUserName.equalsIgnoreCase("satish m")) {
		 * System.out.println("logged in success"); }else {
		 * System.out.println("logged in with wrong user"); }
		 */
		
		Boolean signoutButton = driver.findElement(By.className("logout")).isDisplayed();
		
		WebElement days = driver.findElement(By.id("days"));
		Select selectDays = new Select(days);
		selectDays.selectByValue("3");
		
		
		selectDays.selectByVisibleText("February ");
		
		
	}
	
	@Test

	public void assertDemo() throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://o3.openmrs.org/openmrs/spa/login");
		String titleName = driver.getTitle();
		System.out.println(titleName);
		//Hard Assert 
		Assert.assertTrue(titleName.equalsIgnoreCase("OpenMRS"));	
		System.out.println("Exeuction happened after assert");

		//Soft Assert
		SoftAssert softAssert = new SoftAssert();
		driver.findElement(By.id("username")).sendKeys("admin");
		
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./snapshot/screenshot1.jpeg"));
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		softAssert.assertTrue(driver.findElement(By.id("password")).isDisplayed());
				
		driver.findElement(By.id("password")).sendKeys("Admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		softAssert.assertTrue(driver.findElement(By.xpath("//label[@for='Inpatient Ward']")).isDisplayed());

		driver.findElement(By.xpath("//label[@for='Inpatient Ward']")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		softAssert.assertTrue(driver.findElement(By.xpath("//div[text()='Add Patient']/..")).isDisplayed());
		
		String value = driver.findElement(By.xpath("(//div[contains(@class,'home__home-dashboard')])[1]//p")).getText();
		softAssert.assertTrue(value.equalsIgnoreCase("There are no active visits to display for this locations."));
		
		softAssert.assertAll();
			
		System.out.println("Execution happened after soft assert");
		
	}

}


