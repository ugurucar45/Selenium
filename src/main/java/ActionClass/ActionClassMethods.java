package ActionClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class ActionClassMethods {

    //ContextClick() --> right click    *******
    @Test
    public void ContextClick() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

        WebElement contextMenu = driver.findElement(By.partialLinkText("Context"));
        contextMenu.click();
        WebElement box = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        //ACTION CLASS YOU MUST USE PERFORM AT THE END.
        actions.contextClick(box).perform();
    }

    @Test
    public void hoverOver() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

        WebElement hover = driver.findElement(By.linkText("Hovers"));
        hover.click();
        Thread.sleep(2000);

        Actions actions = new Actions(driver);

        List<WebElement> names = driver.findElements(By.tagName("h5"));
        List<WebElement> pictures = driver.findElements(By.xpath("//div[@class='figure']//img"));
        List<String> expectedNames = Arrays.asList("name: user1", "name: user2", "name: user3");
        for (int i = 0; i < pictures.size(); i++) {
            Thread.sleep(2000);
            actions.moveToElement(pictures.get(i)).perform();       //hover over here
            System.out.println(BrowserUtils.getTextMethod(names.get(i)));//get text here
            Assert.assertEquals(BrowserUtils.getTextMethod(names.get(i)), expectedNames.get(i));
        }


    }

    @Test
    public void doubleClick() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demo.guru99.com/test/simple_context_menu.html\"");
        driver.manage().window().maximize();
        WebElement doubleClickButton = driver.findElement(By.tagName("button"));
        Actions actions = new Actions(driver);
//        actions.doubleClick(doubleClickButton).perform();
//        actions.doubleClick(driver.findElement(By.tagName("button")));

        //RIGHT CLICK PRACTICE

        WebElement elementLocator = driver.findElement(By.xpath("//*[@id=\"authentication\"]/span"));
        actions.contextClick(elementLocator).perform();
    }

    @Test
    public void moveByOffSet() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        driver.manage().window().maximize();
        WebElement slider = driver.findElement(By.xpath("//input"));
        Actions actions = new Actions(driver);
        //x means --> horizontal
        //y means --> vertical
        actions.clickAndHold(slider).moveByOffset(0, 3).perform();
    }

    @Test
    public void sliderPractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        driver.manage().window().maximize();
        WebElement slider = driver.findElement(By.xpath("//input"));
        WebElement range=driver.findElement(By.xpath("//span[@id='range']"));
        String myRange="5";
        while(!range.getText().trim().equals(myRange)){
            Thread.sleep(1000);
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
    }
    /*
    TASK FOR STUDENTS:
    1) navigate https://text-compare.com/
    2)TYPE "Good Bye Keys"
    3)copy paste other side
    4)compare it
     */
    @Test
    public void compareTask() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://text-compare.com/");
        driver.manage().window().maximize();
        WebElement left = driver.findElement(By.xpath("//*[@id=\"inputText1\"]"));
        WebElement right=driver.findElement(By.xpath("//*[@id=\"inputText2\"]"));
        Thread.sleep(1000);

        Actions actions=new Actions(driver);
        Thread.sleep(1000);
        actions.click(left).doubleClick(left).sendKeys("Good Bye Keys").keyDown(org.openqa.selenium.Keys.CONTROL).sendKeys("c").perform();
        actions.click(right).keyDown(Keys.CONTROL).sendKeys("v").perform();
        WebElement button=driver.findElement(By.xpath("//*[@id='compareButton']/div"));
        button.click();

//        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"top\"]/tbody/tr/td[3]/pre/span")).getText(),
//                driver.findElement(By.xpath("//*[@id=\"top\"]/tbody/tr/td[6]/pre/span")).getText());
    }


    @Test
    public void MoveByOffSetPractice(){
        //TASK
        //By using move by off set and point class.
        //Click Contact Us
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");
        WebElement contactUs=driver.findElement(By.xpath("//div[@class='navigation hidden-xs']//a[.='Contact Us']"));
        Point coordinatesOfContactUs=contactUs.getLocation();
        int xCoord=coordinatesOfContactUs.getX();
        int yCoord=coordinatesOfContactUs.getY();
        Actions actions = new Actions(driver);
        actions.moveByOffset(xCoord,yCoord).click().perform();
    }
}
