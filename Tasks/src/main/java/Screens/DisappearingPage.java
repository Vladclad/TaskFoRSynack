package Screens;

import Driver.Base;

public class DisappearingPage extends Base implements ElementsForDisappearingPage {

     public DisappearingPage(){
       org.testng.Assert.assertTrue(waitForElementById(ElementsForLogInPage.pageFotterId).isDisplayed(),"page footer is not displayed on the ElementsDisapearing page");
     }


    public int getFiveElements(int numberOfRefreshing) {
        int numberOfElemetns = getCountOfElementsByXpath(ElementsForDisappearingPage.descriptionButtons).size();//get size of all elements
        while(numberOfElemetns==5&&numberOfRefreshing<10){
             refreshpage();
             numberOfElemetns = getCountOfElementsByXpath(ElementsForDisappearingPage.descriptionButtons).size();
        numberOfRefreshing++;}
     return numberOfElemetns; }   //refreshing page until we didn't get lees then should be elements up to 10 times
    }







