package nykaatest;

import nykaa.Base;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ExampleTest extends Base {
    @Test(priority = 1)
    public void test1() {
        Assert.assertEquals("sometext", "sometext");
    }

    @Test(priority = 2)
    public void test2() {
        Assert.assertTrue(1 == 1);
    }

    @Test(priority = 3)
    public void test3() {
        Assert.assertTrue(1 == 1);
    }

    @Test(priority = 3)
    public void test4() {
        Assert.assertTrue("A".equals('A'));
    }
}
