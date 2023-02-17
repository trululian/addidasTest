package co.addidas.pages;

import co.addidas.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishListPage extends Base {
    public WishListPage(WebDriver driver) {
        super(driver);
    }

    By hdrMyWishList = By.xpath("//div[@data-auto-id='my-wishlist-view-container']/h4");
    By productNameC = By.xpath("//div[@class='glass-product-card__details']/p[text()='Guayos X Speedportal.3 Cancha Cubierta']");
    public void userIsInPage(){
        reporter("User is in wishList");
        waitForElementPresent(hdrMyWishList);
        assertIsDisplayed(hdrMyWishList);
    }

    public void validateProdcutInWishlist(String productName){
        reporter("Validate that selected product is displayed");
        waitForElementPresent(productNameC);
        assertIsDisplayed(productNameC);
        assertEqualsString(getTextFromWebElement(productNameC),productName);
    }
}
