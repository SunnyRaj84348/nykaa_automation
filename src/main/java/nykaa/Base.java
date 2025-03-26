package nykaa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class Base {
    protected static WebDriver driver;

    @BeforeTest
    public void setup() {
        if (driver == null) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--window-size=1920,1080"); // Set screen size
            options.addArguments("--headless");

            driver = new FirefoxDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.manage().window().maximize();
        }
    }

    @AfterTest
    public void cleanup() {
        driver.quit();
    }
}
