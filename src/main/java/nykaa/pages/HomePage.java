package nykaa.pages;

import org.openqa.selenium.WebDriver;

public class HomePage {
    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String navigate() {
        driver.get("https://www.nykaa.com");
        return driver.getTitle();
    }
}
