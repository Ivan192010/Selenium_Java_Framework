package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    private String HomePageUrl = "https://www.youtube.com/";
    private By tendencias = By.cssSelector("a[title='Trending']");
    private By TendencyText = By.cssSelector("h1.dynamic-text-view-model-wiz__h1");
    private By Subscriptions = By.cssSelector("a[href='/feed/subscriptions'][role='link']");
    private By SubsText = By.cssSelector("h1.dynamic-text-view-model-wiz__h1");

    public HomePage(WebDriver driver, int TimeOutInSeconds) {
        super(driver,10);
        this.driver = driver;
    }

    public void openHomePage() {
        driver.get(HomePageUrl);
    }
    
    public void clickTendencias() {
        MakeClick(tendencias,null);
    }

    public String getTextTendencia(String videoName) {
        String text = getText(TendencyText,null);
        return text;
    }

    public void clickSubscriptions() {
        MakeClick(Subscriptions,null);
    }

    public String getTextSubscriptions(String videoName) {
        String text = getText(SubsText,null);
        return text;
    }

}
