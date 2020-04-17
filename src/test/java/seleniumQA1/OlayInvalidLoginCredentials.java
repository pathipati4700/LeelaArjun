package seleniumQA1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OlayInvalidLoginCredentials {

	public WebDriver driver;

	@Test
	public void invalidLogin() throws Exception {
		System.out.println("Registration Started");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement login = driver.findElement(By.xpath("//li[@class='navUser-item navUser-item--account']//a"));
		login.click();
		System.out.println("Click on Login successfully");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
		WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
		email.sendKeys("mallikarjunap98@gmail.com");
		WebElement pwd = driver.findElement(By.xpath("//input[@type='password']"));
		pwd.sendKeys("Arjun456");
		driver.findElement(By.xpath("//input[@class='button button--primary event_profile_login_submit']")).click();
		Thread.sleep(3000);
		String cname = driver.findElement(By.xpath("//div[text()='Invalid credentials. Please try again']")).getText();
		System.out.println(cname);
		Assert.assertEquals(cname.contains("Invalid"), true);
	}

	@BeforeMethod
	public void launchApplication() {

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Workspace\\chromedriver_win32\\chromedriver.exe");
		// Launch the browser
		driver = new ChromeDriver();

		// Launch the application
		driver.get("https://www.olay.com/");
		// Maximize the browser
		driver.manage().window().maximize();
		// Add implicit wait for synchronization
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod
	// close the window
	public void closebrowser() {
		driver.quit();
		System.out.println("Program Ended");

	}

}
