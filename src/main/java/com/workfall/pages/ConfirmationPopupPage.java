package com.workfall.pages;

import com.workfall.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPopupPage extends TestBase {

    public ConfirmationPopupPage(){

        PageFactory.initElements(driver,this);
    }

    @FindBy(css="#confirmationPopup .btn-send")
    public WebElement yes;

    @FindBy(css="#confirmationPopup .btn-close")
    public WebElement cancel;

    @FindBy(css="#accpetClientSuccessModal h5")
    public WebElement success;

    @FindBy(css="#confirmPay .btn-cancel-request")
    public WebElement acceptpay;



    @FindBy(css="#areYouSure .btn-send")
    public WebElement imSure;

    @FindBy(css="#confirmSubmitLogPopup button[class='btn btn-orange']")
    public WebElement confirmlog;

    public void yes() {
        yes.click();
    }

    public void confirmLog(){
        confirmlog.click();
    }
}
