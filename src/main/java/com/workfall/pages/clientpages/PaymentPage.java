package com.workfall.pages.clientpages;

import com.workfall.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PaymentPage extends TestBase {

    public PaymentPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="div[class='expert']>h3")
    List<WebElement> partners;

    @FindBy(css=".btn-paynow")
    List<WebElement> paybtn;


    public PaymentprocessPage selectPartner(String partnername) throws InterruptedException {
        List<WebElement> partnerList = partners;
        for(int k=0;k<partnerList.size();k++)
        {
            String partner = partnerList.get(k).getText();
            if(partner.contains(partnername))
            {
                paybtn.get(k).click();
                break;
            }
        }
        Thread.sleep(3000);
        return new PaymentprocessPage();
    }


}
