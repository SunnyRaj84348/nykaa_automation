package nykaa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Base {
    protected static WebDriver driver;

    @BeforeClass
    public void setup() {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
    }

    @AfterClass
    public void cleanup() {
        driver.quit();
    }
}
