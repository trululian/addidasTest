package co.addidas.pages;

import co.addidas.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends Base {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    By hdrProductName = By.xpath("//div[@class='sidebar-wrapper___3uF26']//h1/span[text()='Top Deportivo Estampado Tipo Mármol']");
    By imgProduct1 = By.xpath("//img[@src='https://assets.adidas.com/images/w_600,f_auto,q_auto/6cb93f5b31044dada835af5b0129d297_9366/Top_Deportivo_Estampado_Tipo_Marmol_Azul_IC2215_21_model.jpg']");
    By imgProduct5 = By.xpath("//img[@src='https://assets.adidas.com/images/w_600,f_auto,q_auto/b6b85217517c409bb959af5b012a0b8c_9366/Top_Deportivo_Estampado_Tipo_Marmol_Azul_IC2215_01_laydown.jpg']");
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
