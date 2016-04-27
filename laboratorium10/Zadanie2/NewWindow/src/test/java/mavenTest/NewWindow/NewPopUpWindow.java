package mavenTest.NewWindow;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class NewPopUpWindow {
	
	private static WebDriver driver;
	WebElement element;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	}
	
	@Test
	public void newUGWindowTest(){
		String parentWindow;
		String childWindow;
		driver.get("https://inf.ug.edu.pl/");
		parentWindow = driver.getWindowHandle();
		driver.findElement(By.linkText("Uniwersytet Gdański")).click();
		driver.switchTo().window(parentWindow);
		driver.close();
    	driver.switchTo().window(driver.getWindowHandles().iterator().next());
    	assertEquals("Serwis główny UG", driver.getTitle());
	}
	
	@Test
	public void FindTest(){
		String parentWindow;
		String childWindow;
		driver.get("https://inf.ug.edu.pl/");
		parentWindow = driver.getWindowHandle();
		driver.findElement(By.linkText("Uniwersytet Gdański")).click();
		driver.switchTo().window(parentWindow);
		driver.close();
    	driver.switchTo().window(driver.getWindowHandles().iterator().next());
		WebElement element = driver.findElement(By.id("edit-search-block-form--2"));
		element.sendKeys("podanie");
		element.submit();
		
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}
}