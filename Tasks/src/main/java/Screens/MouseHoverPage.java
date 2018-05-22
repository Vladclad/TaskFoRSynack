package Screens;

import Driver.Base;
import org.testng.Assert;

import java.util.LinkedList;

public class MouseHoverPage extends Base implements ElementsForMouseHover {

  public MouseHoverPage(){
     Assert.assertTrue(waitForElementById(ElementsForMouseHover.footerId).isDisplayed(),"Footer is not displayed");
   }
   //First checking if this (important for us) elements are present on the page


public LinkedList<String> moveHoverallPicturesAndGetTextOfAllUsers(){
    int countOfElements=getCountOfElementsByXpath(ElementsForMouseHover.pictureXpath).size(); // count off elements
    LinkedList<String> name=new LinkedList<>();
    int i =1;
    while (i<=countOfElements){
    getAction().moveToElement(waitForElementByXpath(ElementsForMouseHover.pictureXpath+"["+i+"]")).perform();// move mouse hover each element
     name.add(waitForElementByXpath(ElementsForMouseHover.userName+"["+i+"]"+"/div/h5").getText());  //get text of each element
     i++;}
return name;   //returning name of each user
}
}
