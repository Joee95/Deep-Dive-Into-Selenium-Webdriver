package workingwithelements;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestContextMenu {
	public WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Sources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://swisnl.github.io/jQuery-contextMenu/demo/accesskeys.html");
		driver.manage().window().maximize();
	}

	@Test
	public void testContextMenu() throws InterruptedException {
		WebElement ClickMeBtn = driver.findElement(By.cssSelector("span.context-menu-one.btn.btn-neutral"));
		WebElement contextMenu = driver.findElement(By.cssSelector("li.context-menu-item.context-menu-icon.context-menu-icon-edit"));

		Actions builder = new Actions(driver);
		builder
				.contextClick(ClickMeBtn)
				.moveToElement(contextMenu)
				.click()
				.perform();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.cssSelector("p[class='context']")), "clicked: edit"));

		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		assertEquals(alertText, "clicked: edit");
		alert.dismiss();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
