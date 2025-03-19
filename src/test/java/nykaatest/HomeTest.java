package nykaatest;

import nykaa.Base;
import nykaa.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends Base {
    @Test
    public void testHomePage() {
        HomePage homePage = new HomePage(driver);
        String title = homePage.navigate();
        
        Assert.assertTrue(title.contains("Nykaa"));
    }
}
