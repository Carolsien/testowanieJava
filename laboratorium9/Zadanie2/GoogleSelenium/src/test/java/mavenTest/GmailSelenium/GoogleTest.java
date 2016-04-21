package mavenTest.GmailSelenium;

import static org.junit.Assert.*;

import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.print.attribute.standard.DateTimeAtCreation;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;

import com.thoughtworks.selenium.webdriven.commands.KeyEvent;

public class GoogleTest {
	
	private static WebDriver driver;
	WebElement element;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	}
	
	@Test
	public void LoginTest(){
		driver.get("http://www.google.pl");
		driver.findElement(By.linkText("Zaloguj się")).click();
		WebElement email = driver.findElement(By.id("Email"));
		email.sendKeys("aasd60312");
		email.submit();
		
		WebElement passwd = driver.findElement(By.name("Passwd"));
		passwd.sendKeys("malekotki");
		passwd.submit();
	
	}
	@Test
	public void KotkiSearchTest(){
		driver.get("http://www.google.pl");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("kotki");
		element.submit();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    assertNotNull(screenshot);
		try {
			FileUtils.copyFile(screenshot, new File("test/resources/kotki.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertTrue(true);
	}
	
	@Test
	public void DownloadTest(){
		FirefoxProfile prof = new FirefoxProfile();
		
		prof.setPreference("browser.download.dir","/opt/devel/workspace/Google/test/resources");
		prof.setPreference("browser.download.folderList", 2);
		prof.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/zip");

		//This will work for all cases mentioned above
		WebDriver driver = new FirefoxDriver(prof);
		driver.get("http://docs.seleniumhq.org/download/");
		driver.findElement(By.xpath("//tr[1]/td[4]/a[text()='Download']")).click();
	}
	

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}
}
