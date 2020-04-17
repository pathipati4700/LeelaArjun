package seleniumQA1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OlayDiffLogins {

	public WebDriver driver;

	@Test(dataProvider = "testdata")
	public void loginWithMultipleData(String uname, String password) throws Exception {
		System.out.println("Registration Started");
		// Launch the application
		driver.get("https://www.olay.co.uk/en-gb/loginpage");
		// Maximize the browser
		driver.manage().window().maximize();
		// Add implicit wait for synchronization
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement login = driver.findElement(By.xpath("//li[@class='navUser-item navUser-item--account']//a"));
		login.click();
		System.out.println("Click on Login successfully");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
		WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
		email.sendKeys(uname);
		WebElement pwd = driver.findElement(By.xpath("//input[@type='password']"));
		pwd.sendKeys(password);
		driver.findElement(By.xpath("//input[@class='button button--primary event_profile_login_submit']")).click();
		String url = driver.getTitle();
		System.out.println(url);

	}

	@DataProvider(name = "testdata")
	public Object[][] getData() {

		// Create object array with 2 rows and 2 column- first parameter is row and
		// second is //column
		Object[][] data = new Object[2][2];

		data[0][0] = "mallikarjunap98@gmail.com";

		data[0][1] = "Arjun283";

		data[1][0] = "mallikarjunap98@gmail.com";

		data[1][1] = "Arjun456";

		return data;
	}

	@BeforeMethod
	public void launchApplication() {

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Workspace\\chromedriver_win32\\chromedriver.exe");
		// Launch the browser
		driver = new ChromeDriver();

	}

	@AfterMethod
	// close the window
	public void closebrowser() {
		driver.quit();
		System.out.println("Program Ended");

	}

}
