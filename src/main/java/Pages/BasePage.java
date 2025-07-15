package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {
    protected WebDriver driver;
    protected int defaultTimeout;

    public BasePage(WebDriver driver, int timeoutInSeconds) {
        this.driver = driver;
        this.defaultTimeout = timeoutInSeconds;
    }

    protected void MakeClick(By locator, Integer timeoutOverride) {
        WaitForVisibleElement(locator, timeoutOverride).click();
    }

    protected WebElement WaitForVisibleElement(By locator, Integer timeoutOverride) {
        int time = (timeoutOverride != null) ? timeoutOverride : defaultTimeout;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void MakeClick(WebElement element) {
        element.click();
    }

    protected WebElement WaitForVisibleElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(defaultTimeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void SendKeys(By locator, String Text, Integer timeoutOverride) {
        WebElement Element = WaitForVisibleElement(locator, timeoutOverride);
        Element.clear();
        Element.sendKeys(Text);
    }

    protected String getText(By locator, Integer timeoutOverride) {
        return WaitForVisibleElement(locator, timeoutOverride).getText();
    }

    protected boolean isElementVisible(By locator, Integer timeoutOverride) {
        try {
            WaitForVisibleElement(locator, timeoutOverride);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    protected List<WebElement> getElements(By locator, Integer timeoutOverride) {
        return WaitForVisibleElement(locator, timeoutOverride).findElements(locator);
    }
}

