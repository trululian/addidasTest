package co.addidas.pages;

import co.addidas.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GuayosPage extends Base {
    public GuayosPage(WebDriver driver) {
        super(driver);
    }

    By imgGuayos1 = By.xpath("//img[@src='https://assets.adidas.com/images/w_600,f_auto,q_auto/f9ea44c592c9416ba7baae9b011604c8_9366/Guayos_X_Speedportal.3_Cancha_Cubierta_Azul_GW8466_22_model.jpg']");
    By imgGuayos5 = By.xpath("//img[@src='https://assets.adidas.com/images/w_600,f_auto,q_auto/cc56d423a9fe4a71868cae9b0115d2e2_9366/Guayos_X_Speedportal.3_Cancha_Cubierta_Azul_GW8466_04_standard.jpg']");
    By btnWishList = By.xpath("//div[@data-auto-id ='add-wishlist-button']");

    public void userIsInPage(){
        reporter("User is in guayos page");
        waitForElementPresent(imgGuayos1);
        assertIsDisplayed(imgGuayos1);
    }

    public void addGuayosToWishList(){
        waitForElementPresent(imgGuayos5);
        scrollToObject(imgGuayos5);
        assertIsDisplayed(imgGuayos5);
        waitForElementPresent(btnWishList);
        assertIsDisplayed(btnWishList);
        clickElement(btnWishList);
    }
}
