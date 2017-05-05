package Selenium.Project;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scenario3 {
	//Broken :((
	static WebDriver driver;
	static Wait<WebDriver> wait;
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\Desktop\\Selenium\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver","C:\\Users\\Administrator\\Desktop\\Selenium\\geckodriver.exe");
		
		driver = new ChromeDriver();
		//driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 10);
		driver.get("http://www.phptravels.com/demo/");
		
		
		try{
			WebElement homePage = driver.findElement(By.xpath("/html/body/section[1]/div[1]/div/div/h1"));
			if(homePage !=null){
				System.out.println("load success");
			}else{
				System.out.println("load failure");
			}
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("operator_avatar")));
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
		WebElement submit = driver.findElement(By.id("container_9"));
			submit.submit();
			
		}catch(TimeoutException e){
			System.out.println("no element found");
		}
	}
	
}
