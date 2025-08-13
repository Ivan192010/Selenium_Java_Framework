package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class HomePage extends BasePage{

    private String HomePageUrl = "https://www.youtube.com/";
    private By tendencias = By.cssSelector("a[title='Trending']");
    private By TendencyText = By.cssSelector("h1.dynamic-text-view-model-wiz__h1");
    private By Subscriptions = By.cssSelector("a[href='/feed/subscriptions'][role='link']");
    private By SubsText = By.cssSelector("h1.dynamic-text-view-model-wiz__h1");
    private By BusquedaText = By.cssSelector("input.yt-searchbox-input");
    private By BusquedaButton = By.cssSelector("button.ytSearchboxComponentSearchButton");
    private By SearchChannel = By.cssSelector("a#main-link[href='/@MrBeast']");
    private By videoContainer = By.xpath("//a[@id='video-title']/yt-formatted-string[@class='style-scope ytd-video-renderer']");


    private String busqueda = "MrBeast";

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

    public void clickBusqueda() {
        MakeClick(BusquedaButton,null);
    }

    public void writeBusqueda() {
        SendKeys(BusquedaText,busqueda,null);
    }

    public boolean IsSearchChannelVisible() {
        return isElementVisible(SearchChannel, null);
    }

    public void clickFristVideo() {
        List<WebElement> videos = getElements(videoContainer,null);
        WebElement FirstVideo = videos.get(0);
        if (!videos.isEmpty()) {
            MakeClick(FirstVideo);
        } else {
            throw new RuntimeException("No videos found");
        }
    }
}
