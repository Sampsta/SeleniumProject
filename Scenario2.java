package Selenium.Project;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scenario2 {

	static WebDriver driver;
	static Wait<WebDriver> wait;
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\Desktop\\Selenium\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver","C:\\Users\\Administrator\\Desktop\\Selenium\\geckodriver.exe");
		
		driver = new ChromeDriver();
		//driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 5);
		driver.get("http://enterprise.demo.orangehrmlive.com");
		Actions actions = new Actions(driver);
//		 .	Load homepage
//		 a.	Navigate to login page
//		 b.	Enter details
//		 c.	Navigate to account page
//		 d.	Logout
			try{
				WebElement name = driver.findElement(By.id("txtUsername"));
					if(name !=null){
						System.out.println("load success");
					}else{
						System.out.println("load failure");
					}
					name.sendKeys("linda.anderson");
				WebElement password = driver.findElement(By.id("txtPassword"));
					password.sendKeys("linda.anderson");
				WebElement loginButton = driver.findElement(By.id("btnLogin"));
					loginButton.submit();
				WebElement account = driver.findElement(By.id("welcome"));
					//account.click();
				//for some reason the logout took me like 1 hour of trial and error.
				WebElement logout = driver.findElement(By.xpath("//*[@id=\"welcome-menu\"]/ul/li[2]/a"));
				actions.click(account).click(logout).build().perform();
				//logout.click();
			}catch(NoSuchElementException e){
				System.out.println("exception caught");
			}
	}
	
}
