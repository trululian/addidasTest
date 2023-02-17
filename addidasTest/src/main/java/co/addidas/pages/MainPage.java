package co.addidas.pages;

import co.addidas.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends Base {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    By tittleColecionJamaica = By.xpath("//strong[text()='Colección Jamaica game day']");
    By btnWishList = By.xpath("//div[@data-auto-id = 'auxiliary-menu']");

    public void userIsInPage(){
        reporter("User is in Main Page");
        isDisplayed(btnWishList);
        //waitForElementPresent(btnWishList);
    }
    public void GoToCollectionJamaica (){
        reporter("user goes to Desire Collection");
        scrollToObject(tittleColecionJamaica);
        clickElement(tittleColecionJamaica);
    }

}
