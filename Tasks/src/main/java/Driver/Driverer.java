package Driver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.safari.SafariDriver;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Driverer {
    final public static String browserName="Chrome";
     private static WebDriver driver;
    protected static WebDriver br(String s){
        if (s.equals("Chrome")) {
            String driverPath="";
            if (System.getProperty("os.name").toUpperCase().contains("MAC"))   driverPath="/Users/vburian/Documents/AmazonTestss/src/main/resources/webdrivers/mac/chromedriver";
            else if (System.getProperty("os.name").toUpperCase().contains("WINDOWS")) driverPath = "";
            System.setProperty("webdriver.chrome.driver", driverPath);
            System.setProperty("webdriver.chrome.silentOutput","true");
            ChromeOptions option = new ChromeOptions();
            option.addArguments("disable-infobars");
            option.addArguments("--disable-notifications");
            if (System.getProperty("os.name").toUpperCase().contains("MAC")) {
                option.addArguments("-start-fullscreen");}
            else if (System.getProperty("os.name").toUpperCase().contains("WINDOWS"))
                option.addArguments("--start-maximazed");
            else throw new IllegalArgumentException("UknowOS");
            driver = new ChromeDriver(option);

        }
        else if (s.equals("Firefox")) {

            Logger logger = Logger.getLogger("");
            logger.setLevel(Level.OFF);
            String USERAGENT="Mozilla/5.0 (iPhone; CPU iPhone OS 10_3_1 like Mac OS X) AppleWebKit/603.1.30 (KHTML, like Gecko) Version/10.0 Mobile/14E304 Safari/602.1";
            String driverPath="";
            if (System.getProperty("os.name").toUpperCase().contains("MAC"))   driverPath="./resources/webdrivers/mac/geckodriver.sh";
            else if (System.getProperty("os.name").toUpperCase().contains("WINDOWS")) driverPath = "";
            FirefoxOptions options=new FirefoxOptions().setProfile(new FirefoxProfile());
            options.addPreference("general.useragent.override",USERAGENT );
            System.setProperty("webdriver.gecko.driver", driverPath);
            driver = new FirefoxDriver();

            System.out.println((String)((JavascriptExecutor)driver).executeScript("return navigator.userAgent;"));
            driver.manage().window().maximize();;
            return driver;
        }
        else if (s.equals("Safari")) {

            Logger logger = Logger.getLogger("");
            logger.setLevel(Level.OFF);

            if (!System.getProperty("os.name").contains("Mac")) {throw new IllegalArgumentException("Safari is available only on Mac");}

            driver = new SafariDriver();
            driver.manage().window().maximize();
            return driver;
        }
        return driver;}

}

