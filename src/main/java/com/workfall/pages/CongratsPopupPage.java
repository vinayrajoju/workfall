package com.workfall.pages;

import com.workfall.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CongratsPopupPage extends TestBase {

    @FindBy(css = "#congratsModal .btn-close")
    WebElement ok;
    @FindBy(css = "#congratsModal .short-info")
    public WebElement popUpMessage;

    public CongratsPopupPage(){
        PageFactory.initElements(driver, this);
    }
    public void ok(){
        wait.until(ExpectedConditions.visibilityOf(popUpMessage));
        ok.click();
    }
    public String  successMessage(){
       String info = popUpMessage.getText();
    return info;
    }

}
