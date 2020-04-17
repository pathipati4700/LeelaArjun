//perform Cross Browser Testing 
package seleniumQA1;

import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class ParameterizedAndCrossBrowse {

	public WebDriver driver;

	@Parameters({ "URL", "Browser" })
	@BeforeMethod
	public void launchApplication(String appurl, String browsername) {
		// Set the property for Chrome Browser
		if (browsername.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Selenium Workspace\\chromedriver_win32\\chromedriver.exe");
			// Launch the browser
			driver = new ChromeDriver();
		}

		else if (browsername.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium Workspace\\Drivers\\geckodriver.exe");
			// Launch the browser
			driver = new FirefoxDriver();

		} else if (browsername.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver",
					"C:\\Selenium Workspace\\IEDriverServer_x64_3.150.1\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else if (browsername.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver",
					"C:\\Selenium Workspace\\Drivers\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		// Launch the application
		driver.get(appurl);
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
