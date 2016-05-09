package mavenTest.WebSiteTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

	@FindBy(name="username")
	private WebElement emailField;
	
	@FindBy(name="password")
	private WebElement passwordField;
	
	@FindBy(className="large-blue-button")
	private WebElement loginButton;
	
	public Login(WebDriver driver) {
	  PageFactory.initElements(driver, this);
	}

	public void login(String email, String password) {
	  emailField.sendKeys(email);
	  passwordField.sendKeys(password);
	  loginButton.click();
	}
}
