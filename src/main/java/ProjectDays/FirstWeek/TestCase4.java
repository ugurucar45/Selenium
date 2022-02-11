package ProjectDays.FirstWeek;

import jdk.internal.dynalink.linker.LinkerServices;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestCase4 {
    @Test
    public void order() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fProcess.aspx");
        driver.manage().window().maximize();
        WebElement username = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");
        WebElement login = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        login.click();
        Thread.sleep(1000);
        WebElement selectProduct = driver.findElement(By.xpath("//*[@id='ctl00_MainContent_fmwOrder_ddlProduct']"));
        selectProduct.sendKeys("ScreenSaver");

        WebElement quantitiy = driver.findElement(By.xpath("//*[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));
        quantitiy.sendKeys("5");

        WebElement customerName = driver.findElement(By.xpath("//*[@id=''ctl00_MainContent_fmwOrder_txtName']"));
        customerName.sendKeys("Techtorial Academy");

        WebElement street = driver.findElement(By.xpath("//*[@id='ctl00_MainContent_fmwOrder_TextBox2']"));
        street.sendKeys("2200 E devon");

        WebElement city = driver.findElement(By.xpath("//*[@id='ctl00_MainContent_fmwOrder_TextBox3']"));
        city.sendKeys("Des Plaines");

        WebElement state = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox4\"]"));
        state.sendKeys("Illinois");

        WebElement zip = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox5\"]"));
        zip.sendKeys("60018");

        WebElement card = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_cardList_1\"]"));
        card.click();

        WebElement cardNumber = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox6\"]"));
        cardNumber.sendKeys("444993876233");

        WebElement expDate = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox1\"]"));
        expDate.sendKeys("03/21");

        WebElement processButton = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_InsertButton\"]"));
        processButton.click();

        WebElement isDisplayed = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder\"]/tbody/tr/td/div/strong"));
        boolean a=isDisplayed.getText().equals("New order has been successfully added."),expected=true;
        Assert.assertEquals(a,expected);

        WebElement clickOrders = driver.findElement(By.xpath("//a[@href='Default.aspx']"));
        clickOrders.click();

        List<WebElement> orders=driver.findElements(By.xpath("//input[@type='checkbox']"));
        boolean actual=false;
        for (WebElement ss:orders){
            if (ss.getText().contains("Techtorial Academy")){
                actual=true;
                break;
            }
        }
        Assert.assertEquals(actual,expected);
    }
}
