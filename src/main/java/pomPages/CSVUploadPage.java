package pomPages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CSVUploadPage {

	private WebDriver driver;

	public CSVUploadPage(WebDriver driver) {
		this.driver = driver;
	}

	private By callList = By.linkText("Call List");
	private By selectImport = By.xpath("//span[text()=\"Add - Power Import\"]");
	private By listName = By.xpath("//input[@placeholder='List Name']");
	private By selectAgent = By.xpath("//button[@title='Please select an agent']");
	private By selectFile = By.xpath("//input[@type='file']");
	private By uploadFileBtn = By.xpath("//*[@id='btnUp']");

	private By col1Title = By.xpath("//select[@id='ddlbelongto_1']");
	private By col2Title = By.xpath("//select[@id='ddlbelongto_2']");
	private By col3Title = By.xpath("//select[@id='ddlbelongto_3']");
	private By importData = By.xpath("//input[@type='submit']");

	public void doUploadFile() throws InterruptedException {
		WebElement List = driver.findElement(callList);
		Actions actions = new Actions(driver);
		actions.moveToElement(List).perform();
		WebElement strdImport = driver.findElement(selectImport);
		strdImport.click();
		driver.findElement(listName).sendKeys("Aravinda");
		driver.findElement(selectAgent).click();
		driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
		driver.findElement(selectFile).sendKeys(
				"/Users/harishbhaskaruni/eclipse-workspace/CalleyTeamsFullSetup/src/main/resources/Resource/SampleTestH.csv");
		Thread.sleep(2000);
		driver.findElement(listName).click();
		driver.findElement(uploadFileBtn).click();
		WebElement okBtn = driver.findElement(By.xpath("//button[text()='Ok']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(okBtn)).click();

		driver.findElement(uploadFileBtn).click();
		okBtn.click();

		wait.until(ExpectedConditions.presenceOfElementLocated(col1Title));

		WebElement firstField = driver.findElement(col1Title);
		Select select = new Select(firstField);
		select.selectByVisibleText("FirstName");
		WebElement secondField = driver.findElement(col2Title);
		select = new Select(secondField);
		select.selectByVisibleText("Phone");
		WebElement thirdField = driver.findElement(col3Title);
		select = new Select(thirdField);
		select.selectByVisibleText("Notes");
		driver.findElement(importData).click();
		driver.findElement(By.xpath("//button[text()=\"OK\"]")).click();
	}

	public String getAppTitle() {
		return driver.getTitle();
	}

	public String getAppUrl() {
		return driver.getCurrentUrl();
	}

}