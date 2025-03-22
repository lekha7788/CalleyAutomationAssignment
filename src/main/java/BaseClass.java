import org.testng.annotations.Test;

import pomPages.AgentPage;
import pomPages.CSVUploadPage;
import pomPages.DashboardPage;
import pomPages.LoginPage;
import pomPages.RegistrationPage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	public WebDriver driver;
	public RegistrationPage rp;
	public LoginPage lp;
	public AgentPage ap;
	public CSVUploadPage fileUp;
	public DashboardPage dp;

	@BeforeTest
	public void setUp() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		rp = new RegistrationPage(driver);
		lp = new LoginPage(driver);
		ap = new AgentPage(driver);
		fileUp = new CSVUploadPage(driver);
		dp = new DashboardPage(driver);
	}

	@AfterTest
	public void tearDown() {
		//driver.quit();
	}

}
