package nykaa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashSet;

public class CartPage {
    private final WebDriver driver;

    private static final By cartButton = By.xpath("//button[@id='header-bag-icon']");
    private static final By cartItems = By.xpath("//span[@data-test-id='product-name']");
    private static final By cartFrame = By.xpath("//iframe[@class='css-wlxg94']");
    private static final By cartBack = By.xpath("//div[contains(@class, 'css-x6gbsc')]");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigate() {
        driver.findElement(cartButton).click();
    }

    public boolean verifyItems() {
        HashSet<String> itemNames = new HashSet<>();
        boolean isMatched = true;

        driver.switchTo().frame(driver.findElement(cartFrame));
        ArrayList<WebElement> cartItemElements = new ArrayList<>(driver.findElements(cartItems));

        for (var element : cartItemElements) {
            itemNames.add(element.getText().trim());
        }

        for (var i : itemNames) {
            if (!ProductPage.productNames.contains(i)) {
                isMatched = false;
                break;
            }
        }

        driver.findElement(cartBack).click();
        driver.switchTo().parentFrame();

        return isMatched;
    }
}
