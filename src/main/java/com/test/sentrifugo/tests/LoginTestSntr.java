package com.test.sentrifugo.tests;

import com.test.sentrifugo.pages.LoginPagesSntr;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestSntr {

    @Test
    public void validateSuperAdmin(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.navigate().to("http://demo.sentrifugo.com/index.php/");
        driver.manage().window().maximize();
        WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
        username.sendKeys("EM01");
        WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("sentrifugo");
        WebElement login=driver.findElement(By.xpath("//input[@id='loginsubmit']"));
        login.submit();
        String actualURL=driver.getCurrentUrl();
        String expectedURL="http://demo.sentrifugo.com/index.php/index/welcome";
        Assert.assertEquals(actualURL,expectedURL);
    }

    @Test
    public void validateSuperAdmin2(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("http://demo.sentrifugo.com/index.php/");
        driver.manage().window().maximize();
        LoginPagesSntr loginPagesSntr =new LoginPagesSntr(driver);
        loginPagesSntr.login();
        String actualURL=driver.getCurrentUrl();
        String expectedURL="http://demo.sentrifugo.com/index.php/index/welcome";
        Assert.assertEquals(actualURL,expectedURL);
    }

    @Test
    public void validateManagement(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("http://demo.sentrifugo.com/index.php/");
        driver.manage().window().maximize();
        LoginPagesSntr loginPagesSntr =new LoginPagesSntr(driver);
        loginPagesSntr.dynamicLogin("EM02","sentrifugo");
        String actualURL=driver.getTitle();
        String expectedURL="Sentrifugo - Open Source HRMS";
        Assert.assertEquals(actualURL,expectedURL);
    }
}
