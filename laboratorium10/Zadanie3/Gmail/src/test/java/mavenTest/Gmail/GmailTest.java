package mavenTest.Gmail;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import mavenTest.Gmail.Login;
import junit.framework.Assert;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class GmailTest {

	private static WebDriver driver;
	WebElement element;
	
	@BeforeClass
	public static void driverSetup() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void LogInCorrectTest()
	{
		driver.get("https://gmail.com");
		Login login = new Login(driver);
		login.login("aasd60312", "malekotki");
		assertEquals("Gmail", driver.getTitle());
	}
	
	@Test
	public void LogInInCorrectTest()
	{
		driver.get("https://gmail.com");
		Login login = new Login(driver);
		login.login("aasd60312", "malekotki123");
		List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + "Podany przez Ciebie adres e-mail i hasło nie zgadzają się." + "')]"));
		Assert.assertTrue("Text not found!", list.size() > 0);
	}


	@AfterClass
	public static void cleanp() {
		driver.quit();
	}
}
