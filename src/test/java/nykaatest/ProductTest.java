package nykaatest;

import nykaa.Base;
import nykaa.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends Base {
    @Test
    public void testProduct() {
        ProductPage productPage = new ProductPage(driver);
        boolean isAdded = productPage.addToCart();
        Assert.assertTrue(isAdded);
    }
}
