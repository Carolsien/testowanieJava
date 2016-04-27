package mavenTest.Gmail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

	@FindBy(name="Email")
	private WebElement emailField;
	
	@FindBy(name="Passwd")
	private WebElement passwordField;
	
	@FindBy(name="signIn")
	private WebElement loginButton;
	
	public Login(WebDriver driver) {
	  PageFactory.initElements(driver, this);
	}

	public void login(String email, String password) {
	  emailField.sendKeys(email);
	  loginButton.submit();
	  passwordField.sendKeys(password);
	  loginButton.submit();
	}
}
