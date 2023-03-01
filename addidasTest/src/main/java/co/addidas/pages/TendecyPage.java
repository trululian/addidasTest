package co.addidas.pages;

import co.addidas.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TendecyPage extends Base {

    public TendecyPage(WebDriver driver) {
        super(driver);
    }


    By headerPopUP = By.xpath("//h1[text()='ÚNETE Y RECIBE UN 15% DE DESCUENTO']");
    By btnClosePopUP = By.xpath("//button[@class = 'gl-modal__close']");
    By hdrCollectionpage = By.xpath("//h2[text()='Ultraboost Light']");
    By hdrcollectionPageName = By.xpath("//h1/span[text()='Ultraboost - Ultraboost Light']");
    By hrefDesireProduct = By.xpath("//a[@href='https://www.adidas.co/tenis-ultraboost-5-dna/GV8743.html']//p[text()='Tenis Ultraboost 5 DNA']");
    By imgDesireProduct = By.xpath("//img[@src='https://assets.adidas.com/images/w_383,h_383,f_auto,q_auto,fl_lossy,c_fill,g_auto/5fe93efae8ee4fa7a285ae370134c365_9366/tenis-ultraboost-5-dna.jpg']");

    public void closePopUp(){
        reporter("Closing pop up");
        waitForElementPresent(headerPopUP);
        waitForElementPresent(btnClosePopUP);
        waitForElementclickeable(btnClosePopUP);
        assertIsDisplayed(headerPopUP);
        assertIsDisplayed(btnClosePopUP);
        clickElement(btnClosePopUP);
    }

    public void userIsInPage(){
        reporter("User is Tendency page");
        waitForElementPresent(hdrCollectionpage);
        waitForElementPresent(hdrcollectionPageName);
        assertIsDisplayed(hdrCollectionpage);
        assertIsDisplayed(hdrcollectionPageName);
    }

    public void compareURL(String url){
        reporter("Validate that user is in the correct url: "+url);
        String aux = obtainPageUrl();
        assertEqualsString(aux,url);
    }

    public void GoToDesireProduct(){
        reporter("user goes to Desire Product");
        scrollToObject(hrefDesireProduct);
        waitForElementPresent(imgDesireProduct);
        waitForElementclickeable(hrefDesireProduct);
        assertIsDisplayed(imgDesireProduct);
        assertIsDisplayed(hrefDesireProduct);
        clickElement(imgDesireProduct);
    }
}
