//Verify whether user able to perform drag and drop action and Verify the text before and after performed drag and drop action
package seleniumQA1;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class Droppable {
	public WebDriver driver;

	@Test
	public void dragAndDrop() {
		System.out.println("Program Started");
		// Find the the source web element
		WebElement drag = driver.findElement(By.cssSelector("div#draggable"));
		// Find the the Target web element
		WebElement drop = driver.findElement(By.cssSelector("div#droppable"));
		Actions action = new Actions(driver);
		System.out.println("Before drag and drop--- " + drop.getText());
		action.dragAndDrop(drag, drop).build().perform();
		System.out.println("After drag and drop--- " + drop.getText());
		String text = drop.getText();
		AssertJUnit.assertEquals(true, text.contains("Dropped!"));

	}

	@BeforeMethod
	public void launchApplication() {
		// Set the property for Chrome Browser
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Workspace\\chromedriver_win32\\chromedriver.exe");
		// Launch the browser
		driver = new ChromeDriver();
		// Launch the application
		driver.get("https://demoqa.com/droppable/");
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
