package findingelements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SomeUsesOfJavaScriptExecuter {

    private WebDriver driver;

    @BeforeTest
    public void openURL() {
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "\\Sources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();
    }

    @Test
    public void testFindByCSSSelector() {
        WebElement headerLbl = driver.findElement(By.cssSelector("h2"));
        WebElement usernameTxt = driver.findElement(By.cssSelector("input#username"));
        WebElement passwordTxt = driver.findElement(By.cssSelector("input#password"));
        WebElement loginBtn = driver.findElement(By.cssSelector("button.radius"));


        //This is to get title using JS
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String title = (String) js.executeScript("return document.title;");
        System.out.println("Page Title: " + title);

        // Scroll to the bottom of the page
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        // Highlight the login button
        js.executeScript("arguments[0].style.border='3px solid red'", loginBtn);

        // Set value to the username field
        js.executeScript("arguments[0].value='tomsmith';", usernameTxt);

        // Set value to the password field
        js.executeScript("arguments[0].value='SuperSecretPassword!';", passwordTxt);

        // Click the login button
        //js.executeScript("arguments[0].click();", loginBtn);

        /*

        // Handling a disabled element example:
        // Assuming there's an input field with id 'disabledInput' that is disabled
        WebElement disabledInput = driver.findElement(By.id("disabledInput"));

        // Remove the 'disabled' attribute
        js.executeScript("arguments[0].removeAttribute('disabled');", disabledInput);

        // Set value to the now enabled input field
        js.executeScript("arguments[0].value='New Value';", disabledInput);

        // Alternatively, interact directly with a disabled element
        js.executeScript("arguments[0].value='Direct Interaction';", disabledInput);

        */
    }

}
