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

import org.testng.annotations.Test;

public class OlayForgetPassword {

	public WebDriver driver;

	@Test
	public void loginApp() throws Exception {
		System.out.println("Login Started");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement login = driver.findElement(By.xpath("//li[@class='navUser-item navUser-item--account']//a"));
		login.click();
		System.out.println("Click on Login successfully");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='login_email_popup']")));
		WebElement email = driver.findElement(By.xpath("//input[@id='login_email_popup']"));
		email.sendKeys("mallikarjunap98@gmail.com");
		WebElement forgetpwd = driver.findElement(By.xpath("//*[text()='Forgot Password']"));
		forgetpwd.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("mallikarjunap98@gmail.com");
		driver.findElement(By.xpath("//input[@value='Reset Password']")).click();
		//String msg=driver.findElement(By.xpath("//div[@id='message']")).getText();
	    String curl=driver.getCurrentUrl();
		System.out.println(curl);
		Assert.assertEquals(curl.endsWith("password"), true);

	}

	@BeforeMethod
	public void launchApplication() {

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Workspace\\chromedriver_win32\\chromedriver.exe");
		// Launch the browser
		driver = new ChromeDriver();

		// Launch the application
		driver.get("https://www.olay.com/login.php");
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
