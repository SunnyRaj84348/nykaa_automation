package nykaatest;

import nykaa.Base;
import nykaa.pages.HomePage;
import org.testng.annotations.Test;

public class HomeTest extends Base {
    @Test
    public void testHomePage() {
        HomePage homePage = new HomePage(driver);
        homePage.navigate();
    }
}
