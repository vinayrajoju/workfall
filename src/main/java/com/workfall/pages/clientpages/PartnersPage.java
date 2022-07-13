package com.workfall.pages.clientpages;

import com.workfall.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PartnersPage extends TestBase {


    @FindBy(xpath="//span[text()='My Crew']")
    WebElement mycrew;

    @FindBy(css="h2[style='cursor: pointer;']")
    public List<WebElement> partnersList;

    @FindBy(xpath = "//div[@class='all-crew-list']/div/div[2]/button[@class='btn btn-newOffer']")
    public List<WebElement> requestbtns;
    public PartnersPage(){
        PageFactory.initElements(driver,this);
    }

    public void selectPartner(String partnerName) throws InterruptedException {
        List<WebElement> crew = partnersList;
        for(int i=0;i< crew.size();i++)
        {
            Thread.sleep(2000);
            String partner = crew.get(i).getText().toLowerCase();
            if(partner.contains(partnerName.toLowerCase()))
            {
               requestbtns.get(i).click();
                break;
            }
        }
        Thread.sleep(3000);
    }

}
