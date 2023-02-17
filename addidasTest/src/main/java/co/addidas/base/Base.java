package co.addidas.base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.time.Duration;
public class Base {

    private WebDriver driver;

    public Base(WebDriver driver){

        this.driver = driver;
    }

    /*
     * Reporter Method
     * @author Julian Pardo
     * @param String - Message to be reported
     */
    public void reporter(String message){

        Reporter.log(message);
    }

    /*
     * Set WebDriver
     * @author Julian Pardo
     * @param
     */

    public WebDriver chromeDriver() {
        System.setProperty(GlobalVariables.CHROME_DRIVER_KEY, GlobalVariables.CHROME_DRIVER_LOCATION);
        driver = new ChromeDriver();
        return driver;
    }

    /*
     * Lunch Browser
     * @author Julian Pardo
     * @param
     */
    public void lunchBrowser (String url){
        reporter("Lunching URL "+url);
        driver.get(url);
        driver.manage().window().maximize();
        implicityWait(5);
    }

    /*
     * close browser
     * @author Julian Pardo
     */
    public void closeBrowser(){
        driver.close();
    }

    /*
     * Implicity Wait
     * @author Julian Pardo
     * @param - time in seconds
     */
    public void implicityWait (int seconds){
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
            seconds *= 1000;
        }catch(TimeoutException e){
            e.printStackTrace();
        }
    }

    /*
     * Implicity Wait2
     * @author Julian Pardo
     *
     */
    public void implicityWait (){
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalVariables.GENERAL_TIME_OUT));
        }catch(TimeoutException e){
            e.printStackTrace();
        }
    }

    /*
     * Element to be present
     * @author Julian Pardo
     * @param - element
     */
    public void waitForElementPresent(By locator){
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVariables.GENERAL_TIME_OUT));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }catch(TimeoutException e){
            e.printStackTrace();
        }
    }
    public void clickElement (By locator){
        try{
            driver.findElement(locator).click();
        }catch(NoSuchElementException e){
            e.printStackTrace();
        }

    }

    /*
     * is Displayed method
     * @author Julian Pardo
     * @param WebElement - Element to be validated
     */
    public boolean isDisplayed (By locator){
        try {
            return driver.findElement(locator).isDisplayed();
        }catch(NoSuchElementException e){
            e.printStackTrace();
            return false;
        }
    }
    /*
     * Scroll to object
     */

    public void scrollToObject (By locator){

        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
            isDisplayed(locator);
        }catch(NoSuchElementException e){
            e.printStackTrace();

        }
    }

}
