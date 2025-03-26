package nykaatest;

import nykaa.Base;
import nykaa.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends Base {
    @Test
    public void testProduct() {
        ProductPage productPage = new ProductPage(driver);

        int cartCount = productPage.addToCart(2);
        Assert.assertEquals(cartCount, 2);
    }
}
