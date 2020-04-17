//Verify whether user able to click on all the selectable items and print the selected item names on console in Chrome Browser
package seleniumQA1;

import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SelectItems {

	public WebDriver driver;

	@BeforeMethod
	public void launchApplication() {
		// Set the property for Chrome Browser
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Workspace\\chromedriver_win32\\chromedriver.exe");
		// Launch the browser
		driver = new ChromeDriver();
		// Launch the application
		driver.get("https://demoqa.com/selectable/");
		// Maximize the browser
		driver.manage().window().maximize();
		// Add implicit wait for synchronization
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void clickItems() {
		System.out.println("Program Started");
		// Find the list of web elements and store in List
		List<WebElement> select = driver.findElements(By.xpath("//ol[@class='ui-selectable']//li"));

		for (WebElement item : select) {

			String itemname = item.getAttribute("innerHTML");

			if (itemname.contains("Item")) {
				System.out.println("Item Enabled? " + item.isEnabled());
				// click on items one by one
				item.click();

			}
		}

	}

	@AfterMethod
	// close the window
	public void closebrowser() {
		driver.quit();
		System.out.println("Program Ended");

	}

}
