package seleniumQA1;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OlayRegistration {

	public WebDriver driver;

	@Test
	public void olayReg() throws Exception {
		System.out.println("Registration Started");
		WebDriverWait wait = new WebDriverWait(driver, 10);

		WebElement fname = driver.findElement(By.xpath("//*[@placeholder='First Name']"));
		fname.sendKeys("Arjun");
		WebElement lname = driver.findElement(By.xpath("//*[@placeholder='Last Name']"));
		lname.sendKeys("Arjun");
		WebElement zipcode = driver.findElement(By.xpath("//*[@placeholder='Zip/Postcode']"));
		zipcode.sendKeys("516359");
		WebElement email = driver.findElement(By.xpath("//*[@placeholder='Email Address']"));
		email.sendKeys("mallikarjunap98@gmail.com");

		WebElement passwd = driver.findElement(By.xpath("//*[@placeholder='Password' and @id='FormField_2_input']"));

		passwd.sendKeys("Arjun283.");
		WebElement repwd = driver
				.findElement(By.xpath("//*[@placeholder='Confirm Password' and @id='FormField_3_input']"));
		repwd.sendKeys("Arjun283.");
		Thread.sleep(4000);
		WebElement month = driver.findElement(By.xpath("//select[@class='form-select' and @data-label='month']"));
		month.click();

		Select s1 = new Select(month);
		s1.selectByVisibleText("Mar");

		WebElement year = driver.findElement(By.xpath("//select[@class='form-select' and @data-label='year']"));
		year.click();
		Select s2 = new Select(year);
		s2.selectByValue("1920");

		driver.switchTo().frame(0);

		driver.findElement(By.xpath("//label[@id='recaptcha-anchor-label']")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Join']")).click();
	}

	@BeforeMethod
	public void launchApplication() {

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Workspace\\chromedriver_win32\\chromedriver.exe");
		// Launch the browser
		driver = new ChromeDriver();

		// Launch the application
		driver.get("https://www.olay.com/login.php?action=create_account");
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
