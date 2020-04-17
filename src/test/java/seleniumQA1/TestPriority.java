//Run the TestNG tests based on priority 
package seleniumQA1;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class TestPriority {
	public WebDriver driver;

	@Test(priority = 0)
	public void clickItems() {
		System.out.println("Program Started");

		driver.get("https://demoqa.com/selectable/");
		// Maximize the browser
		driver.manage().window().maximize();
		// Add implicit wait for synchronization
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Find the list of web elements and store in List
		List<WebElement> select = driver.findElements(By.xpath("//ol[@class='ui-selectable']//li"));

		for (WebElement item : select) {

			String itemname = item.getAttribute("innerHTML");

			if (itemname.contains("Item")) {
				System.out.println("Item Enabled? " + item.isEnabled());
				// click on items one by one
				item.click();
				// Get the clicked item text
				System.out.println(item.getText());

			}
		}

	}

	@Test(priority = 2)
	public void datePicker() throws InterruptedException {
		driver.get("https://demoqa.com/datepicker/");
		// Maximize the browser
		driver.manage().window().maximize();
		// Add implicit wait for synchronization
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Select the DOB
		WebElement dob = driver.findElement(By.cssSelector("input#datepicker"));
		dob.sendKeys("06/25/1991");
		// Validate selected month
		WebElement month = driver.findElement(By.cssSelector("span.ui-datepicker-month"));

		String monthvalue = month.getText();
		AssertJUnit.assertEquals(true, monthvalue.contains("June"));
		System.out.println("Month selected correctly " + month.getText());
		// Validate selected year
		WebElement year = driver.findElement(By.cssSelector("span.ui-datepicker-year"));

		String yearvalue = year.getText();
		AssertJUnit.assertEquals(true, yearvalue.contains("1991"));
		System.out.println("Year selected correctly " + year.getText());
		// Validate selected date
		WebElement date = driver.findElement(By.cssSelector("a[class*='active']"));

		String datevalue = date.getText();
		AssertJUnit.assertEquals(true, datevalue.contains("25"));
		System.out.println("Year selected correctly " + date.getText());
		Thread.sleep(3000);

	}

	@Test(priority = 1)
	public void fillContactForm() {
		driver.get("https://demoqa.com/html-contact-form/");
		// Maximize the browser
		driver.manage().window().maximize();
		// Add implicit wait for synchronization
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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

	@Test(priority = 5)
	public void clickonPartialLinkTextOnNewWindow() {
		driver.get("https://demoqa.com/html-contact-form/");
		// Maximize the browser
		driver.manage().window().maximize();
		// Add implicit wait for synchronization
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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

	@Test(priority = 4)
	public void clickonLinkTextOnNewWindow() {
		driver.get("https://demoqa.com/html-contact-form/");
		// Maximize the browser
		driver.manage().window().maximize();
		// Add implicit wait for synchronization
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Program Started");

		java.util.List<WebElement> links = driver.findElements(By.partialLinkText("Google Link"));
		for (WebElement text : links) {
			String textname = text.getText();
			System.out.println(textname);

			if (textname.endsWith("Link")) {

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

	@Test(priority = 6)
	public void dragAndDrop() {
		System.out.println("Program Started");
		driver.get("https://demoqa.com/droppable/");
		// Maximize the browser
		driver.manage().window().maximize();
		// Add implicit wait for synchronization
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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

	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
		System.out.println("Program Ended");
	}

}
