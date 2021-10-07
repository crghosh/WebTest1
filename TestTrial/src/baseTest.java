import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utility.pageLocators;

public class baseTest extends pageLocators {
	ChromeDriver driver;

	@BeforeTest
	public void testSetup() {
		 ChromeOptions ops = new ChromeOptions();
	        ops.addArguments("--disable-notifications");
	        ops.addArguments("start-maximized");
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		driver = new ChromeDriver(ops);
		driver.get("http://e.ggtimer.com");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	@Test

	public void runTest() {
		try {
		pageLocators page = PageFactory.initElements(driver, pageLocators.class);
		
			new WebDriverWait(driver, 5).until(driver -> ((JavascriptExecutor) driver)
					.executeScript("return document.readyState").equals("complete"));

			//Setting the input for 25 seconds here
			page.setInput("25 Seconds");
			page.clickStart();
			page.clickCollapse();
			for (int i = 25; i >0; i--) {
				//Looping to check all the values of the timer
				Thread.sleep(1000);
				int val = Integer.parseInt(page.getResult().split("\\s")[0]);
				System.out.println("val =" +val);
				System.out.println("i = "+i);
				assertEquals(val==(i-1), true);
			}

		}
		catch(InterruptedException e) {
			e.getStackTrace();
		}
		finally {
			driver.quit();
		}	
		
	}
}

