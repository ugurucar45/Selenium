package TestNG;

import org.testng.annotations.*;

public class TestNGAnnotations {
    @BeforeSuite
    public void beforesuite() {
        System.out.println("before suite");
        //You can use to setup your chrome Browser properties
        //(deletecookies)
    }

    @BeforeTest
    public void beforetest() {
        System.out.println("before test");
        //You can use to launch your browser
    }


    @BeforeClass
    public void befoerclass() {
        System.out.println("before class");
        //You can navigate to the website
    }

    @BeforeMethod
    public void beforemethod() {
        System.out.println("before method");
        //You can use it to login the page
    }

    @Test
    public void test1() {
        System.out.println("test1");
    }

    @Test
    public void test2() {
        System.out.println("test2");
    }

    @AfterMethod
    public void aftermethod() {
        System.out.println("after method");
        //YOU CAN TAKE A SCREENSHOT FOR FAILED TEST ANNOTATIONS
        //driver.quit();
    }

    @AfterClass
    public void afterclass() {
        System.out.println("after class");
    }

    @AfterTest
    public void aftertest() {
        System.out.println("after test");
    }

    @AfterSuite
    public void aftersuite() {
        System.out.println("after suite");
    }

}
