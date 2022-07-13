package com.workfall.pages.clientpages;

import com.workfall.base.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CardsPage extends TestBase {

    private static Logger log = LogManager.getLogger(CardsPage.class.getName());

    public CardsPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".btn-add")
    WebElement addcard;

    @FindBy(css = ".deleteSymbol")
    WebElement existcardoptions;

    @FindBy(css = ".profile-info .mb-0")
    WebElement dltcard;

    @FindBy(css = "img[alt='add icon']")
    WebElement addnewcard;

    @FindBy(css = "input[placeholder='Name on card']")
    WebElement holdername;

    @FindBy(css = "iframe[title='Secure card number input frame']")
    WebElement cardnum_frame;

    @FindBy(css = "input[name='cardnumber']")
    WebElement cardnum;

    @FindBy(css = "iframe[title='Secure expiration date input frame']")
    WebElement cardexpdt_frame;

    @FindBy(css = "input[placeholder='MM / YY']")
    WebElement cardexpdt;

    @FindBy(css = "iframe[title='Secure CVC input frame']")
    WebElement cardcvv_frame;

    @FindBy(css = "input[placeholder='CVC']")
    WebElement cvv;

    @FindBy(css = ".addCard")
    WebElement getAddcardbutton;

    @FindBy(css = "#cardAddedpopup1 .btn-send")
    WebElement getapprove;

    @FindBy(css = "#cardAddedpopup2 .payCmplt>h3")
    WebElement gettext;

    @FindBy(css = "#cardAddedpopup2 .btn")
    public WebElement getok;

    @FindBy(css = "#updatePopup .btn-send")
    WebElement getRemove;

    @FindBy(css = "#cardDeletedpopup .btn")
    WebElement closepopup;

    @FindBy(css = "#cardAddedpopup2 img[src='assets/images/Close icon.svg']")
    WebElement getclose;



    public void addCard(String card_holder_name,String card_number,String card_expdate,String card_cvv) throws InterruptedException {
        addcard.click();
        log.debug("Entering CardHolder's Name");
        holdername.sendKeys(card_holder_name);
        driver.switchTo().frame(cardnum_frame);
        log.debug("Entering Card number");
        cardnum.sendKeys(card_number);
        driver.switchTo().parentFrame();
        driver.switchTo().frame(cardexpdt_frame);
        log.debug("Entering Card's Expiry date");
        cardexpdt.sendKeys(card_expdate);
        driver.switchTo().parentFrame();
        driver.switchTo().frame(cardcvv_frame);
        log.debug("Entering CVV number");
        cvv.sendKeys(card_cvv);
        driver.switchTo().parentFrame();
        getAddcardbutton.click();
        log.info("Card Details Added Successfully");
        getapprove.click();
        log.info(gettext);
        wait.until(ExpectedConditions.visibilityOf(getok));
        getok.click();
    }
    public void deleteCard(){
        existcardoptions.click();
        dltcard.click();
        getRemove.click();
        wait.until(ExpectedConditions.visibilityOf(closepopup));
        closepopup.click();
    }


}
