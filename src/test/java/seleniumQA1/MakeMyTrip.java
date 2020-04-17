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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MakeMyTrip {

	public WebDriver driver;

	@Test
	public void bookTicket() throws Exception {
		System.out.println("Booking Started");
		WebDriverWait wait = new WebDriverWait(driver, 10);

		driver.findElement(By.xpath("//li[@data-cy='oneWayTrip']")).click();
		WebElement from = driver.findElement(By.cssSelector("input#fromCity"));
		from.click();
		WebElement fromenter = driver.findElement(By.xpath("//input[@placeholder='From']"));
		fromenter.sendKeys("Hyderabad", Keys.ENTER);
		Thread.sleep(1000);
		fromenter.sendKeys(Keys.DOWN, Keys.ENTER);
		WebElement to = driver.findElement(By.xpath("//input[@placeholder='To']"));
		to.sendKeys("Pune", Keys.ENTER);
		Thread.sleep(1000);
		to.sendKeys(Keys.DOWN, Keys.ENTER);
		driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();

		List<WebElement> list = driver.findElements(
				By.xpath("//div[@class='DayPicker-Body']//following-sibling::div[@aria-disabled='false']"));
		for (WebElement ele : list) {
			String date = ele.getText();
			System.out.println(date);
			if (date.contains("30")) {
				ele.click();
				break;

			}
		}

		Actions act = new Actions(driver);
		WebElement search = driver.findElement(By.xpath("//a[text()='Search']"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Search']")));
		act.moveToElement(search).click().build().perform();
		Thread.sleep(4000);
		WebElement booknow = driver.findElement(By.xpath("//*[contains(text(),'Book')]"));
		act.moveToElement(booknow).click().build().perform();
		Thread.sleep(4000);
		String parent = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		for (String s : allwindows) {
			if (!s.equals(parent)) {
				driver.switchTo().window(s);
				String title = driver.findElement(By.xpath("//div[@class='make_flex alC']//h4")).getText();
				System.out.println("Review the selection in the review page  " + title);
			}
		}

	}

	@Parameters({ "appURL", "browser" })
	@BeforeMethod
	public void launchApplication(String url, String appBrowser) {

		if (appBrowser.contains("Chrome")) {

			// Set the property for Chrome Browser
			System.setProperty("webdriver.chrome.driver",
					"C:\\Selenium Workspace\\chromedriver_win32\\chromedriver.exe");
			// Launch the browser
			driver = new ChromeDriver();
		} else {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Selenium Workspace\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		// Launch the application
		driver.get(url);
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
