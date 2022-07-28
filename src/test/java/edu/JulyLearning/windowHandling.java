package edu.JulyLearning;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class windowHandling {
	
	@Test(enabled= true)
	public void workingonFrames() {
		System.out.println("Executed for 0 priority");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/guru99home/");

		//driver.switchTo().frame("a077aa5e");
				
		WebElement frame1 = driver.findElement(By.id("a077aa5e"));
		driver.switchTo().frame(frame1);

		driver.findElement(By.xpath("html/body/a/img")).click();
		
		driver.switchTo().defaultContent();
		driver.switchTo().parentFrame();
	}
	
	@Test(priority = 2)
	
	public void workingonElements() {
		System.out.println("Executed for 2 priority");

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://www.naukri.com/");
		
		Actions action = new Actions(driver);
		WebElement elementjobs = driver.findElement(By.xpath("(//div[@class='mTxt'])[1]"));
		action.moveToElement(elementjobs).perform(); 
		action.moveToElement(driver.findElement(By.xpath("//a[text()='IT jobs']"))).click().build().perform();
	
	}

	@Test(priority = 1)
	public void Handlewindow() {
		System.out.println("Executed for 1 priority");

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://www.naukri.com/");		
		
		String baseWindow = driver.getWindowHandle();
		System.out.println("base window name :: "+ baseWindow);
		driver.findElement(By.xpath("//div[text()='Register']")).click();
		
		Set<String> windowNameList = driver.getWindowHandles();
		for (String winName : windowNameList) {
			System.out.println("inside for loop :: "+winName);
			if(!winName.equalsIgnoreCase(baseWindow)) {
				driver.switchTo().window(winName);
			}
		}
		
		String headerValue = driver.findElement(By.xpath("//h1[@class='global-title-1']")).getText();
		System.out.println(headerValue);	
	}

}
