//Verify whether user able to submit the contact form with all valid details
package seleniumQA1;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterMethod;

public class SubmitContactForm {

	public WebDriver driver;

	@Test
	public void fillContactForm() {
		System.out.println("Program Started");
		// Enter First name
		WebElement firstname = driver.findElement(By.cssSelector("input.firstname"));
		firstname.sendKeys("Arjun");
		// Enter Last name
		WebElement lastname = driver.findElement(By.cssSelector("input#lname"));
		lastname.sendKeys("Pathipati");
		// Enter country name
		WebElement country = driver.findElement(By.xpath("//input[@name='country']"));
		country.sendKeys("India");
		// Enter subject
		WebElement subject = driver.findElement(By.xpath("//textarea[@id='subject']"));
		subject.sendKeys("Part of Testing");
		System.out.println("Before submit form " + driver.getCurrentUrl());
		// Click on submit button
		WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
		submit.click();
		WebElement message = driver.findElement(By.xpath("//h1[contains(text(),'Oops')]"));
		System.out.println(message.getText());
		System.out.println("After submit form " + driver.getCurrentUrl());
		String submittedurl = driver.getCurrentUrl();
		// Verify the application when submit the form
		AssertJUnit.assertEquals(true, submittedurl.contains("onsubmitform?country"));
	}

	@BeforeMethod
	public void launchApplication() {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Workspace\\chromedriver_win32\\chromedriver.exe");
		// Launch the browser
		driver = new ChromeDriver();
		// Launch the application
		driver.get("https://demoqa.com/html-contact-form/");
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
