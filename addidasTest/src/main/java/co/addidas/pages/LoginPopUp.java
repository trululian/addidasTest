package co.addidas.pages;

import co.addidas.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPopUp extends Base {
    public LoginPopUp(WebDriver driver) {
        super(driver);
    }

    By headerH4IniciarSesion  = By.xpath("//h4[text()='Iniciar sesión']");
    By btnContinue = By.xpath("//button[@type='submit'][@aria-label='Continuar']");
    By btnFaceBook = By. xpath("//button[@data-auto-id='social-login-form-facebook']");
    By textEmailFaceBook = By.xpath("//input[@id= 'email']");
    By textPasswordFacebook = By.xpath ("//input[@id= 'pass']");
    By btnLogInFaceBook = By.xpath("//button[@id= 'loginbutton']");


    public void userIsInPage(){
        reporter("User is in Login Pop Up");
        waitForElementPresent(headerH4IniciarSesion);
        waitForElementclickeable(btnContinue);
        waitForElementclickeable(btnFaceBook);
        assertIsDisplayed(headerH4IniciarSesion);
        assertIsDisplayed(btnContinue);
    }

    public void loginInFacBook(String Email, String Password){
        reporter("Login using Facebook Credentials");
        scrollToObject(btnFaceBook);
        clickElement(btnFaceBook);
        waitForElementPresent(textEmailFaceBook);
        waitForElementPresent(textPasswordFacebook);
        waitForElementclickeable(btnLogInFaceBook);
        assertIsDisplayed(textPasswordFacebook);
        assertIsDisplayed(textPasswordFacebook);
        type(textEmailFaceBook,Email);
        type(textPasswordFacebook,Password);
        clickElement(btnLogInFaceBook);
    }
}
