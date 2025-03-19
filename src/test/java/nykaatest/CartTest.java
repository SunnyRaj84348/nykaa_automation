package nykaatest;

import nykaa.Base;
import nykaa.pages.CartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends Base {
    @Test
    public void testCart() {
        CartPage cartPage = new CartPage(driver);

        cartPage.navigate();
        boolean isVerified = cartPage.verifyItems();

        Assert.assertTrue(isVerified);
    }
}
