package Selenium.Project;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.common.base.Function;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class Scenario4Test {

	ExtentReports report;
	ExtentTest test;
	WebDriver driver;
	Wait<WebDriver> wait;
	// pass scenario
	/*
	 * do tests after lunch
	 */
	@Test(priority = 1, enabled = true)
	public void verifyHomePageLoad() {

		// where to create the report file
		report = new ExtentReports(
				"C:\\Users\\Administrator\\Desktop\\TestNGreports\\Scenario4report.html",
				true);
		// init/start the test
		test = report.startTest("Verify application load");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\Desktop\\Selenium\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver","C:\\Users\\Administrator\\Desktop\\Selenium\\geckodriver.exe");
		driver = new ChromeDriver();
		//driver = new FirefoxDriver();
		driver.get("http://enterprise.demo.orangehrmlive.com");
		// add a note to the test
		test.log(LogStatus.INFO, "Browser started");
		
		WebElement name = driver.findElement(By.id("txtUsername"));
		
		if (name != null){
			// report the test as a pass
			test.log(LogStatus.PASS, "verify page load");
		} else {
			test.log(LogStatus.FAIL, "verify page load");
		}
		report.endTest(test);
		report.flush();
	}
	
	@Test(priority = 2, enabled = true)
	public void verifyLogin() throws IOException {
		
		test = report.startTest("verify the login");
//		System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\Desktop\\Selenium\\chromedriver.exe");
//		//System.setProperty("webdriver.gecko.driver","C:\\Users\\Administrator\\Desktop\\Selenium\\geckodriver.exe");
//		driver = new ChromeDriver();
//		//driver = new FirefoxDriver();
//		driver.get("http://enterprise.demo.orangehrmlive.com");
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//				.withTimeout(30, TimeUnit.SECONDS)
//				.pollingEvery(5, TimeUnit.SECONDS);
//		WebElement foo = wait.until(new Function<WebDriver, WebElement>()
//				{
//			public WebElement apply(WebDriver driver){
//				return driver.findElement(By.id("txtUsername"));
//			}
//				});
		WebElement name = driver.findElement(By.id("txtUsername"));
			name.sendKeys("sysadmin");
		WebElement password = driver.findElement(By.id("txtPassword"));
			password.sendKeys("sysadmin");
		WebElement loginButton = driver.findElement(By.id("btnLogin"));
			loginButton.submit();
		
		WebElement content = driver.findElement(By.id("btnAdd"));
		if (content != null) {
			test.log(LogStatus.PASS, "verify login");
			File scrFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(
					"C:\\Users\\Administrator\\Desktop\\TestNGreports\\screenshot\\img.jpg"));
			String image = test.addScreenCapture(
					"C:\\Users\\Administrator\\Desktop\\TestNGreports\\screenshot\\img.jpg");
			test.log(LogStatus.PASS, "verify login of the application", image);
		} else {
			test.log(LogStatus.FAIL, "verify login");
			
		}
		report.endTest(test);
		report.flush();
		// driver.quit();
	}
	
	@Test(priority = 3, enabled = true)
	public void verifyAdd() throws IOException{
		test = report.startTest("verify the add and save functions");
		WebElement addButton = driver.findElement(By.id("btnAdd"));
			addButton.click();
			Select dropdown = new Select(driver.findElement(By.id("leaveType_operational_country")));
			dropdown.selectByIndex(2);
		WebElement newNameBox = driver.findElement(By.id("leaveType_txtLeaveTypeName"));
			newNameBox.sendKeys("Test Leave");
		WebElement checkBox = driver.findElement(By.id("leaveType_excludeIfNoEntitlement"));
			checkBox.click();
		WebElement saveButton = driver.findElement(By.id("saveButton"));
			saveButton.click();
			WebElement content = driver.findElement(By.id("content"));
			if (content != null) {
				test.log(LogStatus.PASS, "verify the add and save functions");
				File scrFile = ((TakesScreenshot) driver)
						.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File(
						"C:\\Users\\Administrator\\Desktop\\TestNGreports\\screenshot\\img.jpg"));
				String image = test.addScreenCapture(
						"C:\\Users\\Administrator\\Desktop\\TestNGreports\\screenshot\\img.jpg");
				test.log(LogStatus.PASS, "verify the add and save functions", image);
			} else {
				test.log(LogStatus.FAIL, "verify the add and save functions");
				
			}
		report.endTest(test);
		report.flush();
	}
	
	@Test(priority = 4, enabled = true)
	public void verifyLogout() throws IOException{
		Actions actions = new Actions(driver);
		test = report.startTest("verify the logout function");
		WebElement account = driver.findElement(By.id("welcome"));
		WebElement logout = driver.findElement(By.xpath("//*[@id=\"welcome-menu\"]/ul/li[2]/a"));
		actions.click(account).click(logout).build().perform();
		
		WebElement name = driver.findElement(By.id("txtUsername"));
		
		if (name != null){
			// report the test as a pass
			test.log(LogStatus.PASS, "verify page logout");
			File scrFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(
					"C:\\Users\\Administrator\\Desktop\\TestNGreports\\screenshot\\img.jpg"));
			String image = test.addScreenCapture(
					"C:\\Users\\Administrator\\Desktop\\TestNGreports\\screenshot\\img.jpg");
			test.log(LogStatus.PASS, "verify logout of the application", image);
		} else {
			test.log(LogStatus.FAIL, "verify page logout");
		}
		
		report.endTest(test);
		report.flush();
	}
}
