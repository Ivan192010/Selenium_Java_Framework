package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    protected int defaultTimeout;

    public BasePage(WebDriver driver, int timeoutInSeconds) {
        this.driver = driver;
        this.defaultTimeout = timeoutInSeconds;
    }

    protected WebElement WaitForVisibleElement(By locator, Integer timeoutOverride) {
        int time = (timeoutOverride != null) ? timeoutOverride : defaultTimeout;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void MakeClick(By locator, Integer timeoutOverride) {
        WaitForVisibleElement(locator, timeoutOverride).click();
    }

    protected void SendKeys(By locator, String Text, Integer timeoutOverride) {
        WebElement Element = WaitForVisibleElement(locator, timeoutOverride);
        Element.clear();
        Element.sendKeys(Text);
    }

    protected String getText(By locator, Integer timeoutOverride) {
        return WaitForVisibleElement(locator, timeoutOverride).getText();
    }
}

