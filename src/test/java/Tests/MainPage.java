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

}
