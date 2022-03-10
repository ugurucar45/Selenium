package TestNG;

import org.junit.Test;
import org.testng.Assert;

public class TestNGAssertion {
    //Create one method that takes two Parameter.xml and return the
    // multiplication of these number

    public int multiplication(int a,int b){
        return (a*b);
    }
    @Test
    public void  validateMultiplication(){
        int ActualResult=multiplication(5,6);
        int ExpectedResult=30;
//        if(ActualResult==ExpectedResult){
//            System.out.println("passed");
//        }
//        Assert.assertSame("my numbers are 5 and 6",ActualResult,ExpectedResult);
//        Assert.assertEquals("my numbers are 5 and 6",ActualResult,ExpectedResult);
        Assert.assertEquals(ActualResult,ExpectedResult);
    }
    public  double getDivision(double num1, double num2){
        if(num1>num2){
            return num1/num2;
        }
        return num2/num1;
    }
    public  int substraction(int num1,int num2){
        if(num1>=num2){
            return num1-num2;
        }
        return num2-num1;
    }

    @Test
    public void validateDivision(){
        double actualRes=getDivision(8,2);
        double expectedRes=(8.0/2.0);
//        Assert.assertSame(actualRes,expectedRes);
        Assert.assertEquals(actualRes,expectedRes);

    }
    @Test
    public void validateSubstraction(){
        int actualRes=substraction(65,43);
        int expectedRes=22;
        Assert.assertSame(actualRes,expectedRes);
        Assert.assertEquals(actualRes,expectedRes);
        double acRes=substraction(6,4);
        double exRes=2.0;
//        Assert.assertSame(acRes,exRes);
        Assert.assertEquals(exRes,acRes);
    }
}
