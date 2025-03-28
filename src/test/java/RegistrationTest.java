import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseClass {
	@Test
	public void verifyRegistration() throws InterruptedException {
		 rp.doRegister("https://app.getcalley.com/registration.aspx","Lekha2", "lekha2@gmail.com", "lekha123", "01234567890");
		WebElement confirmMsg = driver.findElement(By.xpath("//button[@class='confirm']"));
		String msg = confirmMsg.getText();
		System.out.println(msg);
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("plan-selection"), "Registration not successful");
		if (currentUrl.contains("plan-selection")) {
			driver.findElement(By.xpath("//div[@id='calleyteamsmodal']")).click();
			driver.findElement(By.partialLinkText("No I want to stay with Free Plan")).click();
		}
	}
}
