//Verify whether user able to select  Date of Birth in a Calendar and Validate details when user select the DOB in calendar
package seleniumQA1;

import org.testng.annotations.Test;
import org.testng.Assert;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterMethod;

public class SelectBirthDate {
	public WebDriver driver;

	@Test
	public void datePicker() throws InterruptedException {

		// Select the DOB
		WebElement dob = driver.findElement(By.cssSelector("input#datepicker"));
		dob.sendKeys("06/25/1991");
		// Validate selected month
		WebElement month = driver.findElement(By.cssSelector("span.ui-datepicker-month"));

		String monthvalue = month.getText();
		Assert.assertEquals(true, monthvalue.contains("June"));
		System.out.println("Month selected correctly " + month.getText());
		// Validate selected year
		WebElement year = driver.findElement(By.cssSelector("span.ui-datepicker-year"));

		String yearvalue = year.getText();
		Assert.assertEquals(true, yearvalue.contains("1991"));
		System.out.println("Year selected correctly " + year.getText());
		// Validate selected date
		WebElement date = driver.findElement(By.cssSelector("a[class*='active']"));

		String datevalue = date.getText();
		Assert.assertEquals(true, datevalue.contains("25"));
		System.out.println("Year selected correctly " + date.getText());
		Thread.sleep(3000);

	}

	@BeforeMethod
	public void launchApplication() {
		// Set the property for Chrome Browser
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Workspace\\chromedriver_win32\\chromedriver.exe");
		// Launch the browser
		driver = new ChromeDriver();
		// Launch the application
		driver.get("https://demoqa.com/datepicker/");
		// Maximize the browser
		driver.manage().window().maximize();
		// Add implicit wait for synchronization
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
		System.out.println("Program Ended");
	}

}
