package findingelements;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class FindAllLinksUsingCSSSelector {

    ChromeDriver driver ;

    @BeforeTest
    public void opeURL()
    {
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir")+"\\Sources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https:google.com");
    }

    @Test
    public void testFindByCSSSelector()
    {
        List<WebElement> Links = driver.findElements(By.cssSelector("a"));

        for(WebElement link : Links ) {
            System.out.println(link.getText());
            System.out.println(link.getAttribute("href"));
            System.out.println("-----------------------------");
        }
    }
}
