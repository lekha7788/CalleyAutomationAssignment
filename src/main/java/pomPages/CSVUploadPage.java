package pomPages;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

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
	private By listName = By.xpath("(//input[@type='text'])[2]");
	private By selectAgent = By.xpath("//button[@title='Please select an agent']");
	private By selectFile = By.xpath("//input[@id='ContentPlaceHolder1_fileUpload']");
	private By uploadFileBtn = By.xpath("//p[@id='btnUp']");

	private By col1Title = By.xpath("//select[@id='ddlbelongto_1']");
	private By col2Title = By.xpath("//select[@id='ddlbelongto_2']");
	private By col3Title = By.xpath("//select[@id='ddlbelongto_3']");
	private By importData = By.xpath("//input[@type='submit']");
private By currentList=By.xpath("//span[text()='Current List Report']");
	public void doUploadFile() throws InterruptedException {
		String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		WebElement List = driver.findElement(callList);
		Actions actions = new Actions(driver);
		actions.moveToElement(List).perform();
		WebElement strdImport = driver.findElement(selectImport);
		strdImport.click();
		driver.findElement(listName).sendKeys("List1"+timeStamp);
		driver.findElement(selectAgent).click();
		driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
		//driver.findElement(listName).click();
		driver.findElement(selectFile).sendKeys(
				"/Users/harishbhaskaruni/eclipse-workspace/CalleyTeamsFullSetup/src/main/resources/Resource/SampleTestH.csv");
		//Thread.sleep(2000);
		
		driver.findElement(uploadFileBtn).click();
		WebElement okBtn = driver.findElement(By.xpath("//button[text()='Ok']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(okBtn)).click();

		driver.findElement(uploadFileBtn).click();
		Thread.sleep(2000);
		okBtn.click();

		wait.until(ExpectedConditions.presenceOfElementLocated(col1Title));

		WebElement firstField = driver.findElement(col1Title);
		Select select = new Select(firstField);
		select.selectByVisibleText("FirstName");
		Thread.sleep(2000);
		WebElement secondField = driver.findElement(col2Title);
		select = new Select(secondField);
		select.selectByVisibleText("Phone");
		Thread.sleep(2000);

		WebElement thirdField = driver.findElement(col3Title);
		select = new Select(thirdField);
		select.selectByVisibleText("Notes");
		Thread.sleep(2000);

		driver.findElement(importData).click();
		Thread.sleep(4000);

		
		driver.findElement(By.xpath("//button[text()=\"OK\"]")).click();
		WebElement currentListReport=driver.findElement(currentList);
		wait.until(ExpectedConditions.visibilityOf(currentListReport));
		//Thread.sleep(4000);
		

	}

	public String getAppTitle() {
		return driver.getTitle();
	}

	public String getAppUrl() {
		return driver.getCurrentUrl();
	}

}