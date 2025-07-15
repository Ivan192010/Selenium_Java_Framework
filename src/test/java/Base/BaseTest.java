package Base;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import Utils.DriverFactory;
import Pages.HomePage;


public abstract class BaseTest {
    protected WebDriver driver;

    protected HomePage homePage;
    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver,10);
    }



    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
