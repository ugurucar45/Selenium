package ActionClass;

import Utils.BrowserUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DoubleClickPractice {

    @Test
    public void ahmetsTask() {
        /*
         //TASK FOR STUDENTS
        /*
        Scenario to Automate:
1. Launch the Chrome web browser.
2. Open a URL "https://selenium08.blogspot.com/2019/11/double-click.html".
3. Locate the element "Double-click".
4.  click on the current location (i.e. on Double-click element).
5. Close the web browser.
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://selenium08.blogspot.com/2019/11/double-click.html");
        driver.manage().window().maximize();
        WebElement button = driver.findElement(By.xpath("//button[.='Double-Click me to see Alert message']"));
        Actions actions = new Actions(driver);
        actions.doubleClick(button).perform();


    }

    @Test
    public void dragAndDrop() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        driver.manage().window().maximize();
        WebElement source = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement target1 = driver.findElement(By.xpath("//*[@id='droptarget']/div[1]"));
        WebElement target2 = driver.findElement(By.xpath("//*[@id='droptarget']/div[2]"));
        String actualMessage = BrowserUtil.getTextMethod(target2);
        String expectedMessage = "... Or here.";
        Assert.assertEquals(actualMessage, expectedMessage);
        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        for (int i = 1; i < 6; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        Thread.sleep(1000);
//        WebElement acceptCookies = driver.findElement(By.id("onetrust-accept-btn-handler"));
//        acceptCookies.click();
//        Thread.sleep(1000);
//        WebElement someOfAd = driver.findElement(By.xpath("//*[@id=\"qual_ol\"]/div[1]/svg[2]"));
//        someOfAd.click();

        actions.dragAndDrop(source, target2).perform();
        Thread.sleep(1000);
        String actualMessage1 = target2.getText().trim();
        String expectedMessage1 = "You did great!";
        Assert.assertEquals(actualMessage1, expectedMessage1);

        String actualcssValue = target2.getCssValue("background-color");
        String expectedCssValue = "rgba(238, 111, 11,1)";
        Assert.assertEquals(actualcssValue, expectedCssValue);


    }

    @Test
    public void ss() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        driver.manage().window().maximize();
        //        WebElement acceptCookies= driver.findElement(By.id("onetrust-accept-btn-handler"));
//        Thread.sleep(3000);
//        acceptCookies.click();
        WebElement bluebox = driver.findElement(By.xpath("//div[@class='test1']"));
        String actualBlueBoxMessage = BrowserUtil.getTextMethod(bluebox);
        String expectedBlueBoxMessage = "Drag the small circle here ...";
        Assert.assertEquals(actualBlueBoxMessage, expectedBlueBoxMessage);
        WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(draggable).moveToElement(bluebox).release().perform();
    }

    @Test
    public void dragAndDropPractice() throws InterruptedException {
        /*
        Please use drag and drop
        1)navigate to "https://demoqa.com/droppable"
        2)Drag-drag me box and drop to drop box
        3)Validate the message is changed to "Dropped"
        4)Validate the css color is steel blue
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/droppable");
        WebElement drag=driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
        WebElement drop=driver.findElement(By.xpath("//*[@id=\"droppable\"]"));
        Actions actions=new Actions(driver);
        Thread.sleep(1000);
        actions.dragAndDrop(drag,drop).perform();
        String actual1=driver.findElement(By.xpath("//*[@id=\"droppable\"]/p")).getText();
        Assert.assertEquals(actual1,"Dropped!");
        String actualColor=drop.getCssValue("background-color");
        String expectedColor="rgba(70, 130, 180, 1)";
        Assert.assertEquals(actualColor,expectedColor);

    }

    @Test
    public void clickAndHoldPractice() throws InterruptedException {
        /*
        1)navigate to "https://demoqa.com/droppable"
        2)click accept
        3)ClickAndHold not accepted box abd release to drop box
        4)validate the background is still white and message is still Drop here
        5)ClickAndHold acceptable box and release to drop box
        6)validate the background is blue and message is dropped
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/droppable");
        WebElement acceptPart=driver.findElement(By.xpath("//*[@id=\"droppableExample-tab-accept\"]"));
        acceptPart.click();
        WebElement notAcceptable=driver.findElement(By.xpath("//*[@id=\"notAcceptable\"]"));
        WebElement acceptable=driver.findElement(By.xpath("//*[@id=\"acceptable\"]"));
        WebElement dropHere=driver.findElement(By.xpath("//*[@id=\"droppable\"]"));

        Actions actions=new Actions(driver);
        Thread.sleep(1000);
        actions.dragAndDrop(notAcceptable,dropHere).perform();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"droppable\"]")).getText(),"Drop here");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"droppable\"]")).getCssValue("background-color"),"rgba(255, 255, 255, 1)");
        Thread.sleep(1000);
        actions.dragAndDrop(acceptable,dropHere).perform();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"droppable\"]")).getText(),"Dropped!");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"droppable\"]")).getCssValue("background-color"),"rgba(70, 130, 180, 1)");


    }

}
