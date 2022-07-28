package edu.JulyLearning;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoOnTestNg {
	@Test
	public void testcase1() {
		System.out.println("TestCase 1 executed successfully");
	}	
	@Test
	public void testcase2() {
		System.out.println("TestCase 2 executed successfully");
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("After method annotation executed");
	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before method annotation executed");
	}
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite annotation executed");

	}
	
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class annotation executed");

	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test annotation executed");

	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("After Class annotation executed");

	}
	
}
