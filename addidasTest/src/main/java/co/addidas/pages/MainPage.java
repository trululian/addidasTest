package co.addidas.pages;

import co.addidas.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends Base {
    public MainPage(WebDriver driver) {
        super(driver);
    }


    By hdrTendecias = By.xpath("//h4[text()='TENDENCIAS']");
    By tittleColecion = By.xpath("//strong[text()='¿Estás listx para fep?']");
   // By tittleColecionJamaica = By.xpath("//strong[text()='Colección Jamaica game day']");
    By btnWishList = By.xpath("//div[@data-auto-id = 'auxiliary-menu']//a[@href= '/wishlists']");
   // By videoJamamicaCollection = By.xpath("//video[@src = 'https://brand.assets.adidas.com/image/upload/q_auto,vc_auto,c_scale,w_0.5/esCO/Images/tcarrusel-jff_tcm195-988656.mp4']");
    By mediaCollection = By.xpath("//img[@src='https://brand.assets.adidas.com/image/upload/f_auto,q_auto,fl_lossy/if_w_gt_800,w_800/esCO/Images/fep-tc-d_tcm195-1002130.jpg']");

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
        waitForElementPresent(mediaCollection);
        assertIsDisplayed(mediaCollection);
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
