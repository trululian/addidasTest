package co.addidas.base;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.time.Duration;
public class Base {

    WebDriver driver;

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
        driver.manage().window().maximize();
        driver.get(url);
        implicityWait();
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
    /*
     * Element to be present
     * @author Julian Pardo
     * @param - element
     */
    public void waitForElementclickeable(By locator){
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVariables.GENERAL_TIME_OUT));
            wait.until(ExpectedConditions.elementToBeClickable(locator));
        }catch(TimeoutException e){
            e.printStackTrace();
        }
    }



    /*
     * click element method
     * @author Julian Pardo
     * @param WebElement - Element to be validated
     */
    public void clickElement (By locator){
        try{
            driver.findElement(locator).click();
        }catch(NoSuchElementException e){
            e.printStackTrace();
        }

    }
    /*
     * click element method
     * @author Julian Pardo
     * @param WebElement - Element to be validated
     */
    public void submitElement (By locator){
        try{
            driver.findElement(locator).submit();
        }catch(NoSuchElementException e){
            e.printStackTrace();
        }

    }

    public void clickElementJs(By locator){
        try{
            WebElement b = driver.findElement(locator);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("document.querySelector("+locator+").click()");
            //js.executeScript("arguments[0].click();",b);
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
     * Assert is Displayed method
     * @author Julian Pardo
     * @param WebElement - Element to be validated
     */
    public void assertIsDisplayed(By locator){
        try {
            Assert.assertEquals(driver.findElement(locator).isDisplayed(),true);
        }catch(AssertionError e){
            Assert.fail(e.getMessage() +" element is not displayed ");
        }
    }

    /*
     * Scroll to object
     * @author Julian Pardo
     * @param WebElement - Element to be validated
     */

    public void scrollToObject (By locator){

        try {
            waitForElementPresent(locator);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
            assertIsDisplayed(locator);
        }catch(NoSuchElementException e){
            e.printStackTrace();

        }
    }

    /*
     * Obtain Page URL
     * @author Julian Pardo
     * @param WebElement - Element to be validated
     */

    public String obtainPageUrl (){
        String url = driver.getCurrentUrl();
        return url;
    }

    /*
     * Assert equals String method
     * @author Julian Pardo
     * @param String actual and expected values
     */
    public void assertEqualsString (String actual, String Expected){
        try {
            Assert.assertEquals(actual,Expected);
        }catch(AssertionError e){
            Assert.fail(e.getMessage() +" Actual value "+actual+" does not match the expected value "+ Expected);
        }
    }
    /*
     * Assert equals Boolean method
     * @author Julian Pardo
     * @param String actual and expected values
     */
    public void assertEqualsBoolean (boolean actual, boolean Expected){
        try {
            Assert.assertEquals(actual,Expected);
        }catch(AssertionError e){
            Assert.fail(e.getMessage() +" Actual value "+actual+" does not match the expected value "+ Expected);
        }
    }

    /*
     * Type Method
     * @author Julian Pardo
     * @param WebElement - Element where the text will be inputted
     */
    public void type (By locator, String text){
        try {
            driver.findElement(locator).sendKeys(text);
        }catch(NoSuchElementException e){
            e.printStackTrace();
        }
    }

    /*
     * get text from Element
     * @author Julian Pardo
     * @param WebElement - Element where the text will be inputted
     */
    public String getTextFromWebElement (By locator){
        try {
            return driver.findElement(locator).getText();
        }catch(NoSuchElementException e){
            e.printStackTrace();
            return null;
        }
    }
    /*
     * Get data from JSON FILE
     * @author Julian Pardo
     */

    public String getJSONvalue(String jsonFileObj, String jsonKey){
        try{
            //JSON data
            InputStream inputStream = new FileInputStream(GlobalVariables.PATH_JSON_DATA + jsonFileObj +".json");
            JSONObject jsonObject = new JSONObject(new JSONTokener(inputStream));

            //Get Data
            String jsonValue = (String) jsonObject.getJSONObject(jsonFileObj).get(jsonKey);
            return jsonValue;
        }catch (FileNotFoundException e){
            Assert.fail("JSON File is not found");
            return null;
        }
    }

}
