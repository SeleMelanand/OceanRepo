package edu.JulyLearning;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleElementsHandling {

	@Test(groups = { "regressionExecution" })
	public void actionClass() throws InterruptedException {	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://oceanacademy.co.in/");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='c-icon']")).click();
		
		List<WebElement> buttonNameList = driver.findElements(By.xpath("//nav[@class='appbar']/div[2]/a"));
		System.out.println("Count of WebElments available :: " + buttonNameList.size());
		
		for (WebElement buttonName : buttonNameList) {
			String details =buttonName.getText();
			System.out.println(details);
		}
		
		WebElement courses = driver.findElement(By.id("courses"));
		Actions action = new Actions(driver);
		action.moveToElement(courses).perform();
		
		WebElement courseType =driver.findElement(By.xpath("//a[text()='Offline Courses']"));
		action.moveToElement(courseType).click().build().perform();       
		}
	  
}
