package Screens;

import Driver.Base;

import java.util.LinkedList;

public class PageWithDynamicContent extends Base implements ElementsForDynamicContent{

    public LinkedList<String> getTextOfElements(){

        int countOfElements= getCountOfElementsByXpath(ElementsForDynamicContent.textDescriptionOFUserXpath).size(); //get size of elements
        LinkedList<String> textDescriptions=new LinkedList<>();
        int i =1;
        while (i<=countOfElements-1){
           textDescriptions.add(waitForElementByXpath(ElementsForDynamicContent.textDescriptionOFUserXpath+"["+i+"]/div[2]").getText());// get text from each element
            i++;}
        return textDescriptions;}


public void getPictureDescription() {
waitForElementByXpath("//*[@id='content']/div[1]/div[1]/img");

}}