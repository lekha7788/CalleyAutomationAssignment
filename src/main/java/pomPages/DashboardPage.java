package pomPages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
	private WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	private String callingListTable = "//table[@id='ContentPlaceHolder1_grd_data']";
	public By callingList = By.xpath(callingListTable);

	public String verifyTitle() {
		return driver.getTitle();
	}

	public void getTableContent() {
		System.out.println("Dashboars Page");
		driver.findElement(By.xpath("//span[text()='Dashboard']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(callingListTable))).click();
		// Locate the table
		WebElement table = driver.findElement(callingList); // Replace with actual table locator

		// Get all rows
		List<WebElement> rows = table.findElements(By.tagName("tr"));

		// Loop through each row
		for (WebElement row : rows) {
			// Get all cells in the row
			List<WebElement> cells = row.findElements(By.tagName("td"));

			// Loop through each cell
			for (WebElement cell : cells) {
				System.out.print(cell.getText() + " | ");
			}
			System.out.println();
		}
	}
}
