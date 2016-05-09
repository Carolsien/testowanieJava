package mavenTest.WebSiteTest;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class WebSiteTest {
	private static WebDriver driver;
	WebElement element;
	
	@BeforeClass
	public static void driverSetup() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void CorrectLoginTest(){
		driver.get("http://www.bitbucket.org");
		driver.findElement(By.linkText("Log in")).click();
		
		WebElement name = driver.findElement(By.name("username"));
		name.sendKeys("karolina.rostek.93@gmail.com");
		
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("");
		password.submit();
	}
	
	@Test
	public void CreateRepositoryTest(){
		CorrectLoginTest();
		Date date = new Date();
		driver.findElement(By.linkText("Repositories")).click();
		driver.findElement(By.linkText("Create repository")).click();
		
		WebElement repositoryname = driver.findElement(By.id("id_name"));
		repositoryname.sendKeys("TestRepo" + date);
		
		WebElement advanced = driver.findElement(By.className("repo-create--expand-trigger"));
		advanced.click();	
		
		WebElement description = driver.findElement(By.id("id_description"));
		description.sendKeys("TestRepo");
		
		WebElement projectmanagement = driver.findElement(By.id("id_has_issues"));
		projectmanagement.click();
		
		WebElement profile = driver.findElement(By.id("user-dropdown-trigger"));
		profile.click();
		
		WebElement logout = driver.findElement(By.id("log-out-link"));
		logout.click();
		List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + "Code, Manage, Collaborate" + "')]"));
		Assert.assertTrue("Text not found!", list.size() > 0);
		
	}
	
	@Test
	public void CreateExistingRepositoryTest(){
		
		driver.findElement(By.linkText("Repositories")).click();
		driver.findElement(By.linkText("Create repository")).click();
		
		WebElement repositoryname = driver.findElement(By.id("id_name"));
		repositoryname.sendKeys("CodeMePhp");
		repositoryname.submit();
		List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + "You already have a repository with this name." + "')]"));
		Assert.assertTrue("Text not found!", list.size() > 0);
		
		WebElement profile = driver.findElement(By.id("user-dropdown-trigger"));
		profile.click();
		
		WebElement logout = driver.findElement(By.id("log-out-link"));
		logout.click();
		List<WebElement> list1 = driver.findElements(By.xpath("//*[contains(text(),'" + "Code, Manage, Collaborate" + "')]"));
		Assert.assertTrue("Text not found!", list1.size() > 0);
		
	}
	
	@Test
	public void FindRepositoryTest(){
		CorrectLoginTest();
		WebElement search = driver.findElement(By.id("search-query"));
		search.sendKeys("CodeMePhp");
		search.submit();
		
		WebElement repo = driver.findElement(By.linkText("krostek / CodeMePhp"));
		repo.click();
		List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + "Repository setup" + "')]"));
		Assert.assertTrue("Text not found!", list.size() > 0);
		
		WebElement profile = driver.findElement(By.id("user-dropdown-trigger"));
		profile.click();
		
		WebElement logout = driver.findElement(By.id("log-out-link"));
		logout.click();
		List<WebElement> list1 = driver.findElements(By.xpath("//*[contains(text(),'" + "Code, Manage, Collaborate" + "')]"));
		Assert.assertTrue("Text not found!", list1.size() > 0);
	}
	
	@Test
	public void RenameRepositoryTest(){
		CorrectLoginTest();
		driver.findElement(By.linkText("TestRepo")).click();
		WebElement settings = driver.findElement(By.id("repo-settings-link"));
		settings.click();
		
		WebElement rename = driver.findElement(By.id("id_name"));
		rename.sendKeys("NewTestRepo");
		
		
		WebElement save = driver.findElement(By.xpath("//button[text()='Save repository details']"));
		save.click();
		WebElement rename1 = driver.findElement(By.id("id_name"));
		rename1.clear();
		rename1.sendKeys("TestRepo");

		WebElement save1 = driver.findElement(By.xpath("//button[text()='Save repository details']"));
		save1.click();
		
		WebElement profile = driver.findElement(By.id("user-dropdown-trigger"));
		profile.click();
		
		WebElement logout = driver.findElement(By.id("log-out-link"));
		logout.click();
		List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + "Code, Manage, Collaborate" + "')]"));
		Assert.assertTrue("Text not found!", list.size() > 0);
	}
	
	@Test
	public void Logout(){
		driver.get("http://www.bitbucket.org");
		driver.findElement(By.linkText("Log in")).click();
		
		WebElement name = driver.findElement(By.name("username"));
		name.sendKeys("karolina.rostek.93@gmail.com");
		
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("asdzxc123");
		password.submit();
		
		WebElement profile = driver.findElement(By.id("user-dropdown-trigger"));
		profile.click();
		
		WebElement logout = driver.findElement(By.id("log-out-link"));
		logout.click();
		List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + "Code, Manage, Collaborate" + "')]"));
		Assert.assertTrue("Text not found!", list.size() > 0);
		
	}
	
	
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}
}