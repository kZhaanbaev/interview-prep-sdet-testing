package data.testData;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;

public class DataProviders {

    @DataProvider(name = "dashboards")
    public static Object[][] dashboards(){
        Object[][] data = new Object[3][1];
        data[0][0] = "All Topics";
        data[1][0] = "Coding";
        data[2][0] = "Soft Skills";

        return data;
    }
}
