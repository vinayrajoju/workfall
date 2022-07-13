package com.workfall.pages.clientpages;

import com.workfall.base.TestBase;
import com.workfall.pages.ConfirmationPopupPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ConfirmBookingRequestPage extends TestBase {

    @FindBy(css="input[formcontrolname$='hours']")
    WebElement bookinghours;

    @FindBy(css="input[placeholder='Pick a Date']")
    WebElement selectdate;

    @FindBy(css="td>span[class*='myDpMarkCurrDay']")
    WebElement bookingdate;

    @FindBy(css="textarea[formcontrolname='description']")
    WebElement taskdescription;

    @FindBy(xpath="//div[@class='modal-content']/div[2]/form/div[3]")
    WebElement sendrequest;

    public ConfirmBookingRequestPage(){
        PageFactory.initElements(driver , this);
    }

    public ConfirmationPopupPage confirmBooking(String hrs, String wsdescription) throws InterruptedException {

        bookinghours.sendKeys(hrs);
        selectdate.click();
        bookingdate.click();
        taskdescription.sendKeys(wsdescription);
        sendrequest.click();
        ConfirmationPopupPage confirmPage = new ConfirmationPopupPage();
        wait.until(ExpectedConditions.visibilityOf(confirmPage.yes));
        //Thread.sleep(3000);

        return new ConfirmationPopupPage();
    }
}
