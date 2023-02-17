package co.addidas.pages;

import co.addidas.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TendecyPageJamica extends Base {

    public TendecyPageJamica(WebDriver driver) {
        super(driver);
    }


    String desiredURL = "https://www.adidas.co/jamaica";
    By headerPopUP = By.xpath("//h1[text()='ÚNETE Y RECIBE UN 15% DE DESCUENTO']");
    By btnClosePopUP = By.xpath("//button[@class = 'gl-modal__close']");
    By imgLogo = By.xpath("//img[@id = 'tcm:195-980455']");
    By headerNuevaCamisetaDeJamaica = By.xpath("//span[text()='Nueva camiseta de Jamaica']");
    By hrefGuayos = By.xpath("//a[@href='https://www.adidas.co/guayos-x-speedportal.3-cancha-cubierta/GW8466.html']//p[text()='Guayos X Speedportal.3 Cancha Cubierta']");
    By imgGuayos = By.xpath("//img[@src ='https://assets.adidas.com/images/w_383,h_383,f_auto,q_auto,fl_lossy,c_fill,g_auto/f9ea44c592c9416ba7baae9b011604c8_9366/guayos-x-speedportal.3-cancha-cubierta.jpg']");

    public void closePopUp(){
        waitForElementPresent(headerPopUP);
        waitForElementPresent(btnClosePopUP);
        waitForElementclickeable(btnClosePopUP);
        assertIsDisplayed(headerPopUP);
        assertIsDisplayed(btnClosePopUP);
        clickElement(btnClosePopUP);
    }

    public void userIsInPage(){
        reporter("User is in Jamaica Tendency page");
        waitForElementPresent(imgLogo);
        waitForElementPresent(headerNuevaCamisetaDeJamaica);
        assertIsDisplayed(imgLogo);
        assertIsDisplayed(headerNuevaCamisetaDeJamaica);
    }

    public void compareURL(String url){
        reporter("Validate that user is in the correct url: "+url);
        String aux = obtainPageUrl();
        assertEqualsString(aux,url);
    }

    public void GoToDesireProductGuayos (){
        reporter("user goes to Desire Product - Guayos X Speedportal.3 Cancha Cubierta ");
        scrollToObject(imgGuayos);
        waitForElementPresent(hrefGuayos);
        waitForElementclickeable(imgGuayos);
        assertIsDisplayed(imgGuayos);
        assertIsDisplayed(hrefGuayos);
        clickElement(imgGuayos);
    }
}
