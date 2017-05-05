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

public class Scenario3Test {

	ExtentReports report;
	ExtentTest test;
	WebDriver driver;
	// pass scenario
	/*
	 * scenario broken - can do minor tests?
	 */
	@Test(priority = 1, enabled = true)
	public void verifyHomePage() {

		report = new ExtentReports(
				"C:\\Users\\Administrator\\Desktop\\TestNGreports\\Scenario3report.html",
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
	public void verifyDetails() throws IOException {
		test = report.startTest("Verify logo of the application");
		
		WebElement clickIcon = driver.findElement(By.id("operator_avatar"));
			clickIcon.click();
		WebElement name = driver.findElement(By.name("name"));
			name.sendKeys("Test");
		WebElement email = driver.findElement(By.name("email"));
			email.sendKeys("test@test.com");
		WebElement subject = driver.findElement(By.name("subject"));
			subject.sendKeys("test");
		WebElement container = driver.findElement(By.id("container_7"));
			container.sendKeys("this is a test");
			
		WebElement homepage = driver.findElement(By.className("container"));
		if (homepage != null) {
			test.log(LogStatus.PASS, "verify logo");
			File scrFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(
					"C:\\Users\\Administrator\\Desktop\\TestNGreports\\screenshot\\img.jpg"));
			String image = test.addScreenCapture(
					"C:\\Users\\Administrator\\Desktop\\TestNGreports\\screenshot\\img.jpg");
			test.log(LogStatus.FAIL, "verify logo of the application", image);
		} else {
			test.log(LogStatus.FAIL, "verify logo");
			
		}
		report.endTest(test);
		report.flush();
		// driver.quit();
	}
	
	@Test(priority = 3, enabled = true)
	public void sendMessage() throws IOException{
		test = report.startTest("Verify logo of the application");
		
		WebElement submit = driver.findElement(By.id("container_9"));
			submit.submit();
		
		WebElement homepage = driver.findElement(By.className("container"));
		if (homepage != null) {
			test.log(LogStatus.PASS, "verify logo");
			File scrFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(
					"C:\\Users\\Administrator\\Desktop\\TestNGreports\\screenshot\\img.jpg"));
			String image = test.addScreenCapture(
					"C:\\Users\\Administrator\\Desktop\\TestNGreports\\screenshot\\img.jpg");
			test.log(LogStatus.FAIL, "verify logo of the application", image);
		} else {
			test.log(LogStatus.FAIL, "verify logo");
			
		}
		
		report.endTest(test);
		report.flush();
	}
}
