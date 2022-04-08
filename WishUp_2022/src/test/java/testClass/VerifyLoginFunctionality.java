package testClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class VerifyLoginFunctionality {

	
	@DataProvider(name = "credentials")
	public Object[][] getData()
	{
		return new Object[][]
		{
			{"Valid1","wishup_testuser1@gmail.com","testpw1"},
			{"Valid2","wishup_testuser3@gmail.com","testpw3"},
			{"Valid3","wishup_testuser4@gmail.com","testpw4"},
			{"Invalid","wishup_testuser2@gmail.com","testpw2"}
		};
	}
	
	
	@Test(dataProvider = "credentials")
	public void verifyLoginCredentials(String scenario, String username, String password)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gaurav\\Downloads\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    driver.get("https://app-dev.wishup.co");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		if(scenario.equals("Valid1"))
		{
			WebElement hireButton = driver.findElement(By.xpath("(//a[text()='Hire'])[1]"));
			Assert.assertTrue(hireButton.isDisplayed());
		}
		else if(scenario.equals("Valid2"))
		{
			WebElement hireButton = driver.findElement(By.xpath("(//a[text()='Hire'])[1]"));
			Assert.assertTrue(hireButton.isDisplayed());
		}
		else if(scenario.equals("Valid3"))
		{
			WebElement hireButton = driver.findElement(By.xpath("(//a[text()='Hire'])[1]"));
			Assert.assertTrue(hireButton.isDisplayed());
		}
		else if(scenario.equals("Invalid"))
		{
			WebElement massage = driver.findElement(By.xpath("//div[text()='Please correct error in form']"));
			Assert.assertTrue(massage.isDisplayed());
		}
		
		driver.quit();
	}
	
	
}
