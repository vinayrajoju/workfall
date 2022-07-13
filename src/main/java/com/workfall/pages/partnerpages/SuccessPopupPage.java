package com.workfall.pages.partnerpages;

import com.workfall.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SuccessPopupPage extends TestBase {

    @FindBy(css="#accpetClientSuccessModal .btn-cancel")
    WebElement closePopup;

    @FindBy(css=" #accpetClientSuccessModal h5")
    WebElement successText;

    @FindBy(css="#successTimelogSubmit p")
    WebElement successlogText;
    @FindBy(css="#successTimelogSubmit .btn-grey")
    WebElement closeSuccessPopup;



    public SuccessPopupPage() {
        PageFactory.initElements(driver, this);
    }



    public void closePopup(){
        wait.until(ExpectedConditions.visibilityOf(successText));
        closePopup.click();
    }

    public void closeSuccessPopup(){
        wait.until(ExpectedConditions.visibilityOf(successlogText));
        closeSuccessPopup.click();
    }



}
