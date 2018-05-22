package Screens;

import Driver.Base;
import org.testng.Assert;

public class SecureAreaPage extends Base implements ElemetsForSecurePage {

    public SecureAreaPage(){
       Assert.assertTrue(waitForElementById(ElemetsForSecurePage.messagAboutSuccessfulLogInId).isDisplayed(),"Message about successful LogIn is not Displayed on SecureArea page ");
        Assert.assertTrue(waitForElementByXpath(ElemetsForSecurePage.logOutButtomXpath).isDisplayed(),"Log In button is not displayed on SecureArea page");
        Assert.assertTrue(waitForElementById(ElemetsForSecurePage.footerId).isDisplayed(),"Footer is not displayed on SecureArea page");
    }


}
