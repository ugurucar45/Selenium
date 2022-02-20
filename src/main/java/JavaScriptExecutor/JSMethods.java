package JavaScriptExecutor;

import Utils.BrowserUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JSMethods {
    //whenever normal methods are not working then last decision should javaScript.
    @Test
    public void titleMethod() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.techtorialacademy.com/");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());

//        JavascriptExecutor javascriptExecutor= (JavascriptExecutor) driver;
//        String title=javascriptExecutor.executeScript("return document.title").toString();
//        System.out.println(title+" from javaScript");
        String actualTitle = BrowserUtil.getTitleWithJS(driver);
        String expectedTitle = ("Home Page - Techtorial");
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test       // THIS METHOD IS IMPORTANT
    public void clickWithJS() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.techtorialacademy.com/");
        driver.manage().window().maximize();
//        JavascriptExecutor javascriptExecutor= (JavascriptExecutor) driver;
        WebElement browserCourse = driver.findElement(By.xpath("//a[.='Browse Course']"));
//        javascriptExecutor.executeScript("arguments[0].click()",browserCourse);
        BrowserUtil.clickWithJs(driver, browserCourse);
    }

    @Test
    public void clickStudentLogin() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.techtorialacademy.com/");
        driver.manage().window().maximize();
        WebElement studentLogin = driver.findElement(By.xpath("//div[@class='navigation hidden-xs']//a[.='Student login']"));
        //div[@class='sidenav']//a[.='Student login']
        //div[@class='sidenav']//div
        // a[.='Student login']

        BrowserUtil.clickWithJs(driver, studentLogin);
    }

    @Test
    public void scrollIntoView() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
//*[@id="authentication"]/span
        WebElement copyright = driver.findElement(By.xpath("//p[contains(text(),' Copy']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true).click()", copyright);
    }

    /*Task1;
    1)Go to the techtorial academy website
    2)Click Browse Course(with javascript)
    3)scroll down to get started on campus(get started button)
    4)click it with javascript.
     */
    @Test
    public void Task1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.techtorialacademy.com/");
        driver.manage().window().maximize();
        WebElement onCampusCourse = driver.findElement(By.xpath("//*[@id=\"scrollSec\"]/div/div/a[2]"));
        BrowserUtil.clickWithJs(driver, onCampusCourse);
        WebElement clickOnCampus = driver.findElement(By.xpath("//*[@id=\"home\"]/div/div[2]/div/div/a"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true).click()", clickOnCampus);

    }

    @Test
    public void practice() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");
        WebElement browse = driver.findElement(By.xpath("//a[.='Browse Course']"));
        BrowserUtil.clickWithJs(driver, browse);
        WebElement GetStarted = driver.findElement(By.xpath("//h4[.='On-Campus Course']//..//a"));
//            JavascriptExecutor js = (JavascriptExecutor) driver;
////            js.executeScript("arguments[0].scrollIntoView(true)",GetStarted);
        BrowserUtil.scrollWithJS(driver, GetStarted);
        BrowserUtil.clickWithJs(driver, GetStarted);
    }

    @Test
    public void ScroolWithXandYCordinantTest() {
        //This is an interview question(POINT CLASS)
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");
        WebElement copyright = driver.findElement(By.xpath("//p[contains(text(),' Copy')]"));
///        JavascriptExecutor js= (JavascriptExecutor) driver;
//            Point location=copyright.getLocation();
//            System.out.println(location.getX());
//            System.out.println(location.getY());
//            int xCord=location.getX();
//            int yCord=location.getY();
//            js.executeScript("window.scrollTo("+xCord+","+yCord+")");
        BrowserUtil.scrollWithXandYCord(driver, copyright);

    }
}
