package co.addidas.pages;

import co.addidas.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePopUp extends Base{

    public WelcomePopUp(WebDriver driver) {
        super(driver);
    }

    By welcomeTxt = By.xpath("//div[@class ='sidebar_container___3b85Q']/div[1]/div[text()]");
    By btnGoToAccount = By.xpath("//button//span[text()='Ir a tu cuenta']");
    By btnClose= By.xpath("//div[@class='side-panel-overlay___2NAFe side-panel-overlay-active___2KFn9']//span[@data-testid='close']");

    public void succesfullyLogin(){
        reporter("User was successfully logged");
        waitForElementPresent(btnGoToAccount);
        waitForElementPresent(welcomeTxt);
        assertIsDisplayed(welcomeTxt);
        assertIsDisplayed(btnGoToAccount);
        String welcomeMsg=getTextFromWebElement(welcomeTxt);
        Boolean aux = welcomeMsg.startsWith("HOLA");
        assertEqualsBoolean(aux,true);
    }

    public void closePopUp(){
       reporter("Closing the welcome pop up");
       waitForElementclickeable(btnClose);
       assertIsDisplayed(btnClose);
       clickElement(btnClose);
    }


}
