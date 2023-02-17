package co.addidas;

import co.addidas.base.Base;

import co.addidas.base.GlobalVariables;
import co.addidas.pages.MainPage;
import co.addidas.pages.TendecyPageJamica;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class TC_WHIS_LIST {
    WebDriver driver;
    Base base;
    MainPage mainPage;
    TendecyPageJamica jamaicaTendency;

    @BeforeTest
    public void beforeTest(){
        // set up driver
        base = new Base(driver);
        driver = base.chromeDriver();
        mainPage = new MainPage(driver);
        jamaicaTendency = new TendecyPageJamica(driver);


        // test data json
        /*this.userName = base.getJSONvalue("LoginCredentials","username");
        this.password = base.getJSONvalue("LoginCredentials","password");*/

    }

    @Test
    public void TC_WISH_LIST(){
        base.lunchBrowser(GlobalVariables.QA_URL);
        mainPage.userIsInPage();
        mainPage.GoToCollectionJamaica();
        jamaicaTendency.closePopUp();
        jamaicaTendency.userIsInPage();
        jamaicaTendency.compareURL("https://www.adidas.co/jamaica");
        jamaicaTendency.GoToDesireProductGuayos();

    }
    @AfterTest
    public void afterTest(){
        //base.closeBrowser();
    }


}

