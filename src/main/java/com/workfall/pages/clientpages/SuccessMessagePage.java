package com.workfall.pages.clientpages;

import com.workfall.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SuccessMessagePage extends TestBase {

    @FindBy(css="#successModal  h4")
    public WebElement title;

    @FindBy(css="#successModal  .short-info:nth-Child(1)")
    public WebElement body;

    @FindBy(css=".modal-body .slotsText:nth-Child(2)")
    public WebElement slot1;

    @FindBy(css=".modal-body .slotsText:nth-Child(3)")
    public WebElement slot2;

    @FindBy(css=".modal-body .slotsText:nth-Child(4)")
    public WebElement slot3;

    @FindBy(css="#successModal .btn-close")
    WebElement close;

    @FindBy(css="#paymentInfo p")
    WebElement info;

    @FindBy(css="#paymentInfo .btn-orange")
    WebElement closeInfo;







    public SuccessMessagePage() {
        PageFactory.initElements(driver, this);
    }
        public String getTitle(){

            String gettitle=title.getText();

            return gettitle;
        }

        public String getBody(){
           String getbody= body.getText();
            return getbody;
        }

        public String getSlot1(){
           String getText= slot1.getText();
            return getText;
        }

        public String getSlot2() {
            String gettext=slot1.getText();
            return gettext;
        }

        public String getSlot3(){
            String gettext=slot1.getText();
            return gettext;
        }
        public void getClose(){
        close.click();
        }

        public void closePopup(){
        wait.until(ExpectedConditions.visibilityOf(info));
        closeInfo.click();
        }

}
