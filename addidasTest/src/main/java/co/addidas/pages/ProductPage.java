package co.addidas.pages;

import co.addidas.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends Base {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    By hdrProductName = By.xpath("//div[@class='sidebar-wrapper___3uF26']//h1/span[text()='Tenis Ultraboost 5 DNA']");
    By imgProduct1 = By.xpath("//img[@src='https://assets.adidas.com/images/w_600,f_auto,q_auto/477cd2d3ad674cae9427ae3701349eab_9366/Tenis_Ultraboost_5_DNA_Negro_GV8743_01_standard.jpg']");
    By imgProduct5 = By.xpath("//img[@src='https://assets.adidas.com/images/w_600,f_auto,q_auto/93ad884a431c4678a6f9ae370132f61f_9366/Tenis_Ultraboost_5_DNA_Negro_GV8743_05_standard.jpg']");
    By btnWishList = By.xpath("//div[@data-auto-id ='add-wishlist-button']");

    public void userIsInPage(){
        reporter("User is in product page");
        waitForElementPresent(imgProduct1);
        waitForElementPresent(hdrProductName);
        assertIsDisplayed(imgProduct1);
        assertIsDisplayed(hdrProductName);
    }

    public void addSelectedProductToWishList(){
        waitForElementPresent(imgProduct5);
        scrollToObject(imgProduct5);
        assertIsDisplayed(imgProduct5);
        waitForElementPresent(btnWishList);
        assertIsDisplayed(btnWishList);
        clickElement(btnWishList);
    }
}
