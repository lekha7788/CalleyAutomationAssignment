package pomPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class LoginPage {
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	private By signIn = By.linkText("Sign In");
	private By userName = By.name("txtEmailId");
	private By password = By.name("txtPassword");
	private By logInBtn = By.name("btnLogIn");

	public void doLogin(String url, String userEmail, String pass) throws InterruptedException {
		driver.get(url);
		driver.findElement(userName).sendKeys(userEmail);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(logInBtn).click();
		verifyLogin();
	}

	public void verifyLogin() throws InterruptedException {
		System.out.println("In verifyLogin");
		String url = getAppUrl();
		System.out.println(url);
		Assert.assertTrue(url.contains("dashboard"), "Login was Successful");
	}

	public String getAppTitle() {
		return driver.getTitle();
	}

	public String getAppUrl() {
		return driver.getCurrentUrl();
	}
}
