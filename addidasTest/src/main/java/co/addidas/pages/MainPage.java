package co.addidas.pages;

import co.addidas.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends Base {
    public MainPage(WebDriver driver) {
        super(driver);
    }


    By hdrTendecias = By.xpath("//h4[text()='TENDENCIAS']");
    By tittleColecion = By.xpath("//strong[text()='Ultraboost Light. Nuestro Ultraboost más ligero.']");
   // By tittleColecionJamaica = By.xpath("//strong[text()='Colección Jamaica game day']");
    By btnWishList = By.xpath("//div[@data-auto-id = 'auxiliary-menu']//a[@href= '/wishlists']");
   // By videoJamamicaCollection = By.xpath("//video[@src = 'https://brand.assets.adidas.com/image/upload/q_auto,vc_auto,c_scale,w_0.5/esCO/Images/tcarrusel-jff_tcm195-988656.mp4']");
    By videoCollection = By.xpath("//video[@src='https://brand.assets.adidas.com/video/upload/q_auto,vc_auto,c_scale,w_0.5/video/upload/running-ss23-ultraboost-light-global-ea-educate-hp-teaser-carousel-d_oqpyya.mp4']");

    public void userIsInPage(){
        reporter("User is in Main Page");
        waitForElementclickeable(btnWishList);
        waitForElementPresent(btnWishList);
        assertIsDisplayed(btnWishList);
    }
    public void GoToCollection (){
        reporter("user goes to Desire Collection");
        scrollToObject(hdrTendecias);
        waitForElementPresent(tittleColecion);
        assertIsDisplayed(videoCollection);
        assertIsDisplayed(tittleColecion);
        clickElement(tittleColecion);
    }

    public void goToWishList (){
        reporter("User goes to wishList");
        waitForElementPresent(btnWishList);
        assertIsDisplayed(btnWishList);
        waitForElementclickeable(btnWishList);
        clickElement(btnWishList);
    }

}
