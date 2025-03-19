package nykaatest;

import nykaa.Base;
import nykaa.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends Base {
    private HomePage homePage;

    @Test(priority = 1)
    public void testHomePage() {
        homePage = new HomePage(driver);
        String title = homePage.navigate();

        Assert.assertTrue(title.contains("Nykaa"));
    }

    @Test(priority = 2)
    public void testSearch() {
        String searchTitle = homePage.search("Shoes");
        Assert.assertEquals(searchTitle, "Shoes");
    }
}
