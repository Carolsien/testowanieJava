package mavenTest.FormTest;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class FormTest {
	private static WebDriver driver;
	WebElement element;
	
	@BeforeClass
	public static void driverSetup() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void GoToMailTest(){
		driver.get("http://www.onet.pl");
		driver.findElement(By.linkText("Poczta")).click();
		driver.findElement(By.linkText("Zarejestruj się")).click();
	}
	
	@Test
	public void RegisterFormTest(){
		GoToMailTest();
		WebElement surname = driver.findElement(By.id("f_nameSurname"));
		surname.sendKeys("asdaaasd");
		
		WebElement sex = driver.findElement(By.id("f_gender_K"));
		sex.click();
		
		Select birthday = new Select(driver.findElement(By.id("f_birthDate_day")));
		birthday.selectByVisibleText("1");
		
	
		Select birthmonth = new Select(driver.findElement(By.name("birthDate[month]")));
		birthmonth.selectByVisibleText("stycznia");
		
		
		Select birthyear = new Select(driver.findElement(By.name("birthDate[year]")));
		birthyear.selectByVisibleText("2006");

		
		Select country = new Select(driver.findElement(By.id("f_country")));
		country.selectByVisibleText("Polska");
		
		WebElement postCode = driver.findElement(By.id("f_postcodePlace"));
		postCode.sendKeys("11-500 Giżycko");
		
		WebElement domain = driver.findElement(By.id("f_login_domain_6"));
		domain.click();
		
		WebElement passwd = driver.findElement(By.id("f_password"));
		passwd.sendKeys("malekotki");
		
		WebElement confirmpasswd = driver.findElement(By.id("f_confirmPassword"));
		confirmpasswd.sendKeys("malekotki");
		
		WebElement nologout = driver.findElement(By.id("f_perm"));
		nologout.click();
	
		WebElement phone = driver.findElement(By.id("f_phonesEmails"));
		phone.sendKeys("987556743");
		
	}
	
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}
}
