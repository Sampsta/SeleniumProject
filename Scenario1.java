package Selenium.Project;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scenario1 {
	//broken ;(
	static WebDriver driver;
	static Wait<WebDriver> wait;
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\Desktop\\Selenium\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver","C:\\Users\\Administrator\\Desktop\\Selenium\\geckodriver.exe");
		
		driver = new ChromeDriver();
		//driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 5);
		driver.get("http://www.phptravels.com/demo/");
//		a.	Load homepage
//		b.	Navigate to product page
//		c.	View multiple products
//		i.	Load up each product page
//		d.	Add one product to basket
//		e.	Proceed to checkout and pay for product
		try{
			WebElement homePage = driver.findElement(By.xpath("/html/body/section[1]/div[1]/div/div/h1"));
			if(homePage !=null){
				System.out.println("load success");
//			}else{
				System.out.println("load failure");
			}
			WebElement goToPage = driver.findElement(By.className("col-md-6"));
				goToPage.click();	
			WebElement goToHotelPage = driver.findElement(By.linkText("Flights"));
				goToHotelPage.click();
			
		}catch(NoSuchElementException e){
			
		}
	}
}
