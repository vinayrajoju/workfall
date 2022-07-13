package com.workfall.pages.clientpages;

import com.workfall.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class PaymentprocessPage extends TestBase {

    public PaymentprocessPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css=".details>div:nth-child(3)>.btn-next")
    WebElement step1proceed;

    @FindBy(css=".payWireBtn")
    WebElement selectwiretransfer;

    @FindBy(css=".btn-next")
    WebElement step2proceed;

    @FindBy(css=".downloadPay>h5")
    WebElement downloadinvoice;

    @FindBy(css="input[type='checkbox']")
    WebElement selectcheckbox;

    @FindBy(css=".btn-next")
    WebElement step3proceed;

    @FindBy(css=".payment-reference .ref")
    WebElement referenceid;


    public void wireTransferPayment() throws InterruptedException, IOException {

        step1proceed.click();
        selectwiretransfer.click();
        step2proceed.click();
        selectcheckbox.click();
        System.out.println(referenceid.getText());
        getScreenshotPath("Invoice form");
        Thread.sleep(4000);
        downloadinvoice.click();
        step3proceed.click();


    }

}
