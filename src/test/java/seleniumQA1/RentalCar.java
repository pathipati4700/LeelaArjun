//Automate the rental car 
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

public class RentalCar {

	public WebDriver driver;

	@BeforeMethod
	public void launchApplication() {
		// Set the property for Chrome Browser
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Workspace\\chromedriver_win32\\chromedriver.exe");
		// Launch the browser
		driver = new ChromeDriver();
		// Launch the application
		driver.get("https://demoqa.com/controlgroup/");
		// Maximize the browser
		driver.manage().window().maximize();
		// Add implicit wait for synchronization
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void carRental() throws InterruptedException {
		System.out.println("Program Started");
		// Find the list of web elements and store in List

		driver.findElement(By.xpath("//span[@class='ui-selectmenu-icon ui-icon ui-icon-triangle-1-s']")).click();
		List<WebElement> dropdown = driver
				.findElements(By.xpath("//div[@class='ui-selectmenu-menu ui-front ui-selectmenu-open']"));

		for (WebElement item : dropdown) {

			String itemname = item.getText();
			if (itemname.contains("SUV")) {

				item.click();

				Thread.sleep(2000);
				System.out.println(item.getText());
				break;

			} else {
				System.out.println("Selected wrong value");
			}
		}
		driver.findElement(By.xpath("//*[text()='Standard']")).click();

		driver.findElement(By.xpath("//*[text()='Insurance']")).click();

		driver.findElement(By.xpath("//input[@id='horizontal-spinner']")).sendKeys("3");

		driver.findElement(By.xpath("//button[text()='Book Now!']")).click();

	}

	@AfterMethod
	// close the window
	public void closebrowser() {
		driver.quit();
		System.out.println("Program Ended");

	}

}
