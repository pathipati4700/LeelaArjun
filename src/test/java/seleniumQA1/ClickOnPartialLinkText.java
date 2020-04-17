//Verify whether user able to find the Google Link and open in new tab
package seleniumQA1;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterMethod;

public class ClickOnPartialLinkText {
	public WebDriver driver;

	@Test
	public void clickonPartialLinkTextOnNewWindow() {
		System.out.println("Program Started");

		java.util.List<WebElement> links = driver.findElements(By.partialLinkText("Google Link"));
		for (WebElement text : links) {
			String textname = text.getText();
			System.out.println(textname);

			if (textname.endsWith("here")) {

				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				text.sendKeys(Keys.chord(Keys.CONTROL, Keys.RETURN));
				System.out.println(driver.getCurrentUrl());
				break;

			}
		}
		// Handle the multiple windows
		java.util.Set<String> allwindows = driver.getWindowHandles();
		// Convert set to list
		java.util.ArrayList<String> list = new java.util.ArrayList<String>(allwindows);
		// Switch to newly opened link
		driver.switchTo().window(list.get(1));
		System.out.println(driver.getCurrentUrl());

	}

	@BeforeMethod
	public void launchApplication() {
		// Set the property for Chrome Browser
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
