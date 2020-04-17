//Verify whether user able to select  menu options one by one
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

public class SelectMenu {

	public WebDriver driver;

	@BeforeMethod
	public void launchApplication() {
		// Set the property for Chrome Browser
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Workspace\\chromedriver_win32\\chromedriver.exe");
		// Launch the browser
		driver = new ChromeDriver();
		// Launch the application
		driver.get("https://demoqa.com/selectmenu/");
		// Maximize the browser
		driver.manage().window().maximize();
		// Add implicit wait for synchronization
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void selectDropDown() throws InterruptedException {
		System.out.println("Program Started");

		// Click on speed menu
		WebElement speedmenu = driver.findElement(By.xpath("//span[@id='speed-button']"));
		speedmenu.click();
		// Find the list of web elements and store in List
		List<WebElement> select = driver.findElements(By.xpath("//ul[@id='speed-menu']"));

		for (WebElement item : select) {
			String itemname = item.getText();
			System.out.println(itemname);
			if (itemname.contains("Fast")) {
				item.click();
				Thread.sleep(4000);
				System.out.println("Selected correct value ");
				break;

			} else {
				System.out.println("Selected wrong value");

			}
		}

		WebElement filesmenu = driver.findElement(By.xpath("//span[@id='files-button']"));
		filesmenu.click();
		// Find the list of web elements and store in List
		List<WebElement> fileselect = driver.findElements(By.xpath("//ul[@id='files-menu']"));

		for (WebElement fileitem : fileselect) {
			String fileitemname = fileitem.getText();
			System.out.println("Details are " + fileitemname);
			if (fileitemname.contains("Some unknown file")) {
				fileitem.click();
				System.out.println("Selected correct value");
				Thread.sleep(4000);
				break;

			} else {
				System.out.println("Selected wrong value");

			}
		}

		WebElement numbermenu = driver.findElement(By.xpath("//span[@id='number-button']"));
		numbermenu.click();
		// Find the list of web elements and store in List
		List<WebElement> numberselect = driver.findElements(By.xpath("//ul[@id='number-menu']"));

		for (WebElement numberitem : numberselect) {
			String numberitemname = numberitem.getText();
			System.out.println("Details are " + numberitemname);
			if (numberitemname.contains("4")) {
				numberitem.click();
				System.out.println("Selected correct value");
				Thread.sleep(6000);
				break;

			} else {
				System.out.println("Selected wrong value");

			}
		}

		WebElement salutationmenu = driver.findElement(By.xpath("//span[@id='salutation-button']"));
		salutationmenu.click();
		// Find the list of web elements and store in List
		List<WebElement> salutationselect = driver.findElements(By.xpath("//ul[@id='salutation-menu']"));

		for (WebElement salutation : salutationselect) {
			String salutationitemname = salutation.getText();
			System.out.println("Details are " + salutationitemname);
			if (salutationitemname.contains("Dr")) {
				salutation.click();
				System.out.println("Selected correct value");
				Thread.sleep(4000);
				break;

			} else {
				System.out.println("Selected wrong value");

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
