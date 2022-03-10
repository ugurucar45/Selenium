package TestNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterAnnotation {
    @Parameters("FirstName")//if it is just one
    @Test(priority = 1,invocationCount = 4)// do it 4 time this task
    public void test(String name){
        System.out.println(name);
    }


    @Parameters({"City","State"})//if it is more than 1
    @Test(priority = 2,invocationTimeOut = 2000)//it will wait for 2 sec then fail
    public void test1(String city,String state){
        System.out.println(city);
        System.out.println(state);
    }
}