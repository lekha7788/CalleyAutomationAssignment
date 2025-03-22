import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertSame;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FullSetupTest extends BaseClass {
  @Test(priority=1)
  public void verifyLogin() throws InterruptedException {
	  lp.doLogin("https://app.getcalley.com/Login.aspx", "lekha05@gmail.com", "lekha123");
	  System.out.println("In verifyLogin");
	  String currentTitle=lp.getAppTitle();
	  System.out.println("After Login Success: " + currentTitle);
  }
  
  
  @Test(priority=2)
  public void verifyAgent() throws InterruptedException {
	  ap.addAgent();
	  System.out.println(driver.getTitle());
	
  }
  
  
  @Test(priority=3)
  public void verifyimportFile() throws InterruptedException {
	  fileUp.doUploadFile();
	  String importTitle=fileUp.getAppTitle();
	  System.out.println(importTitle);
	  System.out.println(fileUp.getAppUrl());
  }
  
  
  @Test(priority=4)
  public void verifyDashboardPage() {
	  dp.getTableContent();
	  System.out.println(driver.getTitle());

  }
}
