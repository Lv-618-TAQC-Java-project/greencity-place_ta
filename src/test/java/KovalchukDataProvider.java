import org.testng.annotations.DataProvider;

public class KovalchukDataProvider {
    @DataProvider
    public static Object[][] orderDateDataProvider(){
        Object[][] testData= new Object[][]{
            {"1530", "08/09/2021"},
            {"1532", "08/09/2021"}
        };
        return testData;
    }
}
