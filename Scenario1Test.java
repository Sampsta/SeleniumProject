package Selenium.Project;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Scenario1Test {
	ExtentReports report;
	ExtentTest test;
	WebDriver driver;
	// pass scenario
	/*
	 * change all the things here after fixing scenario
	 */
	@Test(priority = 1, enabled = true)
	public void verifyHomePage() {

		report = new ExtentReports(
				"C:\\Users\\Administrator\\Desktop\\TestNGreports\\Scenario1report.html",
				true);
		// init/start the test
		test = report.startTest("Verify application load");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\Desktop\\Selenium\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver","C:\\Users\\Administrator\\Desktop\\Selenium\\geckodriver.exe");
		driver = new ChromeDriver();
		//driver = new FirefoxDriver();
		driver.get("http://www.phptravels.com/demo/");
		// add a note to the test
		test.log(LogStatus.INFO, "Browser started");
		
		WebElement homePage = driver.findElement(By.xpath("/html/body/section[1]/div[1]/div/div/h1"));
		
		if (homePage != null){
			// report the test as a pass
			test.log(LogStatus.PASS, "verify page load");
		} else {
			test.log(LogStatus.FAIL, "verify page load");
		}
		report.endTest(test);
		report.flush();
	}
	
	@Test(priority = 2, enabled = true)
	public void verifySecondPage() {
		
		test = report.startTest("verify the second page loaded");
		WebElement secondPage = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]"));
		if (secondPage != null){
			// report the test as a pass
			test.log(LogStatus.PASS, "verify page load");
		} else {
			test.log(LogStatus.FAIL, "verify page load");
		}
		report.endTest(test);
		report.flush();
	}
}

