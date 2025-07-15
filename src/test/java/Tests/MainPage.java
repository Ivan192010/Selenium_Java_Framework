package Tests;

import Base.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import org.testng.Assert;


@Epic("Ejercicios Jaime")
@Feature("Test de Tendencias")
public class MainPage extends BaseTest {


    @Test(description = "Test de Tendencias")
    @Severity(SeverityLevel.NORMAL)
    @Story("Test de Tendencias")
    public void testTendencias(){
        homePage.openHomePage();
        homePage.clickTendencias();
        String text = homePage.getTextTendencia("Tendencias");
        Assert.assertEquals(text, "Trending");
    }


    @Test(description = "Test de Subscripciones")
    @Severity(SeverityLevel.NORMAL)
    @Story("Test de Subscripciones")
    public void testSubscripciones(){
        homePage.openHomePage();
        homePage.clickSubscriptions();
        String URLPage = driver.getCurrentUrl();
        Assert.assertEquals(URLPage, "https://www.youtube.com/feed/subscriptions");
    }

    @Test(description = "Test de Busqueda")
    @Severity(SeverityLevel.NORMAL)
    @Story("Test de Busqueda")
    public void testBusqueda(){
        homePage.openHomePage();
        homePage.writeBusqueda("MrBeast");
        homePage.clickBusqueda();
        String URLPage = driver.getCurrentUrl();
        Assert.assertEquals(URLPage, "https://www.youtube.com/results?search_query=");
    }
}
