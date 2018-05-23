package Screens;

import Driver.Base;
import org.testng.Assert;

public class NotificationMessagePage extends Base implements ElementsForNotificationMessage {

    public NotificationMessagePage(){
        Assert.assertTrue(waitForElementById(ElementsForNotificationMessage.footerId).isDisplayed(),"Footer is not displayed");
    }


    public void clickOnClickHereButton(){
        waitForElementByXpath(ElementsForNotificationMessage.clickHerButtonXpath).click();
    }

    public String getTextFormNotificationMessage(){
      return  waitForElementById(ElementsForNotificationMessage.notificationMessageId).getText();
    }


}
