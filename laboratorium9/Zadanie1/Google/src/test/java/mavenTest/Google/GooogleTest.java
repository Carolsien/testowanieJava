package mavenTest.Google;

import static org.junit.Assert.*;

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
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GooogleTest {
	
	private static WebDriver driver;
	WebElement element;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	}
	@Test
	public void TitleTest() {
		driver.get("http://www.google.pl");
		String title = driver.getTitle();
		assertEquals(title, "Google");
	}

	@Test
	public void KotkiSearchTest(){
		driver.get("http://www.google.pl");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("kotki");
		element.submit();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		String titleKotki = driver.getTitle();
		assertEquals(titleKotki, "kotki - Szukaj w Google");
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
	public void GrafikaPage(){
		driver.get("http://www.google.pl/");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("kotki");
		element.submit();
		driver.findElement(By.linkText("Grafika")).click();
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
	public void WUEGF98WGEFVBXUQISYHDTest(){
		driver.get("http://www.google.pl");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("WUEGF98WGEFVBXUQ ISYHD");
		element.submit();
		List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + "Podana fraza" + "')]"));
		Assert.assertTrue("Text not found!", list.size() > 0);}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}
}
