package edu.JulyLearning;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public RemoteWebDriver driver;

	public void launchBrowser(String url) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();

	}

	public String captureScreenshot() {
		// Taking screenshot
		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination2 = new File("./snaps/snap" + System.currentTimeMillis() + ".jpg");
		String dest = destination2.getAbsolutePath();
		try {
			FileUtils.copyFile(source, destination2);
		} catch (IOException e) {
			System.out.println("Exception occured :: " + e);
		}
		return dest;
	}
}
