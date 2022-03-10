package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DataProviderPractice {

//    public  Object[][] getData(){
//        return new Object[][]{
//                {"ugur","ucar","ugur ucar"},
//                {"ahmet","baldir","ahmet baldir"},
//                {"eric","ricxk","eric ricxk"},
//                {"enes","ebeas","enes ebeas"},
//                {"olivia","sharapova","olivia sharapova"},
//                {"george","sergei","george sergei"},
//                {"ivan","ivanova","ivan ivanova"}
//        };
//    }
    @Test(dataProvider = "FullNameTest",dataProviderClass = DataForNames.class)
    public void test1(String username,String lastname,String expected){
        String userName=username;
        String lastName=lastname;
        String fullName=userName+" "+lastName;
        Assert.assertEquals(fullName,expected);
    }
}
