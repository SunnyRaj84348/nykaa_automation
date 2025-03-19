package nykaa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;

public class ProductPage {
    private final WebDriver driver;

    private static final By productLinks = By.xpath("//div[contains(@class, 'productWrapper')]//a");
    private static final By cartButton = By.xpath("(//span[@class='btn-text'])[2]/parent::button");
    private static final By addedToCartButton = By.xpath("//button[@class='css-eb12ax']");
    private static final By cartCount = By.xpath("//span[@class='cart-count']");

    public static HashSet<String> productNames;

    public ProductPage(WebDriver driver) {
        this.driver = driver;

        productNames = new HashSet<>();
    }

    public int addToCart(int productCount) {
        ArrayList<WebElement> productElements = new ArrayList<>(driver.findElements(productLinks));

        String productsWindow = driver.getWindowHandle();

        for (int i = 0; i < productCount; i++) {
            productElements.get(i).click();

            String currentWindow = "";

            for (var window : driver.getWindowHandles()) {
                if (!window.equals(productsWindow)) {
                    currentWindow = window;
                }
            }

            driver.switchTo().window(currentWindow);

            productNames.add(driver.findElement(By.xpath("//h1")).getText().trim().split("\n")[0]);
            driver.findElement(cartButton).click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(ExpectedConditions.presenceOfElementLocated(addedToCartButton));

            driver.close();

            driver.switchTo().window(productsWindow);
        }

        driver.navigate().refresh();

        return Integer.parseInt(driver.findElement(cartCount).getText());
    }
}
