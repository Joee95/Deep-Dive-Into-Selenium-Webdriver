package workingwithelements;

import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FileDownloadWithChromeOptions {
	public WebDriver driver;
	public static String downloadPath = System.getProperty("user.dir") + "/Downloads";

	public static ChromeOptions chromeOption() {
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		options.setExperimentalOption("prefs", chromePrefs);
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true); // Use ACCEPT_INSECURE_CERTS instead
		return options;
	}


	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Sources/chromedriver.exe");
		driver = new ChromeDriver(chromeOption());
		driver.navigate().to("http://the-internet.herokuapp.com/download");
		driver.manage().window().maximize();
	}

	@Test
	public void testDownloadFile() throws InterruptedException {
		// Use partial link text or CSS selector to find the download link
		driver.findElement(By.partialLinkText("люблюсики.jpg")).click();
		Thread.sleep(3000); // Consider using explicit wait instead of Thread.sleep()
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
