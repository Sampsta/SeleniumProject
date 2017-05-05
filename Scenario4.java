package Selenium.Project;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scenario4 {

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
		try{
			WebElement name = driver.findElement(By.id("txtUsername"));
				if(name !=null){
					System.out.println("load success");
				}else{
					System.out.println("load failure");
				}
				name.sendKeys("sysadmin");
			WebElement password = driver.findElement(By.id("txtPassword"));
				password.sendKeys("sysadmin");
			WebElement loginButton = driver.findElement(By.id("btnLogin"));
				loginButton.submit();
			WebElement addButton = driver.findElement(By.id("btnAdd"));
				addButton.click();	
//			WebElement country = driver.findElement(By.id("leaveType_operational_country"));	
//				action.clickAndHold(country).build().perform();
			Select dropdown = new Select(driver.findElement(By.id("leaveType_operational_country")));
				dropdown.selectByIndex(2);
			WebElement newNameBox = driver.findElement(By.id("leaveType_txtLeaveTypeName"));
				newNameBox.sendKeys("Test Leave");
			WebElement checkBox = driver.findElement(By.id("leaveType_excludeIfNoEntitlement"));
				checkBox.click();
			WebElement saveButton = driver.findElement(By.id("saveButton"));
				saveButton.click();	
				WebElement account = driver.findElement(By.id("welcome"));
				WebElement logout = driver.findElement(By.xpath("//*[@id=\"welcome-menu\"]/ul/li[2]/a"));
				actions.click(account).click(logout).build().perform();
		}catch(NoSuchElementException e){
			System.out.println("no such element?");
		}
	}
	
}
