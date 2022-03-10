package com.test.orengehrm;

import org.testng.annotations.DataProvider;

public class DataForLoginNegativeTest {
    @DataProvider(name="LoginNegativeTestScenario")
    public Object[][]getNegativeScenarioData(){
        return  new Object[][]{
                {"Admin","wrongPass","Invalid credentials"},
                {"wrongUser","admin123","Invalid credentials"},
                {"wrongUser","wrongPass","Invalid credentials"}
        };
    }

    @DataProvider(name = "UserRoles")
    public Object[][] getUserRolesData() {
        return new Object[][]{
                {"Admin"},
                {"ESS"}
        };
    }
}
