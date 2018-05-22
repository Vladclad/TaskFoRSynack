import Driver.Base;
import Screens.LogInPage;
import Screens.MouseHoverPage;
import Screens.PageWithDynamicContent;
import Screens.SecureAreaPage;
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



    @Test(dataProvider = "data") // Test for log In test
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
        List textsBeforePageRefresh=pageWithDynamicContent.getTextOfElements();
        refreshpage();
        List textAfterPagerefresh=pageWithDynamicContent.getTextOfElements();
        Assert.assertNotEquals(textAfterPagerefresh,textsBeforePageRefresh);
        }


    }





