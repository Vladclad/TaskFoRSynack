package Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

import java.util.List;


public class Base extends Driverer {
    private static WebDriver driver =Driverer.br(Driverer.browserName);
   private static WebDriverWait wait = new WebDriverWait (driver,15);
   private static Actions action = new Actions(driver);


   protected Actions getAction (){
       return action;
   }
    public static void refreshpage(){
       driver.navigate().refresh();   //refresh current page
    }
    public static void startBrowserForLoginTask(){
         driver.get("https://the-internet.herokuapp.com/login"); //URL for Log In task
    }
    public static void startBrowserForHovers(){
        driver.get("https://the-internet.herokuapp.com/hovers");  //URL for Mose Hover task
    }
    public static void startBrowserForDynamicContent(){
        driver.get("https://the-internet.herokuapp.com/dynamic_content");  //URL for Mose Hover task
    }

    @AfterMethod
    public static void closeBrowser(){
         driver.close();
    }

    protected static WebElement waitForElementById (String id) {
        WebElement some=wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
        return some;
    }
    protected static WebElement waitForElementByXpath (String xpath) {
        WebElement some=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        return some;}

        protected List getCountOfElementsByXpath(String xpath){
      return driver.findElements(By.xpath(xpath));
        }
    protected List getCountOfElementsById(String id){
        return driver.findElements(By.xpath(id));
    }


       // protected static WebElement actions (String id){
        //WebElement some = (WebElement) action.moveToElement(waitForElementById(id));
        //return some;}
    }

