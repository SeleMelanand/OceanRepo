package edu.JulyLearning;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataFromStringArray extends BrowserLaunch {


	@DataProvider(name = "ocean")
	public Object[][] getTestdata() {
		
		String[][] employee = new String[1][3];
		
		employee[0][0] = "registeredemail001@gemail.com";
		employee[0][1] = "22222";
		employee[0][2] = "createemail001@gemail.com";

		//employee[1][0] = "registeredemail002@gemail.com";
		//employee[1][1] = "44444";
		//employee[1][2] = "createemail002@gemail.com";

		return employee;

	}

	@Test(dataProvider = "ocean")
	public void enterDataUsingString(String regEmail, String passCode, String createEmail) throws InterruptedException {
		
		System.out.println(regEmail);
		System.out.println(passCode);
		System.out.println(createEmail);
		ChromeBrowserlaunch();
		driver.get("http://automationpractice.com/");
		driver.findElement(By.linkText("Sign in")).click();
		Thread.sleep(5000);

		driver.findElement(By.id("email")).sendKeys(regEmail);
		driver.findElement(By.id("passwd")).sendKeys(passCode);
		driver.findElement(By.id("email_create")).sendKeys(createEmail);

		Thread.sleep(3000);
		System.out.println("Data entered successfully");
	}

}
