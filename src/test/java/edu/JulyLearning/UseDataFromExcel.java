package edu.JulyLearning;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UseDataFromExcel extends BrowserLaunch {

	public String excelFileName = "./testdata/sampleTestdata.xlsx";

	@DataProvider(name = "nametobecalled")
	public Object[][] sendData() throws IOException {

		return ReadDataFromExcel.excelRead(excelFileName);
	}

	@Test(dataProvider = "nametobecalled")
	public void printTestdata(String regEmail, String passCode, String createEmail)
			throws InterruptedException, IOException {
		System.out.println(regEmail);
		System.out.println(passCode);
		System.out.println(createEmail);

		
		ChromeBrowserlaunch();
		driver.get("http://automationpractice.com/");
		driver.findElement(By.linkText("Sign in")).click();

		driver.findElement(By.id("email")).sendKeys(regEmail);
		driver.findElement(By.id("passwd")).sendKeys(passCode);
		driver.findElement(By.id("email_create")).sendKeys(createEmail);

		Thread.sleep(3000);
		System.out.println("Data entered successfully");

	}

}
