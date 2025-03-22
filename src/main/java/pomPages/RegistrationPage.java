package pomPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
	private WebDriver driver;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
	}

	private By userName = By.name("txtName");
	private By userEmail = By.name("txtEmail");
	private By userPassword = By.name("txtPassword");
	private By userMobile = By.name("txt_mobile");
	private By captchaCheckbox = By.xpath("//div[@class='recaptcha-checkbox-border']");
	private By signUpCheckbox = By.xpath("//input[@id='checkbox-signup']/parent::div");
	private By signUpBtn = By.name("btnSignUp");

	public void doRegister(String url, String un, String email, String pass, String mobNum)
			throws InterruptedException {
		driver.get(url);
		driver.findElement(userName).sendKeys(un);
		driver.findElement(userEmail).sendKeys(email);
		driver.findElement(userPassword).sendKeys(pass);
		driver.findElement(userMobile).sendKeys(mobNum);
		driver.switchTo().frame(0);
		// select captchaCheckbox
		driver.findElement(captchaCheckbox).click();
		Thread.sleep(30000);

		driver.switchTo().defaultContent();
		// Select signUp checkbox
		driver.findElement(signUpCheckbox).click();
		// Click on signUp button
		driver.findElement(signUpBtn).click();
	}

}
