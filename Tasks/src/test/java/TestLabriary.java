import Driver.Base;
import Screens.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestLabriary extends Base  {



    @Test //Test for Log In task

    void logInPageHappyPath(){
    Base.startBrowserForLoginTask(); //Start browser wih Url for login task
    LogInPage logInPage = new LogInPage();
    logInPage.sendKeyToUserNameField("tomsmith");  //send text to the User Name field
    logInPage.sendKeyToPasswordField("SuperSecretPassword!");  //send password to the Password field
    logInPage.clickOnLogIn();
    SecureAreaPage secureAreaPage =new SecureAreaPage();    // this class we checking if all elements are present
    }

    @Test() // Test for log In test
    void logInPageErrorHandling(){
        Base.startBrowserForLoginTask();  //Start browser wih  Url for login task
        LogInPage logInPage = new LogInPage();
        logInPage.sendKeyToUserNameField("data");  //send text to the User Name field
        logInPage.sendKeyToPasswordField("SuperSecretPassword!");//send password to the Password field
        logInPage.clickOnLogIn();
        String errorMessage=logInPage.getTextFromErrorMassege(); //get text from error message
        Assert.assertEquals(errorMessage.toLowerCase(),"Your username is invalid!\n".toLowerCase()+"×".toLowerCase(),"Error message is incorrect");
    }
    @Test // Test for mouse Hover task
    void moveMouseHover(){
        Base.startBrowserForHovers();
        MouseHoverPage mouseHoverPage=new MouseHoverPage();
       List users=  mouseHoverPage.moveHoverallPicturesAndGetTextOfAllUsers();  //moving mouse over the picture and get name of each user
        int i =0;
        int j=1;
        while (i<users.size()) {
            Assert.assertEquals( users.get(i).toString(), "name: user"+j,j+"User his name is incorrect");
            i++;
            j++;
        }}
        @Test// test for Dynamic content
            void dynamicContnt(){
        Base.startBrowserForDynamicContent();
        PageWithDynamicContent pageWithDynamicContent= new PageWithDynamicContent();
        List textsBeforePageRefresh=pageWithDynamicContent.getTextOfElements();  //saving the list of string of messages
        refreshpage(); //refresh the page
        List textAfterPagerefresh=pageWithDynamicContent.getTextOfElements();//saving the list of string of messages after page refresh
        Assert.assertNotEquals(textAfterPagerefresh,textsBeforePageRefresh,"Text is still the same in dynamic page ");
        }
        @Test //test for negative notification message
       void notificationMessageTestForNegativeMessage(){
        Base.startBrowserForNotificationMessage();
           String expected="Action unsuccesful, please try again\n" + //My expected result
                   "×";
           NotificationMessagePage notificationMessagePage = new NotificationMessagePage();
           notificationMessagePage.clickOnClickHereButton();  //click on ClickhereButton
           String actual=notificationMessagePage.getTextFormNotificationMessage();
           for (int i =0; i<10;i++){                  //reloading page until text will contain what we are expecting, max 9 times
            if (!actual.contains("unsuccesful")){
               notificationMessagePage.clickOnClickHereButton();
              actual=notificationMessagePage.getTextFormNotificationMessage();}
               else break;}
               Assert.assertEquals(expected,actual,"After 9 times reloading confirm message is not what we are expecting");

       }
       @Test //test for positive notification message
       void notificationMessageTestForPositiveMessage(){
           Base.startBrowserForNotificationMessage();
           String expected="Action successful\n" +
                   "×" ;//My expected result;
           NotificationMessagePage notificationMessagePage = new NotificationMessagePage();
           notificationMessagePage.clickOnClickHereButton();  //click on ClickhereButton
           String actual=notificationMessagePage.getTextFormNotificationMessage();
           for (int i =0; i<10;i++){                  //reloading page until text will contain what we are expecting, max 9 times
               if (!actual.equals(expected)){
                   notificationMessagePage.clickOnClickHereButton();
                   actual=notificationMessagePage.getTextFormNotificationMessage();}
               else break;}
           Assert.assertEquals(expected,actual,"After 9 times reloading confirm message is not what we are expecting");

       }
       @Test //test for disappearing elements
     void disappearingElements(){
        Base.startBrowserForDisappearingElements();
        DisappearingPage disappearingPage = new DisappearingPage();
        int numberOFElemets=disappearingPage.getFiveElements(1); //start refreshing from 1 till 10
         Assert.assertEquals(numberOFElemets,5,"After page refresh element disappeared max refreshing 10");

     }

    }





