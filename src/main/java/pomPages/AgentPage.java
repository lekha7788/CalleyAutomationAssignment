package pomPages;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AgentPage {
	private WebDriver driver;
	public AgentPage(WebDriver driver) {
		this.driver=driver;
	}
	private By selectTeam=By.linkText("Team");
	private By agents=By.linkText("Agents");
	private By agentName=By.xpath("//input[@placeholder='Enter name']");
	private By agentMobNo=By.xpath("//input[@placeholder='Enter mobile no.']");
	private By agentEmail=By.xpath("//input[@placeholder='Enter email']");
	private By agentPass=By.xpath("//input[@placeholder='Enter password']");
	private By  submitBtn=By.xpath("//input[@type='submit']");
	private By statusMsg=By.xpath("//button[text()=\"OK\"]");
	
	
	public void addAgent() throws InterruptedException {
		String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String chars="ABCDEFGHIJKLMNOPQRSTUVWXYZabcd";
		Random random=new Random();
		char agentNames=chars.charAt(random.nextInt(chars.length()));
		WebElement team=driver.findElement(selectTeam);
		Actions actions=new Actions(driver);
		actions.moveToElement(team).perform();
		WebElement agent=driver.findElement(agents);
		agent.click();
		//Enter Agent Name
		driver.findElement(agentName).sendKeys("abhi"+agentNames);
		//Enter Agent Mobile Number
		driver.findElement(agentMobNo).sendKeys("9898989898");
		//Enter Agent Email
		driver.findElement(agentEmail).sendKeys("abhi123"+timeStamp+"@gmail.com");
		//Enter Agent Password
		driver.findElement(agentPass).sendKeys("123");
		//Enter submit
		driver.findElement(submitBtn).click();
		//Enter status Message
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement status=driver.findElement(statusMsg);
		System.out.println("Agent added status "+ status.getText());
		wait.until(ExpectedConditions.visibilityOf(status)).click();
	}
	

}



