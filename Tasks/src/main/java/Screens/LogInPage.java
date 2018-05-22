package Screens;

import Driver.Base;
import org.testng.Assert;

public class LogInPage extends Base implements ElementsForLogInPage {



public LogInPage(){
   Assert.assertTrue(waitForElementById(ElementsForLogInPage.pageFotterId).isDisplayed(),"page footer is not displayed on the page");  //purpose of this, we are checking if all important elements on the page
    //that is not involved in test
}

public void sendKeyToUserNameField(String Text){
    waitForElementById(ElementsForLogInPage.usernameFieId).sendKeys(Text); // This method is sending data to Username Field
}


public void sendKeyToPasswordField(String password){
    waitForElementById(ElementsForLogInPage.passwordFieId).sendKeys(password); // This method is sending data to Password Field
}

public void clickOnLogIn(){
    waitForElementByXpath(ElementsForLogInPage.sumbitButtonXpath).click(); // This method is clicking on LogIn button
}

public String getTextFromErrorMassege(){
    return waitForElementById(ElementsForLogInPage.errorMessageForLogginId).getText(); //This method is getting text from error message
}

}
